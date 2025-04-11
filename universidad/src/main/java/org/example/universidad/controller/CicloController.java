package org.example.universidad.controller;

import org.example.universidad.model.Ciclo;
import org.example.universidad.service.CicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciclos")
public class CicloController {

    @Autowired
    private CicloService cicloService;

    @PostMapping("/crear")
    public Ciclo crearCiclo(@RequestBody Ciclo ciclo) {
        return cicloService.crearCiclo(ciclo);
    }

    @GetMapping("/listar")
    public List<Ciclo> listarCiclos() {
        return cicloService.obtenerCiclos();
    }

    @GetMapping("/listar/{codigo}")
    public Ciclo obtenerCicloPorCodigo(@PathVariable String codigo) {
        return cicloService.obtenerCicloPorCodigo(codigo);
    }

    @PutMapping("/actualizar/{codigo}")
    public Ciclo actualizarCiclo(@PathVariable String codigo, @RequestBody Ciclo ciclo) {
        return cicloService.actualizarCiclo(codigo, ciclo);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCiclo(@PathVariable String codigo) {
        cicloService.eliminarCiclo(codigo);
    }
}
