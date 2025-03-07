package com.xerez4change.carretilla.grafo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xerez4change.carretilla.arista.Arista;
import com.xerez4change.carretilla.model.NamedEntity;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grafos")
@Getter
@Setter
public class Grafo extends NamedEntity {

    @OneToMany(mappedBy = "grafo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VerticeRotonda> vertices;

    @OneToMany(mappedBy = "grafo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Arista> aristas;

    public Grafo() {}

    public Grafo(String name) {
        this.setName(name);
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    public Grafo(String name, List<VerticeRotonda> vertices, List<Arista> aristas) {
        this.setName(name);
        this.vertices = vertices;
        this.aristas = aristas;
    }
    
}
