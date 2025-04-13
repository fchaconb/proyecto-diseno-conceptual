package org.example.universidad.repository;

import org.example.universidad.model.Matriculador;
import org.example.universidad.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculadorRepository extends JpaRepository<Matriculador, Long> {
    Matriculador findMatriculadorByPersona(Persona persona);
}
