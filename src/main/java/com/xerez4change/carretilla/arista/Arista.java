package com.xerez4change.carretilla.arista;

import com.xerez4change.carretilla.model.BaseEntity;
import com.xerez4change.carretilla.rotonda.Rotonda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aristas")
@Getter
@Setter
public class Arista extends BaseEntity{
    
    @ManyToOne(optional = false)
    @JoinColumn(name="origen_id", referencedColumnName = "id")
    private Rotonda origen;

    @ManyToOne(optional = false)
    @JoinColumn(name="destino_id", referencedColumnName = "id")
    private Rotonda destino;

    @Column(nullable = false)
    private Double peso;

    public Arista() {
    }

    public Arista(Rotonda origen, Rotonda destino, Double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
}
