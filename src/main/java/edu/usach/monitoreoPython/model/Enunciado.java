/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "enunciado")
public class Enunciado implements Serializable {

    public Enunciado() {
    }

    public Enunciado(Long idEnunciado, String enunciado, Set<Usuario> usuarios, Set<Prueba> pruebas) {
        this.idEnunciado = idEnunciado;
        this.enunciado = enunciado;
        this.usuarios = usuarios;
        this.pruebas = pruebas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEnunciado")
    private Long idEnunciado;

    @Column(name = "enunciado")
    @NotNull
    private String enunciado;

    @ManyToMany(mappedBy = "enunciados")
    private Set<Usuario> usuarios;

    @OneToMany(mappedBy = "enunciado")
    private Set<Prueba> pruebas;

    public Long getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(Long idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

}
