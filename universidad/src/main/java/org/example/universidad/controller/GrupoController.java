package org.example.universidad.controller;


import org.example.universidad.model.Grupo;
import org.example.universidad.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService; ;


    @PostMapping("/crear")
    public Grupo crear(@RequestBody Grupo grupo) {
        return grupoService.crearGrupo(grupo);
    }

    @GetMapping("/listar")
    public List<Grupo> listarGrupos() {
        return grupoService.obtenerGrupos();
    }

    @GetMapping("/listar/{codigo}")
    public Grupo listarGrupo(@PathVariable String codigo) {
        return grupoService.obtenerGrupoPorCodigo(codigo);
    }

    @PutMapping("/actualizar/{codigo}")
    public Grupo actualizarGrupo(@PathVariable String codigo, @RequestBody Grupo grupo) {
        return grupoService.actualizarGrupo(codigo, grupo);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarGrupo(@PathVariable String codigo) {
        grupoService.eliminarGrupo(codigo);
    }

    @PutMapping("/agregarAlumno/{codigo}/{cedula}")
    public Grupo agregarAlumnoAGrupo(@PathVariable String codigo, @PathVariable long cedula) {
        return grupoService.agregarAlumnoAGrupo(codigo, cedula);
    }

    @PutMapping("/eliminarAlumno/{codigo}/{cedula}")
    public Grupo eliminarAlumnoDeGrupo(@PathVariable String codigo, @PathVariable long cedula) {
        return grupoService.eliminarAlumnoDeGrupo(codigo, cedula);
    }
}
