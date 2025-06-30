package com.example.api_inscripciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_inscripciones.models.entities.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion,Integer> {
    
}
