package com.example.rdcmcurso.repository;

import com.example.rdcmcurso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
