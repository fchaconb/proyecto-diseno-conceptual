package org.example.universidad.service;

import org.example.universidad.model.Nota;
import org.example.universidad.repository.AlumnoRepository;
import org.example.universidad.repository.CursoRepository;
import org.example.universidad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Nota> getNotas() {
        return notaRepository.findAll();
    }

    public Nota registrarNota(Nota nota) {
        if (nota.getId() != null) {
            long idAlumno = nota.getId().getIdAlumno();
            String codigoCurso = nota.getId().getCodigoCurso();

            nota.setAlumno(alumnoRepository.findById(idAlumno).orElse(null));
            nota.setCurso(cursoRepository.findById(codigoCurso).orElse(null));
        }

        return notaRepository.save(nota);
    }


    public Nota buscarNotaPorCedula(long cedula) {
        return notaRepository.findByAlumno_Persona_Cedula(cedula);
    }

    public Nota modificarNota(long cedula, String idCurso, Nota nota) {
        Nota notaExistente = notaRepository.findByAlumno_Persona_CedulaAndCurso_Codigo(cedula, idCurso);
        if (notaExistente != null) {
            notaExistente.setNota(nota.getNota());
            return notaRepository.save(notaExistente);
        }
        return null;
    }

    public void eliminarNota(long cedula, String idCurso) {
        Nota nota = notaRepository.findByAlumno_Persona_CedulaAndCurso_Codigo(cedula, idCurso);
        if (nota != null) {
            notaRepository.delete(nota);
        }
    }
}
