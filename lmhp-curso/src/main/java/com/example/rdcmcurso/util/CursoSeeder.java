package com.example.rdcmcurso.util;

import com.example.rdcmcurso.entity.Curso;
import com.example.rdcmcurso.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CursoSeeder implements CommandLineRunner {

    private final CursoRepository cursoRepository;

    public CursoSeeder(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) {
        // Verificamos si ya existen datos para no duplicar
        if (cursoRepository.count() == 0) {
            Curso curso1 = new Curso(null, "Matemáticas Avanzadas", "Lunes y Miércoles 9:00 - 11:00", 30, "MAT101", 1);
            Curso curso2 = new Curso(null, "Programación en Java", "Martes y Jueves 10:00 - 12:00", 25, "JAVA102", 2);
            Curso curso3 = new Curso(null, "Física General", "Lunes y Miércoles 14:00 - 16:00", 20, "FIS103", 1);

            // Guardamos los cursos en la base de datos
            cursoRepository.save(curso1);
            cursoRepository.save(curso2);
            cursoRepository.save(curso3);

            System.out.println("Datos de cursos insertados correctamente.");
        } else {
            System.out.println("Los cursos ya existen, no se insertaron datos.");
        }
    }
}
