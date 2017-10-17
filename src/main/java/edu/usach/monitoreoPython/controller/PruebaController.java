/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.controller;

import edu.usach.monitoreoPython.model.Prueba;
import edu.usach.monitoreoPython.repository.PruebaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
@RequestMapping("/prueba")
public class PruebaController {

    @Autowired
    private PruebaRepository pruebaRepository;

    @RequestMapping(value = "/all", method = GET)
    public ResponseEntity<List<Prueba>> list() {
        try {
            List<Prueba> pruebas = pruebaRepository.findAll();
            return ResponseEntity.ok(pruebas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Prueba> get(@PathVariable String id) {
        try {
            Prueba prueba = pruebaRepository.findOne(Long.parseLong(id));
            return ResponseEntity.ok(prueba);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Prueba input) {
        try {
            Prueba prueba = pruebaRepository.findOne(Long.parseLong(id));
            prueba.setArgumento(input.getArgumento());
            prueba.setResultado(input.getResultado());
            return ResponseEntity.ok(pruebaRepository.saveAndFlush(prueba));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/addPrueba", method = POST)
    public ResponseEntity<?> post(@RequestBody Prueba input) {
        try {
            return ResponseEntity.ok(pruebaRepository.saveAndFlush(input));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/deletePrueba/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            pruebaRepository.delete(Long.parseLong(id));
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

}
