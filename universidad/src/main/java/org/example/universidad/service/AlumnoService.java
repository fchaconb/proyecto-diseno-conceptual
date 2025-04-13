package org.example.universidad.service;

import org.example.universidad.model.Alumno;
import org.example.universidad.model.Carrera;
import org.example.universidad.repository.AlumnoRepository;
import org.example.universidad.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Alumno> obtenerAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerAlumnoPorCedula(Long cedula) {
        return alumnoRepository.findByPersona_Cedula(cedula);
    }
}
