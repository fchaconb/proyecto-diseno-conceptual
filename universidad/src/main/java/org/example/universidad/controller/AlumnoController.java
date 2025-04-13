package org.example.universidad.controller;

import org.example.universidad.model.Alumno;
import org.example.universidad.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/listar")
    public List<Alumno> listarAlumnos() {
        return alumnoService.obtenerAlumnos();
    }

    @GetMapping("/listar/{cedula}")
    public Alumno obtenerAlumnoPorCedula(@PathVariable Long cedula) {
        return alumnoService.obtenerAlumnoPorCedula(cedula);
    }

}
