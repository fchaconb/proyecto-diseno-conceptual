package org.example.universidad.controller;

import org.example.universidad.model.Curso;
import org.example.universidad.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/crear")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    @GetMapping("/listar")
    public List<Curso> listarCursos() {
        return cursoService.obtenerCursos();
    }

    @GetMapping("/listar/{codigo}")
    public Curso obtenerCursoPorCodigo(@PathVariable String codigo) {
        return cursoService.obtenerCursoPorCodigo(codigo);
    }

    @PutMapping("/actualizar/{codigo}")
    public Curso actualizarCurso(@PathVariable String codigo, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(codigo, curso);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCurso(@PathVariable String codigo) {
        cursoService.eliminarCurso(codigo);
    }
}
