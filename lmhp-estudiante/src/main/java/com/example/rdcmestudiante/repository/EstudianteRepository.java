package com.example.rdcmestudiante.repository;

import com.example.rdcmestudiante.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    boolean existsByDni(String dni);  // Verificar si el DNI ya está registrado
}
