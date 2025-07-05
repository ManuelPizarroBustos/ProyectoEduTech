package com.example.api_usuarios.models.requests;

import lombok.Data;

@Data
public class UsuarioUpdate {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String password;
}
