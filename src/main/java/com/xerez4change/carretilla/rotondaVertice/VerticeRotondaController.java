package com.xerez4change.carretilla.rotondaVertice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vertices")
public class VerticeRotondaController {

    private final VerticeRotondaService verticeRotondaService;

    public VerticeRotondaController(VerticeRotondaService verticeRotondaService) {
        this.verticeRotondaService = verticeRotondaService;
    }

    @GetMapping
    public List<VerticeRotonda> getAllVertices() {
        return verticeRotondaService.getAllVertices();
    }

    @GetMapping("/rotonda/{rotondaId}")
    public List<VerticeRotonda> getVerticesByRotonda(@PathVariable int rotondaId) {
        return verticeRotondaService.getVerticesByRotonda(rotondaId);
    }
}
