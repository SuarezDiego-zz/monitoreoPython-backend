/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.controller;

import edu.usach.monitoreoPython.model.Usuario;
import edu.usach.monitoreoPython.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author benjamin
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/all", method = GET)
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Usuario get(@PathVariable String id) {
        return usuarioRepository.findOne(Long.parseLong(id));
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }

}
