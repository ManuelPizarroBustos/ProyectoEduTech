package com.example.api_cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_usuarios.models.entities.Curso;
import com.example.api_usuarios.models.requests.CursoCreate;
import com.example.api_usuarios.models.requests.CursoUpdate;
import com.example.api_usuarios.repositories.CursoRepository;

@Service
public class CursoService{
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodos(){
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso obtenerPorId(int id){
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso registrar(CursoCreate curso){
        try {
            Curso nuevoCurso = new Curso();
            nuevoCurso.setTitulo(curso.getTitulo());
            nuevoCurso.setDescripcion(curso.getDescripcion());

            return cursoRepository.save(nuevoCurso);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Curso Registrado");
        }
    }

    public Curso actualizar(CursoUpdate body) {
        Curso curso = cursoRepository.findById(body.getId()).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
        }

        if(body.getTitulo() != null) {
            curso.setTitulo(body.getTitulo());
        }
        
        if(body.getDescripcion() != null) {
            curso.setDescripcion(body.getDescripcion());
        }

        return cursoRepository.save(curso);
    }

    public void eliminar(int id){
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
        }
        cursoRepository.delete(curso);
    
    }
}