package com.xerez4change.carretilla.arista;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xerez4change.carretilla.grafo.Grafo;
import com.xerez4change.carretilla.model.BaseEntity;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aristas")
@Getter
@Setter
public class Arista extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "origen_id", nullable = false)
    @JsonIgnoreProperties({"aristasSalientes", "aristasEntrantes"}) 
    private VerticeRotonda origen;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    @JsonIgnoreProperties({"aristasSalientes", "aristasEntrantes"}) 
    private VerticeRotonda destino;

    @ManyToOne
    @JoinColumn(name = "grafo_id")  
    @JsonBackReference  // Relación con Grafo
    private Grafo grafo;

    private Double distancia;

    public Arista() {
    }

    public Arista(VerticeRotonda origen, VerticeRotonda destino, Double distancia, Grafo grafo) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.grafo = grafo;
    }

    
}
