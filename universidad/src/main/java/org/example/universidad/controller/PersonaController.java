package org.example.universidad.controller;

import org.example.universidad.dto.PersonaRequest;
import org.example.universidad.model.Persona;
import org.example.universidad.service.PersonaService;
import org.example.universidad.service.RegistroFactory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private RegistroFactory registroFactory;

    @PostMapping("/crear")
    public Persona createPersona(@RequestBody PersonaRequest personaRequest) {
        Persona persona = personaRequest.getPersona();
        String password = personaRequest.getPassword();
        Registro registro = registroFactory.getRegistro(persona.getTipo().toString());
        return personaService.crearPersona(registro, persona, password);
    }

    @GetMapping("/listar")
    public List<Persona> listarPersonas() {
        return personaService.obtenerPersonas();
    }

    @GetMapping("/listar/{cedula}")
    public Persona obtenerPersonaPorId(@PathVariable Long cedula) {
        return personaService.obtenerPersonaPorId(cedula);
    }

    @DeleteMapping("/eliminar/{cedula}")
    public void eliminarPersona(@PathVariable Long cedula) {
        personaService.eliminarPersona(cedula);
    }

    @PutMapping("/actualizar/{cedula}")
    public Persona actualizarPersona(@PathVariable Long cedula, @RequestBody Persona persona) {
        return personaService.actualizarPersona(cedula, persona);
    }
}
