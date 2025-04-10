package org.example.universidad.service;

import org.example.universidad.model.Persona;
import org.example.universidad.repository.PersonaRepository;
import org.example.universidad.service.RegistroFactory.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona crearPersona(Registro registro, Persona persona) {
        Persona nuevaPersona = registro.crearPersona(persona);
        return personaRepository.save(nuevaPersona);
    }

    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    public Persona obtenerPersonaPorId(Long cedula) {
        return personaRepository.findById(cedula).orElse(null);
    }

    public void eliminarPersona(Long cedula) {
        personaRepository.deleteById(cedula);
    }

    public Persona actualizarPersona(Long cedula, Persona persona) {
        Persona personaExistente = obtenerPersonaPorId(cedula);
        if (personaExistente != null) {
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setCorreo(persona.getCorreo());
            personaExistente.setTelefono(persona.getTelefono());
            return personaRepository.save(personaExistente);
        }
        return null;
    }

}
