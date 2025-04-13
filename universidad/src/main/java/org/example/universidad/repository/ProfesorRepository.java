package org.example.universidad.repository;

import org.example.universidad.model.Persona;
import org.example.universidad.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Profesor findProfesorByPersona(Persona persona);
}
