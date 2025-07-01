package com.example.api_usuarios.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_usuarios.assemblers.UsuarioModelAssembler;
import com.example.api_usuarios.models.entities.Usuario;
import com.example.api_usuarios.models.requests.UsuarioCreate;
import com.example.api_usuarios.models.requests.UsuarioUpdate;
import com.example.api_usuarios.services.UsuarioService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioModelAssembler assembler;
    

    @GetMapping("/")
    public CollectionModel<EntityModel<Usuario>> obtenerTodos() {
        List<EntityModel<Usuario>> usuarios = usuarioService.obtenerTodos().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(usuarios,
            linkTo(methodOn(UsuarioController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Usuario> obtenerUno(@PathVariable int id) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        return assembler.toModel(usuario);
    }

    @PostMapping("/")
    public EntityModel<Usuario> registrar(@Valid @RequestBody UsuarioCreate body) {
        Usuario usuario = usuarioService.registrar(body);
        return assembler.toModel(usuario);
    }

    @PutMapping("/")
    public EntityModel<Usuario> actualizar(@Valid @RequestBody UsuarioUpdate body) {
        Usuario usuario = usuarioService.actualizar(body);
        return assembler.toModel(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
