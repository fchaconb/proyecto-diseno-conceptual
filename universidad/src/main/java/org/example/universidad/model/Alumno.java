package org.example.universidad.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedulaPersona", referencedColumnName = "cedula")
    private Persona persona;

    @ManyToMany(mappedBy = "alumnos")
    private Set<Carrera> carreras;

    @OneToMany(mappedBy = "alumno")
    private Set<Nota> notas;

    @ManyToMany(mappedBy = "alumnosCurso")
    private Set<Grupo> grupos;

    public Alumno() {
    }

    public Alumno(long id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
