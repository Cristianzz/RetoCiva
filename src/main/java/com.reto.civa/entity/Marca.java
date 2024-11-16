package com.reto.civa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marcaId;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
}
