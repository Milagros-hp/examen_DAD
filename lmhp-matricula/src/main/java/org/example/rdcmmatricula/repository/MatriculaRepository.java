package org.example.rdcmmatricula.repository;

import org.example.rdcmmatricula.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}