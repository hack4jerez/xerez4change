package com.xerez4change.carretilla.rotondaVertice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xerez4change.carretilla.grafo.GrafoService;



@Service
public class VerticeRotondaService {

    private final VerticeRotondaRepository verticeRotondaRepository;
    private final GrafoService grafoService;
    public VerticeRotondaService(VerticeRotondaRepository verticeRotondaRepository, GrafoService grafoService) {
        this.grafoService = grafoService;
        this.verticeRotondaRepository = verticeRotondaRepository;
    }
    /* 
    @PostConstruct
    public void inicializarGrafo() {
        List<VerticeRotonda> vertices = (List<VerticeRotonda>)  verticeRotondaRepository.findAll();
        grafoService.inicializarGrafo(vertices);
    } */

    public List<VerticeRotonda> getAllVertices() {
        return (List<VerticeRotonda>) verticeRotondaRepository.findAll();
    }

    public List<VerticeRotonda> getVerticesByRotonda(int rotondaId) {
        return verticeRotondaRepository.findByRotondaId(rotondaId);
    }

    public VerticeRotonda saveVertice(VerticeRotonda vertice) {
        return verticeRotondaRepository.save(vertice);
    }

    public void deleteVertice(int id) {
        verticeRotondaRepository.deleteById(id);
    }
}
