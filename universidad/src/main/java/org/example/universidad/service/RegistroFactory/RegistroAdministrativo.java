package org.example.universidad.service.RegistroFactory;

import org.example.universidad.model.Administrativo;
import org.example.universidad.model.Persona;
import org.example.universidad.repository.AdministrativoRepository;
import org.example.universidad.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistroAdministrativo implements Registro{

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @Override
    public Persona crearPersona(Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setCedula(persona.getCedula());
        nuevaPersona.setCorreo(persona.getCorreo());
        nuevaPersona.setTelefono(persona.getTelefono());
        nuevaPersona.setTipo(persona.getTipo());

        Administrativo administrativo = new Administrativo();
        administrativo.setPersona(nuevaPersona);
        administrativoRepository.save(administrativo);

        return nuevaPersona;
    }

    @Override
    public Persona eliminarPersona(Persona persona) {
        Administrativo administrativo = administrativoRepository.findAdministrativoByPersona(persona);
        if (administrativo != null) {
            administrativoRepository.delete(administrativo);
            return persona;
        }
        return null;
    }
}
