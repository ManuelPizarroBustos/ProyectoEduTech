package com.example.api_usuarios.controllers;

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

import com.example.api_usuarios.models.entities.Usuario;
import com.example.api_usuarios.models.requests.UsuarioCreate;
import com.example.api_usuarios.models.requests.UsuarioUpdate;
import com.example.api_usuarios.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUno(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping("/")
    public Usuario registrar(@Valid @RequestBody UsuarioCreate body) {
        return usuarioService.registrar(body);
    }

    @PutMapping()
    public Usuario actualizar(@Valid @RequestBody UsuarioUpdate body) {
        return usuarioService.actualizar(body);
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        usuarioService.eliminar(id);
        return "Eliminado";
    }
}
