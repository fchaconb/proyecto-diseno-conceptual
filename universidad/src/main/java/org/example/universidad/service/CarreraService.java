package org.example.universidad.service;

import org.example.universidad.model.Alumno;
import org.example.universidad.model.Carrera;
import org.example.universidad.model.Ciclo;
import org.example.universidad.repository.AlumnoRepository;
import org.example.universidad.repository.CarreraRepository;
import org.example.universidad.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CicloRepository cicloRepository;

    public Carrera crearCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public List<Carrera> obtenerCarreras() {
        return carreraRepository.findAll();
    }

    public Carrera obtenerCarreraPorCodigo(String codigo) {
        return carreraRepository.findById(codigo).orElse(null);
    }

    public void eliminarCarrera(String codigo) {
        carreraRepository.deleteById(codigo);
    }

    public Carrera actualizarCarrera(String codigo, Carrera carrera) {
        Carrera carreraExistente = obtenerCarreraPorCodigo(codigo);
        if (carreraExistente != null) {
            carreraExistente.setNombre(carrera.getNombre());
            carreraExistente.setTitulo(carrera.getTitulo());
            return carreraRepository.save(carreraExistente);
        }
        return null;
    }

    public Carrera agregarAlumnoACarrera(long cedula, String codigoCarrera){
        Alumno alumno = alumnoRepository.findByPersona_Cedula(cedula);
        if (alumno == null) {
            throw new RuntimeException("No se encontro el alumno con el cedula");
        }
        Carrera carrera = carreraRepository.findById(codigoCarrera).orElse(null);
        if (carrera == null) {
            throw new RuntimeException("No se encontro la carrera con el codigo");
        }
        carrera.getAlumnos().add(alumno);

        return carreraRepository.save(carrera);
    }

    public Carrera eliminarAlumnoDeCarrera(long cedula, String codigoCarrera){
        Alumno alumno = alumnoRepository.findByPersona_Cedula(cedula);
        if (alumno == null) {
            throw new RuntimeException("No se encontro el alumno con el cedula");
        }
        Carrera carrera = carreraRepository.findById(codigoCarrera).orElse(null);
        if (carrera == null) {
            throw new RuntimeException("No se encontro la carrera con el codigo");
        }
        carrera.getAlumnos().remove(alumno);

        return carreraRepository.save(carrera);
    }

    public Carrera agregarCicloACarrera(String codigoCarrera, String codigoCiclo) {
        Carrera carrera = carreraRepository.findById(codigoCarrera).orElse(null);
        if (carrera == null) {
            throw new RuntimeException("No se encontro la carrera con el codigo");
        }
        Ciclo ciclo = cicloRepository.findById(codigoCiclo).orElse(null);
        if (ciclo == null) {
            throw new RuntimeException("No se encontro el ciclo con el codigo");
        }
        carrera.getCiclos().add(ciclo);

        return carreraRepository.save(carrera);
    }

    public Carrera eliminarCicloDeCarrera(String codigoCarrera, String codigoCiclo) {
        Carrera carrera = carreraRepository.findById(codigoCarrera).orElse(null);
        if (carrera == null) {
            throw new RuntimeException("No se encontro la carrera con el codigo");
        }
        Ciclo ciclo = cicloRepository.findById(codigoCiclo).orElse(null);
        if (ciclo == null) {
            throw new RuntimeException("No se encontro el ciclo con el codigo");
        }
        carrera.getCiclos().remove(ciclo);

        return carreraRepository.save(carrera);
    }
}
