package org.example.universidad.service.RegistroFactory;

import org.example.universidad.model.Persona;

public interface Registro {
    Persona crearPersona(Persona persona);
    Persona eliminarPersona(Persona persona);
}
