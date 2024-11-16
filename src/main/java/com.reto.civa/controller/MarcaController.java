package com.reto.civa.controller;

import com.reto.civa.entity.Marca;
import com.reto.civa.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "api/v1/marcas")
@CrossOrigin(origins = "http://localhost:3000")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @GetMapping
    public List<Marca> getAllMarcas(){

        return marcaService.getAllMarcas();
    }

    @GetMapping("/{marcaId}")
    public Optional<Marca> getMarcaById(@PathVariable("marcaid") Long marcaId){
        return marcaService.getMarcaById(marcaId);
    }

    @PostMapping
    public void saveOrUpdateMarca(@RequestBody Marca marca){
        marcaService.saveOrUpdateMarca(marca);
    }

    @DeleteMapping("/{marcaId}")
    public void deleteMarca(@PathVariable("marcaId") Long marcaId){
        marcaService.deleteMarca(marcaId);
    }

}
