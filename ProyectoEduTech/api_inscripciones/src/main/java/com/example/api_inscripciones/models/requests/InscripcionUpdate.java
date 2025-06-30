package com.example.api_inscripciones.models.requests;

import lombok.Data;

@Data
public class InscripcionUpdate {
    private int id;

    private String usuarioId;
    private String cursoId;
    private String estado;
}
