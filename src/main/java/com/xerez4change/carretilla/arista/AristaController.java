package com.xerez4change.carretilla.arista;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/api/aristas")
@Tag(name = "Aristas", description = "Operaciones CRUD para las aristas") 
public class AristaController {

    private final AristaService aristaService;

    private AristaController(AristaService aristaService) {
        this.aristaService = aristaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las aristas", description = "Devuelve una lista con todas las conexiones entre rotondas")
    public List<Arista> getAllAristas() {
        return aristaService.getAllAristas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una arista por ID", description = "Busca una conexión entre rotondas según su ID")
    public ResponseEntity<Arista> getArista(@PathVariable int id) {
        Optional<Arista> arista = aristaService.getArista(id);
        return arista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("desde/{origen_id}")
    @Operation(summary = "Obtener aristas desde una rotonda", description = "Lista las conexiones que parten de una rotonda específica")
    public List<Arista> getAristaDesdeRotonda(@PathVariable int origen_id) {
        return aristaService.getAristaDesdeRotonda(origen_id);
    }

    @PostMapping
    @Operation(summary = "Crear una arista", description = "Crea una conexión entre dos rotondas")  
    public Arista saveArista(Arista arista) {
        return aristaService.saveArista(arista);
    }

    @PutMapping("/{id}")   
    @Operation(summary = "Actualizar una arista", description = "Modifica los datos de una conexión entre rotondas")        
    public ResponseEntity<Arista> updateArista(@PathVariable int id, @RequestBody Arista newArista) {
        Arista updatedArista = aristaService.updateArista(id, newArista);
        return (updatedArista != null) ? ResponseEntity.ok(updatedArista) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una arista", description = "Elimina una conexión entre rotondas")
    public void deleteArista(@PathVariable int id) {
        aristaService.deleteArista(id);    
    }


    
}
