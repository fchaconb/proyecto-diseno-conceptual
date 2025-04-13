package org.example.universidad.service;

import org.example.universidad.model.Persona;
import org.example.universidad.model.Usuario;
import org.example.universidad.repository.PersonaRepository;
import org.example.universidad.service.RegistroFactory.Registro;
import org.example.universidad.service.RegistroFactory.RegistroFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RegistroFactory registroFactory;

    @Autowired
    private UsuarioService usuarioService;

    public Persona crearPersona(Registro registro, Persona persona, String password) {
        Persona nuevaPersona = registro.crearPersona(persona);
        usuarioService.crearUsuario(new Usuario(nuevaPersona.getCorreo(), password, nuevaPersona.getTipo(), nuevaPersona));
        return personaRepository.save(nuevaPersona);
    }

    public List<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    public Persona obtenerPersonaPorId(Long cedula) {
        return personaRepository.findById(cedula).orElse(null);
    }

    public void eliminarPersona(Long cedula) {
        Persona persona = obtenerPersonaPorId(cedula);
        if (persona == null) {
            throw new RuntimeException("Persona no encontrada");
        } else {
            Registro registro = registroFactory.getRegistro(persona.getTipo().toString());
            if (registro != null) {
                registro.eliminarPersona(persona);
            } else {
                throw new RuntimeException("Registro no encontrado");
            }
        }
        personaRepository.deleteById(cedula);
    }

    public Persona actualizarPersona(Long cedula, Persona persona) {
        Persona personaExistente = obtenerPersonaPorId(cedula);
        if (personaExistente != null) {
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setCorreo(persona.getCorreo());
            personaExistente.setTelefono(persona.getTelefono());
            personaExistente.setTipo(persona.getTipo());
            return personaRepository.save(personaExistente);
        }
        return null;
    }

}
