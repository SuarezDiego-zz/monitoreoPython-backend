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
import javax.persistence.Table;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "coordinacion")
public class Coordinacion implements Serializable {

    public Coordinacion() {
    }

    public Coordinacion(Long idCoordinacion, Set<Usuario> usuarios) {
        this.idCoordinacion = idCoordinacion;
        this.usuarios = usuarios;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCoordinacion")
    private Long idCoordinacion;

    @ManyToMany(mappedBy = "coordinaciones")
    private Set<Usuario> usuarios;

    public Long getIdCoordinacion() {
        return idCoordinacion;
    }

    public void setIdCoordinacion(Long idCoordinacion) {
        this.idCoordinacion = idCoordinacion;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
