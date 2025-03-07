package com.xerez4change.carretilla.arista;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AristaRepository extends CrudRepository<Arista, Integer> {
    List<Arista> findByOrigenId(int origenId);

}
