package com.xerez4change.carretilla.grafo;

import java.io.IOException;
import java.util.List;

import org.jgrapht.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xerez4change.carretilla.arista.Arista;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;

@RestController
@RequestMapping("/api/grafo")
public class GrafoController {

    @Autowired
    private GrafoService grafoService;

    @GetMapping("/mostrar/{id}")
    public String mostrarGrafo(@PathVariable int id) {
        Graph<VerticeRotonda, Arista> grafo = grafoService.printGrafo(id);

        StringBuilder sb = new StringBuilder();
        sb.append("Grafo generado:\n");

        sb.append("Vértices (").append(grafo.vertexSet().size()).append("):\n");
        for (VerticeRotonda v : grafo.vertexSet()) {
            sb.append(" - ").append(v.getName()).append("\n");
        }

        sb.append("\nAristas (").append(grafo.edgeSet().size()).append("):\n");
        for (Arista a : grafo.edgeSet()) {
            sb.append(" - ").append(a.getOrigen().getName())
              .append(" -> ").append(a.getDestino().getName())
              .append(" (distancia: ").append(a.getDistancia()).append(")\n");
        }

        return sb.toString();
    }

    @PostMapping("/crear")
    public ResponseEntity<Grafo> crearGrafo(@RequestParam String nombre) {
        Grafo grafo = grafoService.crearGrafo(nombre);
        return ResponseEntity.ok(grafo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grafo> obtenerGrafo(@PathVariable int id) {
        return ResponseEntity.ok(grafoService.obtenerGrafo(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Grafo>> obtenerTodosLosGrafos() {
        return ResponseEntity.ok(grafoService.obtenerTodosLosGrafos());
    }

    @GetMapping("/api/grafo/exportar/{id}")
    public ResponseEntity<String> exportarGrafo(@PathVariable int id) {
        try {
            grafoService.exportarGrafo(id);
            return ResponseEntity.ok("✅ Grafo exportado como 'grafo.png'");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("❌ Error exportando el grafo");
        }
    }
    
}


