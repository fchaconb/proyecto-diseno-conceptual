package org.example.universidad.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(unique = true, nullable = false, name = "usuario")
    private String usuario;
    private String contrasena;
    private TipoPersona rol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedulaPersona", referencedColumnName = "cedula")
    @JsonManagedReference
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena, TipoPersona rol, Persona persona) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoPersona getRol() {
        return rol;
    }

    public void setRol(TipoPersona rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
