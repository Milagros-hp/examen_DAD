package org.example.rdcmmatricula.entity;

import jakarta.persistence.*;
import org.example.rdcmmatricula.dato.Curso;

@Entity
public class MatriculaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer cursoId;

    @Transient
    private Curso curso;

    public MatriculaDetalle() {}

    public MatriculaDetalle(Integer id, Integer cursoId) {
        this.id = id;
        this.cursoId = cursoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
