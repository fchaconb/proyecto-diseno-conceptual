package org.example.universidad.controller;

import org.example.universidad.model.Nota;
import org.example.universidad.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping("/registrar")
    public Nota registrarNota(@RequestBody Nota nota) {
        return notaService.registrarNota(nota);
    }

    @GetMapping("/listar")
    public List<Nota> listarNotas() {
        return notaService.getNotas();
    }

    @GetMapping("/listar/{cedula}")
    public Nota listarNotas(@PathVariable long cedula) {
        return notaService.buscarNotaPorCedula(cedula);
    }

    @PutMapping("/modificar/{cedula}/{idCurso}")
    public Nota modificarNota(@PathVariable long cedula, @PathVariable String idCurso, @RequestBody Nota nota) {
        return notaService.modificarNota(cedula, idCurso, nota);
    }

    @DeleteMapping("/eliminar/{cedula}/{idCurso}")
    public void eliminarNota(@PathVariable long cedula, @PathVariable String idCurso) {
        notaService.eliminarNota(cedula, idCurso);
    }
}
