package org.example.universidad.service.RegistroFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistroFactory {

    @Autowired
    private RegistroAlumno registroAlumno;

    @Autowired
    private RegistroProfesor registroProfesor;

    @Autowired
    private RegistroAdministrativo registroAdministrativo;

    @Autowired
    private RegistroMatriculador registroMatriculador;

    public Registro getRegistro(String tipo) {
        switch (tipo) {
            case "alumno":
                return registroAlumno;
            case "profesor":
                return registroProfesor;
            case "administrativo":
                return registroAdministrativo;
            case "matriculador":
                return registroMatriculador;
            default:
                throw new IllegalArgumentException("Tipo de registro no válido: " + tipo);
        }
    }
}
