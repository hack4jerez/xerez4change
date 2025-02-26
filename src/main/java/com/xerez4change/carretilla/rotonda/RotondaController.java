package com.xerez4change.carretilla.rotonda;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rotondas")
@Tag(name = "Rotondas", description = "Operaciones CRUD para las rotondas") // 🔹 Establece un orden
public class RotondaController {
    
    private final RotondaService rotondaService;

    public RotondaController(RotondaService rotondaService) {
        this.rotondaService = rotondaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las rotondas", description = "Retorna una lista de todas las rotondas almacenadas en la base de datos")
    public List<Rotonda> getAllRotondas() {
        return rotondaService.getAllRotondas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una rotonda", description = "Retorna una rotonda por su id")
    public Rotonda getRotondaById(int id) {
        return rotondaService.getRotondaById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una rotonda", description = "Agrega una nueva rotonda a la base de datos")
    public Rotonda saveRotonda(Rotonda rotonda) {
        return rotondaService.saveRotonda(rotonda);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una rotonda", description = "Modifica los datos de una rotonda existente")
    public ResponseEntity<Rotonda> updateRotonda(@PathVariable int id, @RequestBody Rotonda rotondaDetails) {
        Rotonda updatedRotonda = rotondaService.updateRotonda(rotondaDetails, id);
        return (updatedRotonda != null) ? ResponseEntity.ok(updatedRotonda) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una rotonda", description = "Elimina una rotonda de la base de datos")
    public void deleteRotonda(int id) {
        rotondaService.deleteRotonda(id);
    }
}
