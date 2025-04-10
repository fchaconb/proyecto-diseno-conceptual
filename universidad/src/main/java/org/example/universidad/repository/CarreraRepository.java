package org.example.universidad.repository;

import org.example.universidad.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, String> {
}
