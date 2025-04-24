package org.example.rdcmmatricula.service.impl;

import org.example.rdcmmatricula.dato.Curso;
import org.example.rdcmmatricula.dato.Estudiante;
import org.example.rdcmmatricula.entity.Matricula;
import org.example.rdcmmatricula.entity.MatriculaDetalle;
import org.example.rdcmmatricula.feign.CursoFeign;
import org.example.rdcmmatricula.feign.EstudianteFeign;
import org.example.rdcmmatricula.repository.MatriculaRepository;
import org.example.rdcmmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private EstudianteFeign estudianteFeign;

    @Autowired
    private CursoFeign cursoFeign;

    @Override
    public List<Matricula> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Matricula> obtener(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Matricula registrar(Matricula matricula) {
        Estudiante estudiante = estudianteFeign.obtenerPorId(matricula.getEstudianteId()).getBody();
        if (estudiante == null || !"Activo".equals(estudiante.getEstado())) {
            throw new RuntimeException("Estudiante no válido o inactivo");
        }

        // Usamos el ciclo del estudiante para guardar
        matricula.setCiclo(estudiante.getCiclo());
        matricula.setFecha(LocalDate.now());

        for (MatriculaDetalle detalle : matricula.getDetalles()) {
            Curso curso = cursoFeign.obtenerPorId(detalle.getCursoId()).getBody();
            if (curso == null || curso.getCapacidad() <= 0) {
                throw new RuntimeException("Curso no disponible o sin capacidad");
            }
            // opcional: setCurso, si quieres mostrar luego
            detalle.setCurso(curso);
        }

        return repository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
