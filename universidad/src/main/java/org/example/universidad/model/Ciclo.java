package org.example.universidad.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ciclo")
public class Ciclo {

    @Id
    @Column(unique = true, nullable = false, name = "codigo")
    private String codigo;
    private int anio;
    private String numero;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToMany(mappedBy = "ciclos")
    private Set<Carrera> carreras;

    @OneToMany(mappedBy = "ciclo")
    private Set<Curso> cursos;

    public Ciclo() {
    }

    public Ciclo(String codigo, int anio, String numero, Date fechaInicio, Date fechaFin) {
        this.codigo = codigo;
        this.anio = anio;
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
