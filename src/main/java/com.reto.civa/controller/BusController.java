package com.reto.civa.controller;

import com.reto.civa.entity.Bus;
import com.reto.civa.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/buses")
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {
    @Autowired
    private BusService busService;
    @GetMapping
    public List<Bus> getAll(){
        return busService.getAllBuses();
    }

    @GetMapping("/{busId}")
    public Optional<Bus> getBusId(@PathVariable("busId") Long busId){
        return busService.getBusId(busId);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateBus(@RequestBody Bus bus) {
        try {
            Bus savedBus = busService.saveOrUpdateBus(bus);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud.");
        }
    }
    @DeleteMapping("/{busId}")
    private void deleteMarca(@PathVariable("busId") Long busId){
        busService.deleteBus(busId);
    }

}
