package com.example.api_cursos.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoCreate {
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
}
