package org.example.universidad.repository;

import org.example.universidad.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

//No estoy seguro si el tipo es long o NotaKey
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
