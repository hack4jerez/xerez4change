package com.xerez4change.carretilla.rotonda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xerez4change.carretilla.model.NamedEntity;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    
    public Rotonda() {
    }

    public Rotonda(String name , List<VerticeRotonda> vertices) {
        this.setName(name); 
        this.vertices = vertices;
    }
}
