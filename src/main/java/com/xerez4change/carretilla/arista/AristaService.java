package com.xerez4change.carretilla.arista;

import java.util.List;

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

    public Arista saveArista(Arista arista) {
        return aristaRepository.save(arista);
    }

    public void deleteArista(int id) {
        aristaRepository.deleteById(id);
    }

    public List<Arista> getAristasByOrigenId(int origenId) {
        return aristaRepository.findByOrigenId(origenId);
    }
}

