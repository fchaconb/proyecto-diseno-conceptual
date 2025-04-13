package org.example.universidad.service;

import org.example.universidad.model.Alumno;
import org.example.universidad.model.Grupo;
import org.example.universidad.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private AlumnoService alumnoService;

    public Grupo crearGrupo(Grupo grupo){return grupoRepository.save(grupo);}
    public List<Grupo> obtenerGrupos() {return grupoRepository.findAll();}
    public Grupo obtenerGrupoPorCodigo(String codigo){return grupoRepository.findById(codigo).orElse(null);}
    public void eliminarGrupo(String codigo){grupoRepository.deleteById(codigo);}

    public Grupo actualizarGrupo(String codigo, Grupo grupo){
        Grupo grupoExistente = obtenerGrupoPorCodigo(codigo);
        if(grupoExistente != null){
            grupoExistente.setDiaSemanal(grupo.getDiaSemanal());
            grupoExistente.setHoraInicio(grupo.getHoraInicio());
            grupoExistente.setHoraFin(grupo.getHoraFin());
            grupoExistente.setNumeroGrupo(grupo.getNumeroGrupo());
            grupoExistente.setCurso(grupo.getCurso());
            grupoExistente.setProfesor(grupo.getProfesor());
            grupoExistente.setAlumnosCurso(grupo.getAlumnosCurso());
            return grupoRepository.save(grupoExistente);
        }
        return null;
    }

    public Grupo agregarAlumnoAGrupo(String codigo, long cedula){
        Grupo grupo = obtenerGrupoPorCodigo(codigo);
        Alumno alumno = alumnoService.obtenerAlumnoPorCedula(cedula);
        if(grupo != null && alumno != null){
            grupo.getAlumnosCurso().add(alumno);
            return grupoRepository.save(grupo);
        }
        return null;
    }

    public Grupo eliminarAlumnoDeGrupo(String codigo, long cedula){
        Grupo grupo = obtenerGrupoPorCodigo(codigo);
        Alumno alumno = alumnoService.obtenerAlumnoPorCedula(cedula);
        if(grupo != null && alumno != null){
            grupo.getAlumnosCurso().remove(alumno);
            return grupoRepository.save(grupo);
        }
        return null;
    }

}
