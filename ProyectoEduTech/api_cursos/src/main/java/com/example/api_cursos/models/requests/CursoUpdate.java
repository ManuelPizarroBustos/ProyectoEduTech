package com.example.api_cursos.models.requests;

import lombok.Data;

@Data
public class CursoUpdate {
    private int id;

    private String titulo;
    private String descripcion;
}
