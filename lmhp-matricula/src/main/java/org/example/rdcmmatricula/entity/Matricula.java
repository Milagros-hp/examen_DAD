package org.example.rdcmmatricula.entity;

import jakarta.persistence.*;
import org.example.rdcmmatricula.dato.Estudiante;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer estudianteId;
    private LocalDate fecha;
    private Integer ciclo;

    @Transient
    private Estudiante estudiante;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id")  // clave foránea en MatriculaDetalle
    private List<MatriculaDetalle> detalles;

    public Matricula() {}

    public Matricula(Integer id, Integer estudianteId, Integer ciclo, LocalDate fecha, List<MatriculaDetalle> detalles) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    // === Getters y setters ===

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<MatriculaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MatriculaDetalle> detalles) {
        this.detalles = detalles;
    }
}
