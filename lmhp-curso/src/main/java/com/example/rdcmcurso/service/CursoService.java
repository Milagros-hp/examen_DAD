package com.example.rdcmcurso.service;

import com.example.rdcmcurso.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    Optional<Curso> buscar(Integer id);
    Curso guardar(Curso curso);
    Curso actualizar(Integer id, Curso curso);
    void eliminar(Integer id);
}
