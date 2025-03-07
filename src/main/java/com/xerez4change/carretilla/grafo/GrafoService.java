package com.xerez4change.carretilla.grafo;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Factory;
import guru.nidi.graphviz.model.Node;
import guru.nidi.graphviz.model.MutableGraph;
import java.io.File;
import java.io.IOException;
import static guru.nidi.graphviz.model.Factory.*;

import com.xerez4change.carretilla.arista.Arista;
import com.xerez4change.carretilla.arista.AristaRepository;
import com.xerez4change.carretilla.arista.AristaService;
import com.xerez4change.carretilla.rotonda.Rotonda;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotondaRepository;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotondaService;

import guru.nidi.graphviz.engine.Graphviz;

import java.io.IOException;
import java.util.*;

@Service
public class GrafoService {

    private Graph<VerticeRotonda, Arista> grafo;

    @Autowired
    private GrafoRepository grafoRepository;

    @Autowired
    private VerticeRotondaRepository verticeRotondaRepository;

    @Autowired
    private AristaRepository aristaRepository;


    public GrafoService() {
        this.grafo = new DefaultDirectedWeightedGraph<>(Arista.class);
    }

    public void inicializarGrafo(int id){
        grafo = new DefaultDirectedWeightedGraph<>(Arista.class);
        System.out.println("✅ Grafo inicializado.");

        Grafo grafoActual = obtenerGrafo(id);
        List<VerticeRotonda> vertices = grafoActual.getVertices();
        for (VerticeRotonda vertice : vertices) {
            grafo.addVertex(vertice);
        }

        List<Arista> aristas = grafoActual.getAristas();
        for (Arista a : aristas) {
            grafo.addEdge(a.getOrigen(), a.getDestino(), a);
            grafo.setEdgeWeight(a, a.getDistancia());
        }
    }

    public Graph<VerticeRotonda, Arista> printGrafo(int id) {
        if (grafo.vertexSet().isEmpty()) {
            inicializarGrafo(id);
        }
        return grafo;
    }



    public void exportarGrafo(int id) throws IOException {
        if (grafo.vertexSet().isEmpty()) {
            inicializarGrafo(id);
        }
    
        // Creamos un grafo visual con Graphviz
        MutableGraph gvizGraph = mutGraph("Grafo").setDirected(true);
    
        Map<VerticeRotonda, Node> nodos = new HashMap<>();
        for (VerticeRotonda v : grafo.vertexSet()) {
            nodos.put(v, node(v.getName()));
        }
    
        for (Arista a : grafo.edgeSet()) {
            gvizGraph.add(nodos.get(a.getOrigen()).link(to(nodos.get(a.getDestino())).with(Label.of(String.valueOf(a.getDistancia())))));
        }
    
        Graphviz.fromGraph(gvizGraph).width(800).render(Format.PNG).toFile(new File("grafo.png"));
        System.out.println("📌 Grafo exportado a 'grafo.png'");
    }
    



    public Grafo crearGrafo(String nombre) {
        Grafo grafo = new Grafo(nombre);
        return grafoRepository.save(grafo);
    }

    public Grafo obtenerGrafo(int id) {
        return grafoRepository.findById(id).orElseThrow(() -> new RuntimeException("Grafo no encontrado"));
    }

    public List<Grafo> obtenerTodosLosGrafos() {
        return (List<Grafo>) grafoRepository.findAll();
    }

    public void agregarVertice(int grafoId, VerticeRotonda vertice) {
        Grafo grafo = obtenerGrafo(grafoId);
        vertice.setGrafo(grafo);
        verticeRotondaRepository.save(vertice);
    }

    public void agregarArista(int grafoId, Arista arista) {
        Grafo grafo = obtenerGrafo(grafoId);
        arista.setGrafo(grafo);
        aristaRepository.save(arista);
    }

    


/*
    private SimpleWeightedGraph<VerticeRotonda, DefaultWeightedEdge>  grafo;

    @Autowired
    private VerticeRotondaService verticeRotondaService;
    
    @Autowired
    private final AristaService aristaService;

    public GrafoService(AristaService aristaService) {
        this.aristaService = aristaService;
        this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    public void inicialirGrafo() {
        grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        System.out.println("✅ Grafo inicializado.");
    }

    
    // Carga las conexiones desde la base de datos.
     

    public void inicializarGrafo(List<VerticeRotonda> vertices) {
        // Agregar los vértices
        for (VerticeRotonda vertice : vertices) {
            grafo.addVertex(vertice);
        }

        // Recuperar aristas desde la BD y agregarlas al grafo
        List<Arista> aristas = aristaService.getAllAristas();
        for (Arista arista : aristas) {
            conectarVertices(arista.getOrigen(), arista.getDestino(), arista.getDistancia());
        }

        imprimirGrafo();
    }

    
    // Agrega una nueva arista y la guarda en la base de datos.
    
    public void agregarConexion(VerticeRotonda v1, VerticeRotonda v2, double distancia) {
        conectarVertices(v1, v2, distancia);
        aristaService.saveArista(new Arista(v1, v2, distancia));
    }

    
    // Agrega una Rotonda al grafo, añadiendo sus 4 vértices.
    
    public void agregarRotonda(Rotonda rotonda) {
        for (VerticeRotonda vertice : rotonda.getVertices()) {
            grafo.addVertex(vertice);
        }
    }
    
    
    // Conecta dos vértices con una arista y asigna la distancia (peso).
    
    public void conectarVertices(VerticeRotonda v1, VerticeRotonda v2, double distancia) {
        grafo.addVertex(v1);
        grafo.addVertex(v2);
        DefaultWeightedEdge arista = grafo.addEdge(v1, v2);
        if (arista != null) {
            grafo.setEdgeWeight(arista, distancia);
        }
    }

    
    // Devuelve la distancia mínima entre dos vértices usando Dijkstra.
    
    public double obtenerDistanciaMinima(VerticeRotonda origen, VerticeRotonda destino) {
        DijkstraShortestPath<VerticeRotonda, DefaultWeightedEdge> dijkstra =
                new DijkstraShortestPath<>(grafo);
        return dijkstra.getPathWeight(origen, destino);
    }

    
    // Devuelve los vecinos de un vértice (vértices conectados).
    
    public Set<VerticeRotonda> obtenerVecinos(VerticeRotonda vertice) {
        return Graphs.neighborSetOf(grafo, vertice);
    }

    
    // Devuelve todas las conexiones del grafo.
    
    public Map<VerticeRotonda, Map<VerticeRotonda, Double>> obtenerGrafo() {
        Map<VerticeRotonda, Map<VerticeRotonda, Double>> conexiones = new HashMap<>();
        for (VerticeRotonda vertice : grafo.vertexSet()) {
            Map<VerticeRotonda, Double> adyacentes = new HashMap<>();
            for (DefaultWeightedEdge edge : grafo.edgesOf(vertice)) {
                VerticeRotonda vecino = Graphs.getOppositeVertex(grafo, edge, vertice);
                adyacentes.put(vecino, grafo.getEdgeWeight(edge));
            }
            conexiones.put(vertice, adyacentes);
        }
        return conexiones;
    }
    
    public void imprimirGrafo() {
        System.out.println("🔍 Grafo generado:");
        
        if (grafo == null) {
            System.out.println("❌ El grafo no ha sido inicializado.");
            return;
        }
    
        Set<VerticeRotonda> vertices = grafo.vertexSet();
        System.out.println("Vértices (" + vertices.size() + "):");
        for (VerticeRotonda v : vertices) {
            System.out.println(" - " + v.getName());
        }
    
        Set<DefaultWeightedEdge> aristas = grafo.edgeSet();
        System.out.println("Aristas (" + aristas.size() + "):");
        for (DefaultWeightedEdge e : aristas) {
            VerticeRotonda origen = grafo.getEdgeSource(e);
            VerticeRotonda destino = grafo.getEdgeTarget(e);
            double peso = grafo.getEdgeWeight(e);
            System.out.println(" - " + origen.getName() + " -> " + destino.getName() + " (Distancia: " + peso + ")");
        }
    }
        */
}
    

