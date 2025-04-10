package org.example.universidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {

    @EmbeddedId
    private NotaKey id;
    private double nota;

    @ManyToOne
    @MapsId("idAlumno")
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @MapsId("codigoCurso")
    @JoinColumn(name = "codigo_curso")
    private Curso curso;

    public Nota() {
    }

    public Nota(NotaKey id, double nota) {
        this.id = id;
        this.nota = nota;
    }

    public NotaKey getId() {
        return id;
    }

    public void setId(NotaKey id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
