package org.example.universidad.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(unique = true, nullable = false, name = "cedula")
    private long cedula;
    private String nombre;
    private String correo;
    private long telefono;
    private TipoPersona tipo;

    @OneToOne(mappedBy = "persona")
    @JsonBackReference
    private Usuario usuario;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Administrativo administrativo;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Matriculador matriculador;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Profesor profesor;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Alumno alumno;

    public Persona() {
    }

    public Persona(long cedula, String nombre, String correo, long telefono, TipoPersona tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public TipoPersona getTipo() {
        return tipo;
    }
    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public Matriculador getMatriculador() {
        return matriculador;
    }

    public void setMatriculador(Matriculador matriculador) {
        this.matriculador = matriculador;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
