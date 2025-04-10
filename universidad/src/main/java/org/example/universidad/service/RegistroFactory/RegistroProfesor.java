package org.example.universidad.service.RegistroFactory;

import org.example.universidad.model.Persona;
import org.example.universidad.model.Profesor;
import org.example.universidad.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistroProfesor implements Registro {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public Persona crearPersona(Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setCedula(persona.getCedula());
        nuevaPersona.setCorreo(persona.getCorreo());
        nuevaPersona.setTelefono(persona.getTelefono());

        Profesor profesor = new Profesor();
        profesor.setPersona(nuevaPersona);
        profesorRepository.save(profesor);

        return nuevaPersona;
    }
}
