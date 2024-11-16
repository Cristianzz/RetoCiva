package com.reto.civa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(name = "numero_bus", nullable = false)
    private String numeroBus;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "caracteristicas")
    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "marcaId", nullable = false)
    private Marca marca;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}



