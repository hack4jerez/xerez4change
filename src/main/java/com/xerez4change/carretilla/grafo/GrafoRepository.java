package com.xerez4change.carretilla.grafo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrafoRepository extends CrudRepository<Grafo, Integer> {
    
}
