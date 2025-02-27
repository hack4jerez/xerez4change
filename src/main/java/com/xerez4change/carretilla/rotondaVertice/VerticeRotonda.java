package com.xerez4change.carretilla.rotondaVertice;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    public VerticeRotonda() {}

    public VerticeRotonda(String name, Rotonda rotonda) {
        this.name = name;
        this.rotonda = rotonda;
    }
}
