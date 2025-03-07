package com.xerez4change.carretilla.rotondaVertice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xerez4change.carretilla.arista.Arista;
import com.xerez4change.carretilla.grafo.Grafo;
import com.xerez4change.carretilla.rotonda.Rotonda;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vertices_rotonda")
@Getter
@Setter
public class VerticeRotonda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "rotonda_id", nullable = false)
    @JsonBackReference
    private Rotonda rotonda;

    @ManyToOne
    @JoinColumn(name = "grafo_id")  
    @JsonBackReference
    private Grafo grafo;

    @OneToMany(mappedBy = "origen", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("origen")
    private List<Arista> aristasSalientes;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("destino")
    private List<Arista> aristasEntrantes;

    public VerticeRotonda() {}

    public VerticeRotonda(String name, Rotonda rotonda, Grafo grafo) {
        this.name = name;
        this.rotonda = rotonda;
        this.grafo = grafo;
    }

    /*public void agregarConexion(VerticeRotonda destino, double peso) {
        Arista arista = new Arista(this, destino, peso);
        this.aristasSalientes.add(arista);
        destino.getAristasEntrantes().add(arista);
    }*/
}
