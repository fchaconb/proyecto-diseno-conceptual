package org.example.universidad.service.RegistroFactory;

import org.example.universidad.model.Matriculador;
import org.example.universidad.model.Persona;
import org.example.universidad.repository.MatriculadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistroMatriculador implements Registro{
    @Autowired
    private MatriculadorRepository matriculadorRepository;

    @Override
    public Persona crearPersona(Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setCedula(persona.getCedula());
        nuevaPersona.setCorreo(persona.getCorreo());
        nuevaPersona.setTelefono(persona.getTelefono());
        nuevaPersona.setTipo(persona.getTipo());

        Matriculador matriculador = new Matriculador();
        matriculador.setPersona(nuevaPersona);
        matriculadorRepository.save(matriculador);

        return nuevaPersona;
    }

    @Override
    public Persona eliminarPersona(Persona persona) {
        Matriculador matriculador = matriculadorRepository.findMatriculadorByPersona(persona);
        if (matriculador != null) {
            matriculadorRepository.delete(matriculador);
            return persona;
        }
        return null;
    }
}
