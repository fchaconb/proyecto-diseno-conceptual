package org.example.universidad.service;

import org.example.universidad.model.Ciclo;
import org.example.universidad.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CicloService {

    @Autowired
    private CicloRepository cicloRepository;

    public Ciclo crearCiclo(Ciclo ciclo) {
        return cicloRepository.save(ciclo);
    }

    public List<Ciclo> obtenerCiclos() {
        return cicloRepository.findAll();
    }

    public Ciclo obtenerCicloPorCodigo(String codigo) {
        return cicloRepository.findById(codigo).orElse(null);
    }

    public void eliminarCiclo(String codigo) {
        cicloRepository.deleteById(codigo);
    }

    public Ciclo actualizarCiclo(String codigo, Ciclo ciclo) {
        Ciclo cicloExistente = obtenerCicloPorCodigo(codigo);
        if (cicloExistente != null) {
            cicloExistente.setAnio(ciclo.getAnio());
            cicloExistente.setNumero(ciclo.getNumero());
            cicloExistente.setFechaInicio(ciclo.getFechaInicio());
            cicloExistente.setFechaFin(ciclo.getFechaFin());
            cicloExistente.setCodigo(ciclo.getCodigo());
            return cicloRepository.save(cicloExistente);
        }
        return null;
    }
}
