package com.xerez4change.carretilla.rotondaVertice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerticeRotondaRepository extends CrudRepository<VerticeRotonda, Integer> {
    
    List<VerticeRotonda> findByRotondaId(int rotondaId);
}
