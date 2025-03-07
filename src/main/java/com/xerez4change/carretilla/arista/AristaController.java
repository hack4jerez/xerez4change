package com.xerez4change.carretilla.arista;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/aristas")
public class AristaController {

    private final AristaService aristaService;

    public AristaController(AristaService aristaService) {
        this.aristaService = aristaService;
    }

    @GetMapping
    public List<Arista> getAllAristas() {
        return aristaService.getAllAristas();
    }

    @PostMapping
    public Arista createArista(@RequestBody Arista arista) {
        return aristaService.saveArista(arista);
    }
}
