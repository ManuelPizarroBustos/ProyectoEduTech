package com.example.api_inscripciones.models.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int usuarioId;

    @Column(nullable = false,unique = true)
    private int cursoId;

    @Column(nullable = false)
    private String estado;
}
    