package com.xerez4change.carretilla.rotonda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xerez4change.carretilla.grafo.Grafo;
import com.xerez4change.carretilla.model.NamedEntity;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rotondas")
@Getter
@Setter
public class Rotonda extends NamedEntity {

    @OneToMany(mappedBy = "rotonda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VerticeRotonda> vertices;
    
    @ManyToOne
    private Grafo grafo;

    public Rotonda() {
    }

    public Rotonda(String name , List<VerticeRotonda> vertices, Grafo grafo) {
        this.setName(name); 
        this.vertices = vertices;
        this.grafo = grafo;
    }

    // Métodos para inicializar los vértices
    public void inicializarVertices() {
        if (vertices == null || vertices.isEmpty()) {
            for (int i = 1; i <= 4; i++) {
                vertices.add(new VerticeRotonda("Vértice" + i, this, this.grafo));
            }
        }
    }

}
