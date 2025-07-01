package com.example.api_usuarios.models.entities;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;
}
    