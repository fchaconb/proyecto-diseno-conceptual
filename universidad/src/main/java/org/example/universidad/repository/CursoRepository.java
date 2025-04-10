package org.example.universidad.repository;

import org.example.universidad.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, String> {
}
