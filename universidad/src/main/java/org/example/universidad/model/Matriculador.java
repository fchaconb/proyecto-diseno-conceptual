package org.example.universidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculador")
public class Matriculador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedulaPersona", referencedColumnName = "cedula")
    private Persona persona;

    public Matriculador() {
    }

    public Matriculador(long id, Persona persona) {
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
