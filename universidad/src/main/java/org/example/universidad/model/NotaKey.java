package org.example.universidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NotaKey implements Serializable {

    @Column(name = "id_alumno")
    private long idAlumno;

    @Column(name = "codigo_curso")
    private String codigoCurso;

    public NotaKey() {
    }

    public NotaKey(long idAlumno, String codigoCurso) {
        this.idAlumno = idAlumno;
        this.codigoCurso = codigoCurso;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaKey)) return false;
        NotaKey notaKey = (NotaKey) o;
        return idAlumno == notaKey.idAlumno && codigoCurso.equals(notaKey.codigoCurso);
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(idAlumno) + codigoCurso.hashCode();
    }
}
