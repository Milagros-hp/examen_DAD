package com.example.rdcmestudiante.service.impl;

import com.example.rdcmestudiante.entity.Estudiante;
import com.example.rdcmestudiante.repository.EstudianteRepository;
import com.example.rdcmestudiante.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> buscar(Integer id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        if (existePorDni(estudiante.getDni())) {
            throw new RuntimeException("El DNI ya está registrado.");
        }
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Integer id, Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public boolean existePorDni(String dni) {
        return estudianteRepository.existsByDni(dni);
    }
}
