package com.reto.civa.service;

import com.reto.civa.entity.Bus;
import com.reto.civa.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    BusRepository busRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusId(Long id){
        return busRepository.findById(id);
    }

    public Bus saveOrUpdateBus(Bus bus) {
        try {
            return busRepository.save(bus);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Error: El bus con ese número o placa ya existe.");
        }
    }

    public void deleteBus(Long id){
        busRepository.deleteById(id);
    }

}
