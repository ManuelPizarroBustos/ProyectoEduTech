package com.example.api_cursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_cursos.models.entities.Curso;
import com.example.api_cursos.models.requests.CursoCreate;
import com.example.api_cursos.models.requests.CursoUpdate;
import com.example.api_cursos.services.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public List<Curso> obtenerTodos() {
        return cursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Curso obtenerUno(@PathVariable int id) {
        return cursoService.obtenerPorId(id);
    }

    @PostMapping("/")
    public Curso registrar(@Valid @RequestBody CursoCreate body) {
        return cursoService.registrar(body);
    }

    @PutMapping()
    public Curso actualizar(@Valid @RequestBody CursoUpdate body) {
        return cursoService.actualizar(body);
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        cursoService.eliminar(id);
        return "Eliminado";
    }
}
