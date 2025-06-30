package com.example.api_inscripciones.models.requests;

import lombok.Data;

@Data
public class InscripcionUpdate {
    private int id;

    private int usuarioId;
    private int cursoId;
    private String estado;
}
