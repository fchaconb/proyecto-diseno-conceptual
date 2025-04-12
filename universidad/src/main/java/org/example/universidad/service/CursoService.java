package org.example.universidad.service;

import org.example.universidad.model.Ciclo;
import org.example.universidad.model.Curso;
import org.example.universidad.repository.CicloRepository;
import org.example.universidad.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(Curso curso) {return cursoRepository.save(curso);}
    public List<Curso> obtenerCursos() {return cursoRepository.findAll();}
    public Curso obtenerCursoPorCodigo(String codigo) {return cursoRepository.findById(codigo).orElse(null);}
    public void eliminarCurso(String codigo) {cursoRepository.deleteById(codigo);}

    public Curso actualizarCurso(String codigo, Curso curso) {

        Curso cursoExistente = obtenerCursoPorCodigo(codigo);
        if (cursoExistente != null) {
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setCreditos(curso.getCreditos());
            cursoExistente.setHorasSemanales(curso.getHorasSemanales());
            cursoExistente.setCodigo(curso.getCodigo());
            return cursoRepository.save(cursoExistente);
        }
        return null;
    }
}