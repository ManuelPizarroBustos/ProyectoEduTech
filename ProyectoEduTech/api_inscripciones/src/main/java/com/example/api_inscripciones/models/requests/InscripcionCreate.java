package com.example.api_inscripciones.models.requests;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InscripcionCreate {
    
    @NotBlank
    private String usuarioId;
    
    @NotBlank
    private String cursoId;

    @NotBlank
    private String estado;
}
