package org.example.universidad.dto;

import org.example.universidad.model.Persona;

public class PersonaRequest {
    private Persona persona;
    private String password;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
