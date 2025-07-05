package com.example.api_usuarios.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;

    
    @Column(nullable = false)
    private String telefono;
    
    @JsonIgnore
    @Column(nullable = false)
    private String password;
}
    