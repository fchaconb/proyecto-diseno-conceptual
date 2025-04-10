package org.example.universidad.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(unique = true, nullable = false, name = "codigo")
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;

    @ManyToOne
    @JoinColumn(name = "codigo_ciclo", referencedColumnName = "codigo")
    private Ciclo ciclo;

    @OneToMany(mappedBy = "curso")
    private Set<Nota> notas;

    @OneToMany(mappedBy = "curso")
    private Set<Grupo> grupos;

    public Curso() {
    }

    public Curso(String codigo, String nombre, int creditos, int horasSemanales, Ciclo ciclo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
        this.ciclo = ciclo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
}
