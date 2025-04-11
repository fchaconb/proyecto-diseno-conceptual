package org.example.universidad.service;

import org.example.universidad.model.Carrera;
import org.example.universidad.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public Carrera crearCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public List<Carrera> obtenerCarreras() {
        return carreraRepository.findAll();
    }

    public Carrera obtenerCarreraPorCodigo(String codigo) {
        return carreraRepository.findById(codigo).orElse(null);
    }

    public void eliminarCarrera(String codigo) {
        carreraRepository.deleteById(codigo);
    }

    public Carrera actualizarCarrera(String codigo, Carrera carrera) {
        Carrera carreraExistente = obtenerCarreraPorCodigo(codigo);
        if (carreraExistente != null) {
            carreraExistente.setNombre(carrera.getNombre());
            carreraExistente.setTitulo(carrera.getTitulo());
            return carreraRepository.save(carreraExistente);
        }
        return null;
    }
}
