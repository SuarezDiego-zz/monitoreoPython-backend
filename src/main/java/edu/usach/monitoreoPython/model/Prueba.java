/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "prueba")
public class Prueba implements Serializable {

    public Prueba() {
    }

    public Prueba(Long idPrueba, String argumento, String resultado, Enunciado enunciado) {
        this.idPrueba = idPrueba;
        this.argumento = argumento;
        this.resultado = resultado;
        this.enunciado = enunciado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPrueba")
    private Long idPrueba;

    @Column(name = "argumento")
    @NotNull
    private String argumento;

    @Column(name = "resultado")
    @NotNull
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "idEnunciado")
    private Enunciado enunciado;

    public Long getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Long idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Enunciado getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(Enunciado enunciado) {
        this.enunciado = enunciado;
    }

}
