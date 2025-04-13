package org.example.universidad.controller;

import org.example.universidad.model.Carrera;
import org.example.universidad.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @PostMapping("/crear")
    public Carrera crearCarrera(@RequestBody Carrera carrera) {
        return carreraService.crearCarrera(carrera);
    }

    @GetMapping("/listar")
    public List<Carrera> listarCarreras() {
        return carreraService.obtenerCarreras();
    }

    @GetMapping("/listar/{codigo}")
    public Carrera obtenerCarreraPorCodigo(@PathVariable String codigo) {
        return carreraService.obtenerCarreraPorCodigo(codigo);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCarrera(@PathVariable String codigo) {
        carreraService.eliminarCarrera(codigo);
    }

    @PutMapping("/actualizar/{codigo}")
    public Carrera actualizarCarrera(@PathVariable String codigo, @RequestBody Carrera carrera) {
        return carreraService.actualizarCarrera(codigo, carrera);
    }

    @PutMapping("/agregarAlumno/{cedula}/{codigoCarrera}")
    public Carrera agregarAlumnoACarrera(@PathVariable long cedula, @PathVariable String codigoCarrera) {
        return carreraService.agregarAlumnoACarrera(cedula, codigoCarrera);
    }

    @PutMapping("/eliminarAlumno/{cedula}/{codigoCarrera}")
    public Carrera eliminarAlumnoDeCarrera(@PathVariable long cedula, @PathVariable String codigoCarrera) {
        return carreraService.eliminarAlumnoDeCarrera(cedula, codigoCarrera);
    }

    @PutMapping("/agregarCiclo/{codigoCarrera}/{codigoCiclo}")
    public Carrera agregarCicloACarrera(@PathVariable String codigoCarrera, @PathVariable String codigoCiclo) {
        return carreraService.agregarCicloACarrera(codigoCarrera, codigoCiclo);
    }

    @PutMapping("/eliminarCiclo/{codigoCarrera}/{codigoCiclo}")
    public Carrera eliminarCicloDeCarrera(@PathVariable String codigoCarrera, @PathVariable String codigoCiclo) {
        return carreraService.eliminarCicloDeCarrera(codigoCarrera, codigoCiclo);
    }
}
