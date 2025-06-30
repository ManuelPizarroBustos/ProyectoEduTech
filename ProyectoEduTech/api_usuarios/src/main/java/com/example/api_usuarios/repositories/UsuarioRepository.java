package com.example.api_usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_usuarios.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    
}
