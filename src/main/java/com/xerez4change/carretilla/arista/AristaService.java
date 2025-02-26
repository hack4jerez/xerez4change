package com.xerez4change.carretilla.arista;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AristaService {

    private final AristaRepository aristaRepository;

    public AristaService(AristaRepository aristaRepository) {
        this.aristaRepository = aristaRepository;
    }

    public List<Arista> getAllAristas() {
        return (List<Arista>) aristaRepository.findAll();
    }

    public List<Arista> getAristaDesdeRotonda(int origen_id) {
        return aristaRepository.findByOrigenId(origen_id);
    }

    public Optional<Arista> getArista(int id) {
        return aristaRepository.findById(id);
    }

    public Arista saveArista(Arista arista) {
        return aristaRepository.save(arista);
    }

    public Arista updateArista(int id, Arista newArista){
        return aristaRepository.findById(id)
                .map(existingArista -> {
                    existingArista.setOrigen(newArista.getOrigen());
                    existingArista.setDestino(newArista.getDestino());
                    existingArista.setPeso(newArista.getPeso());
                    return aristaRepository.save(existingArista);
                })
                .orElse(null);
    }

    public void deleteArista(int id) {
        if (aristaRepository.findById(id).isPresent()){
            aristaRepository.deleteById(id);
        } else{
            throw new RuntimeException("No se encontro la arista con id: " + id);
        }
    }
    
}
