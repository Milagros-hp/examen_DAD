package com.example.rdcmestudiante.service;

import com.example.rdcmestudiante.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    List<Estudiante> listar();

    Optional<Estudiante> buscar(Integer id);

    Estudiante guardar(Estudiante estudiante);

    Estudiante actualizar(Integer id, Estudiante estudiante);

    void eliminar(Integer id);

    boolean existePorDni(String dni);  // Validación de DNI único
}
