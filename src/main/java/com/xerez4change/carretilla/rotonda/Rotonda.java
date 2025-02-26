package com.xerez4change.carretilla.rotonda;

import com.xerez4change.carretilla.model.NamedEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rotondas")
@Getter
@Setter
public class Rotonda extends NamedEntity {

    public Rotonda() {
    }

    public Rotonda(String name) {
        this.setName(name); 
    }
}
