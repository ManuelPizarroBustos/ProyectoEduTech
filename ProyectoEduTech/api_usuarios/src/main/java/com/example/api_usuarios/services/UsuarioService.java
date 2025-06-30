package com.example.api_usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_usuarios.models.entities.Usuario;
import com.example.api_usuarios.models.requests.UsuarioCreate;
import com.example.api_usuarios.models.requests.UsuarioUpdate;
import com.example.api_usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario registrar(UsuarioCreate usuario){
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(usuario.getNombre());
            nuevoUsuario.setEmail(usuario.getEmail());
            nuevoUsuario.setTelefono(usuario.getTelefono());

            return usuarioRepository.save(nuevoUsuario);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario registrado");
        }
    }

    public Usuario actualizar(UsuarioUpdate body) {
        Usuario usuario = usuarioRepository.findById(body.getId()).orElse(null);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        if(body.getNombre() != null) {
            usuario.setNombre(body.getNombre());
        }
        
        if(body.getTelefono() != null) {
            usuario.setTelefono(body.getTelefono());
        }
    
        return usuarioRepository.save(usuario);
    }

    public void eliminar(int id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        usuarioRepository.delete(usuario);
    
    }
}