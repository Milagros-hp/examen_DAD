package org.example.rdcmmatricula.dato;

public class Curso {
    private Integer id;
    private String nombre;
    private String horario;
    private Integer capacidad;
    private String codigo;
    private Integer ciclo;

    public Curso() {}

    public Curso(Integer id, String nombre, String horario, Integer capacidad, String codigo, Integer ciclo) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.codigo = codigo;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }
}
