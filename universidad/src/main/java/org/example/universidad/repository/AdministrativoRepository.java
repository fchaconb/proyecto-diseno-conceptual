package org.example.universidad.repository;

import org.example.universidad.model.Administrativo;
import org.example.universidad.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {
    Administrativo findAdministrativoByPersona(Persona persona);
}
