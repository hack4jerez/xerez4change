package com.xerez4change.carretilla.rotonda;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class RotondaService {
    
    private final RotondaRepository rotondaRepository;

    public RotondaService(RotondaRepository rotondaRepository) {
        this.rotondaRepository = rotondaRepository;
    }

    public List<Rotonda> getAllRotondas() {
        return (List<Rotonda>) rotondaRepository.findAll();
    }

    public Rotonda getRotondaById(int id) {
        return rotondaRepository.findById(id).orElse(null);
    }

    public Rotonda saveRotonda(Rotonda rotonda) {
        return rotondaRepository.save(rotonda);
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
