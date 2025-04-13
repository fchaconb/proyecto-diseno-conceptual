package org.example.universidad.service.RegistroFactory;

import org.example.universidad.model.Alumno;
import org.example.universidad.model.Persona;
import org.example.universidad.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RegistroAlumno implements Registro {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Persona crearPersona(Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setCedula(persona.getCedula());
        nuevaPersona.setCorreo(persona.getCorreo());
        nuevaPersona.setTelefono(persona.getTelefono());
        nuevaPersona.setTipo(persona.getTipo());

        Alumno alumno = new Alumno();
        alumno.setPersona(nuevaPersona);
        alumnoRepository.save(alumno);

        return nuevaPersona;
    }

    @Override
    public Persona eliminarPersona(Persona persona) {
        Alumno alumno = alumnoRepository.findAlumnoByPersona(persona);
        if (alumno != null) {
            alumnoRepository.delete(alumno);
            return persona;
        }
        return null;
    }
}
