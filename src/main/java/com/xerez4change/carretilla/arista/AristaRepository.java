package com.xerez4change.carretilla.arista;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AristaRepository extends CrudRepository<Arista, Integer> {
    
    @Query("SELECT a FROM Arista a WHERE a.origen.id = ?1")
    List<Arista> findByOrigenId(int origen_id);
    


}
