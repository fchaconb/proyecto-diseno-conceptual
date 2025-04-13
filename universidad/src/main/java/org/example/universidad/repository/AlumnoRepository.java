package org.example.universidad.repository;

import org.example.universidad.model.Alumno;
import org.example.universidad.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Alumno findAlumnoByPersona(Persona persona);

    Alumno findByPersona_Cedula(long cedula);
}
