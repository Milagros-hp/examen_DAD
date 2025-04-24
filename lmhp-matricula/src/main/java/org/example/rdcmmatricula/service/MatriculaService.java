package org.example.rdcmmatricula.service;

import org.example.rdcmmatricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> listar();
    Optional<Matricula> obtener(Integer id);
    Matricula registrar(Matricula matricula);
    void eliminar(Integer id);
}