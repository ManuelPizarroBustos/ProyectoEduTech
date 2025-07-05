package com.example.api_usuarios.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.api_usuarios.controllers.UsuarioControllerv2;
import com.example.api_usuarios.models.entities.Usuario;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

    
    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
            linkTo(methodOn(UsuarioControllerv2.class).obtenerUno(usuario.getId())).withSelfRel(),
            linkTo(methodOn(UsuarioControllerv2.class).obtenerTodos()).withRel("usuarios")
        );
    }
}
