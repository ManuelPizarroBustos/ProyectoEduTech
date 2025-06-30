package com.example.api_inscripciones.controllers;

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

import com.example.api_inscripciones.models.entities.Inscripcion;
import com.example.api_inscripciones.models.requests.InscripcionCreate;
import com.example.api_inscripciones.models.requests.InscripcionUpdate;
import com.example.api_inscripciones.services.InscripcionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    
    @Autowired
    private InscripcionService usuarioService;

    @GetMapping("/")
    public List<Inscripcion> obtenerTodos() {
        return inscripcionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public inscripcion obtenerUno(@PathVariable int id) {
        return inscripcionService.obtenerPorId(id);
    }

    @PostMapping("/")
    public Inscripcion registrar(@Valid @RequestBody InscripcionCreate body) {
        return inscripcionService.registrar(body);
    }

    @PutMapping()
    public Inscripcion actualizar(@Valid @RequestBody InscripcionUpdate body) {
        return inscripcionService.actualizar(body);
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        inscripcionService.eliminar(id);
        return "Eliminado";
    }
}
