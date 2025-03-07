package com.xerez4change.carretilla.rotonda;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xerez4change.carretilla.rotondaVertice.VerticeRotonda;
import com.xerez4change.carretilla.rotondaVertice.VerticeRotondaService;

@Service
public class RotondaService {
    
    private final RotondaRepository rotondaRepository;
    private final VerticeRotondaService verticeRotondaService;

    public RotondaService(RotondaRepository rotondaRepository, VerticeRotondaService verticeRotondaService) {
        this.rotondaRepository = rotondaRepository;
        this.verticeRotondaService = verticeRotondaService;
    }

    public List<Rotonda> getAllRotondas() {
        return (List<Rotonda>) rotondaRepository.findAll();
    }   

    public Rotonda getRotondaById(int id) {
        return rotondaRepository.findById(id).orElse(null);
    }

    public Rotonda saveRotonda(Rotonda rotonda) {
        Rotonda savedRotonda = rotondaRepository.save(rotonda);
        for (int i = 1; i <= 4; i++) {
            VerticeRotonda vertice = new VerticeRotonda("Vertice " + rotonda.getId() + "." + i, savedRotonda, savedRotonda.getGrafo());
            verticeRotondaService.saveVertice(vertice);
        }

        return savedRotonda;
    }

    public Rotonda updateRotonda(Rotonda rotonda, int rotondaId) {
        Rotonda toUpdate = rotondaRepository.findById(rotondaId).get();
        BeanUtils.copyProperties(rotonda, toUpdate, "id");
        return saveRotonda(toUpdate);
    }

    public void deleteRotonda(int id) {
        rotondaRepository.deleteById(id);
    }
}
