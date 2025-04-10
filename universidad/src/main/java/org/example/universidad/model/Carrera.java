package org.example.universidad.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @Column(unique = true, nullable = false, name = "codigo")
    private String codigo;
    private String nombre;
    private String titulo;

    @ManyToMany
    @JoinTable(name = "carrera_alumno",
            joinColumns = @JoinColumn(name = "codigo_carrera"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumnos;

    @ManyToMany
    @JoinTable(name = "carrera_ciclo",
            joinColumns = @JoinColumn(name = "codigo_carrera"),
            inverseJoinColumns = @JoinColumn(name = "codigo_ciclo"))
    private Set<Ciclo> ciclos;

    public Carrera() {}

    public Carrera(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
