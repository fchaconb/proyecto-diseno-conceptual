package org.example.universidad.model;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @Column(unique = true, nullable = false, name = "codigo")
    private String codigo;
    private String diaSemanal;
    private String horaInicio;
    private String horaFin;
    private int numeroGrupo;

    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id")
    private Profesor profesor;

    @ManyToMany
    @JoinTable(name = "grupo_alumno",
            joinColumns = @JoinColumn(name = "codigo_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumnosCurso;

    public Grupo() {
    }

    public Grupo(String codigo, String diaSemanal, String horaInicio, String horaFin, int numeroGrupo, Curso curso, Profesor profesor, Set<Alumno> alumnosCurso) {
        this.codigo = codigo;
        this.diaSemanal = diaSemanal;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.numeroGrupo = numeroGrupo;
        this.curso = curso;
        this.profesor = profesor;
        this.alumnosCurso = alumnosCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiaSemanal() {
        return diaSemanal;
    }

    public void setDiaSemanal(String diaSemanal) {
        this.diaSemanal = diaSemanal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Alumno> getAlumnosCurso() {
        return alumnosCurso;
    }

    public void setAlumnosCurso(Set<Alumno> alumnosCurso) {
        this.alumnosCurso = alumnosCurso;
    }
}
