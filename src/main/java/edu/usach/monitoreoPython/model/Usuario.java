/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author benjamin
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(Long idUsuario, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String carrera, String facultad, Long ingreso, Long rol, Set<Coordinacion> coordinaciones, Set<Enunciado> enunciados) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.carrera = carrera;
        this.facultad = facultad;
        this.ingreso = ingreso;
        this.rol = rol;
        this.coordinaciones = coordinaciones;
        this.enunciados = enunciados;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "rut")
    @NotNull
    private String rut;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "apellidoPaterno")
    @NotNull
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    @NotNull
    private String apellidoMaterno;

    @Column(name = "correo")
    private String correo;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "facultad")
    private String facultad;

    @Column(name = "ingreso")
    private Long ingreso;

    @Column(name = "rol")
    private Long rol;

    @ManyToMany
    @JoinTable(
            name = "usuario_coordinacion",
            joinColumns = {
                @JoinColumn(name = "usuarioId", referencedColumnName = "idUsuario")},
            inverseJoinColumns = {
                @JoinColumn(name = "coordinacionId", referencedColumnName = "idCoordinacion")}
    )
    @JsonIgnoreProperties("usuarios")
    private Set<Coordinacion> coordinaciones;

    @ManyToMany
    @JoinTable(
            name = "usuario_enunciado",
            joinColumns = {
                @JoinColumn(name = "usuarioId", referencedColumnName = "idUsuario")},
            inverseJoinColumns = {
                @JoinColumn(name = "enunciadoId", referencedColumnName = "idEnunciado")}
    )
    @JsonIgnoreProperties("usuarios")
    private Set<Enunciado> enunciados;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Long getIngreso() {
        return ingreso;
    }

    public void setIngreso(Long ingreso) {
        this.ingreso = ingreso;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public Set<Coordinacion> getCoordinaciones() {
        return coordinaciones;
    }

    public void setCoordinaciones(Set<Coordinacion> coordinaciones) {
        this.coordinaciones = coordinaciones;
    }

    public Set<Enunciado> getEnunciados() {
        return enunciados;
    }

    public void setEnunciados(Set<Enunciado> enunciados) {
        this.enunciados = enunciados;
    }

}
