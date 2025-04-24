package com.example.rdcmestudiante.util;

import com.example.rdcmestudiante.entity.Estudiante;
import com.example.rdcmestudiante.repository.EstudianteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EstudianteSeeder implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;

    public EstudianteSeeder(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void run(String... args) {
        // Verificamos si ya existen datos para no duplicar
        if (estudianteRepository.count() == 0) {
            Estudiante estudiante1 = new Estudiante(null, "Juan Pérez", "Ingeniería", "Activo", 3, "12345678");
            Estudiante estudiante2 = new Estudiante(null, "María López", "Arquitectura", "Activo", 4, "87654321");
            Estudiante estudiante3 = new Estudiante(null, "Carlos Sánchez", "Medicina", "Activo", 2, "11223344");

            // Guardamos los estudiantes en la base de datos
            estudianteRepository.save(estudiante1);
            estudianteRepository.save(estudiante2);
            estudianteRepository.save(estudiante3);

            System.out.println("Datos de estudiantes insertados correctamente.");
        } else {
            System.out.println("Los estudiantes ya existen, no se insertaron datos.");
        }
    }
}
