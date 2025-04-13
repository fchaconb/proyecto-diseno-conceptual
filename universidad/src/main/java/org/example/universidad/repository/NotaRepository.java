package org.example.universidad.repository;

import org.example.universidad.model.Nota;
import org.example.universidad.model.NotaKey;
import org.springframework.data.jpa.repository.JpaRepository;

//No estoy seguro si el tipo es long o NotaKey
public interface NotaRepository extends JpaRepository<Nota, NotaKey> {
    Nota findByAlumno_Persona_Cedula(long cedula);

    Nota findByAlumno_Persona_CedulaAndCurso_Codigo(long cedula, String codigo);
}
