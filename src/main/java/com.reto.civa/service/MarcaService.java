package com.reto.civa.service;

import com.reto.civa.entity.Marca;
import com.reto.civa.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> getMarcaById(Long id) {
        return marcaRepository.findById(id);
    }

    public void saveOrUpdateMarca(Marca marca) {
        marcaRepository.save(marca);
    }

    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
