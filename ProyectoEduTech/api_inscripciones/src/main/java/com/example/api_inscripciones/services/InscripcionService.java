package com.example.api_inscripciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_inscripciones.models.entities.Inscripcion;
import com.example.api_inscripciones.models.requests.InscripcionCreate;
import com.example.api_inscripciones.models.requests.InscripcionUpdate;
import com.example.api_inscripciones.repositories.InscripcionRepository;

@Service
public class InscripcionService{
    
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> obtenerTodos(){
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerPorId(int id){
        return inscripcionRepository.findById(id).orElse(null);
    }

    public Inscripcion registrar(InscripcionCreate inscripcion){
        try {
            Inscripcion nuevaInscripcion = new Inscripcion();
            nuevaInscripcion.setUsuarioId(inscripcion.getUsuarioId());
            nuevaInscripcion.setCursoId(inscripcion.getCursoId());
            nuevaInscripcion.setEstado(inscripcion.getEstado());

            return inscripcionRepository.save(nuevaInscripcion);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Inscripcion Registrada");
        }
    }

    public Inscripcion actualizar(InscripcionUpdate body) {
        Inscripcion inscripcion = inscripcionRepository.findById(body.getId()).orElse(null);
        if (inscripcion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripcion no encontrada");
        }

        if(body.getUsuarioId() != null) {
            inscripcion.setUsuarioId(body.getUsuarioId());
        }
        
        if(body.getCursoId() != null) {
            inscripcion.setCursoId(body.getCursoId());
        }

        return inscripcionRepository.save(inscripcion);
    }

    public void eliminar(int id){
        Inscripcion inscripcion = inscripcionRepository.findById(id).orElse(null);
        if (inscripcion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripcion no encontrada");
        }
        inscripcionRepository.delete(inscripcion);
    
    }
}