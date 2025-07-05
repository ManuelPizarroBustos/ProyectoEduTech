package com.example.api_usuarios.models.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioCreate {
    
    
    private int id; 

    @NotBlank
    private String nombre;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefono;
    
    @NotBlank
    private String password;
}
