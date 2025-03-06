package com.xerez4change.carretilla.arista;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference("origen")
    private VerticeRotonda origen;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    @JsonBackReference("destino")
    private VerticeRotonda destino;


    private Double distancia;

    public Arista() {
    }

    public Arista(VerticeRotonda origen, VerticeRotonda destino, Double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    
}
