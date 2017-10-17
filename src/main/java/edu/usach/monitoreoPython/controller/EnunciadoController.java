/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.controller;

import edu.usach.monitoreoPython.model.Enunciado;
import edu.usach.monitoreoPython.repository.EnunciadoRepository;
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
@RequestMapping("/enunciado")
public class EnunciadoController {

    @Autowired
    private EnunciadoRepository enunciadoRepository;

    @RequestMapping(value = "/all", method = GET)
    public ResponseEntity<List<Enunciado>> list() {
        try {
            List<Enunciado> enunciados = enunciadoRepository.findAll();
            return ResponseEntity.ok(enunciados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Enunciado> get(@PathVariable String id) {
        try {
            Enunciado enunciado = enunciadoRepository.findOne(Long.parseLong(id));
            return ResponseEntity.ok(enunciado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Enunciado input) {
        try {
            Enunciado enunciado = enunciadoRepository.findOne(Long.parseLong(id));
            enunciado.setEnunciado(input.getEnunciado());
            return ResponseEntity.ok(enunciadoRepository.saveAndFlush(enunciado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/addEnunciado", method = POST)
    public ResponseEntity<?> post(@RequestBody Enunciado input) {
        try {
            return ResponseEntity.ok(enunciadoRepository.saveAndFlush(input));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/deleteEnunciado/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            enunciadoRepository.delete(Long.parseLong(id));
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
