/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.controller;

import edu.usach.monitoreoPython.model.Coordinacion;
import edu.usach.monitoreoPython.repository.CoordinacionRepository;
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
@RequestMapping("/coordinacion")
public class CoordinacionController {

    @Autowired
    private CoordinacionRepository coordinacionRepository;

    @RequestMapping(value = "/all", method = GET)
    public ResponseEntity<List<Coordinacion>> list() {
        try {
            List<Coordinacion> coordinaciones = coordinacionRepository.findAll();
            return ResponseEntity.ok(coordinaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Coordinacion> get(@PathVariable String id) {
        try {
            Coordinacion coordinacion = coordinacionRepository.findOne(Long.parseLong(id));
            return ResponseEntity.ok(coordinacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Coordinacion input) {
        try {
            Coordinacion coordinacion = coordinacionRepository.findOne(Long.parseLong(id));
            coordinacion.setUsuarios(input.getUsuarios());
            return ResponseEntity.ok(coordinacionRepository.saveAndFlush(coordinacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/addCoordinacion", method = POST)
    public ResponseEntity<?> post(@RequestBody Coordinacion input) {
        try {
            return ResponseEntity.ok(coordinacionRepository.saveAndFlush(input));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    @RequestMapping(value = "/deleteCoordinacion/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            coordinacionRepository.delete(Long.parseLong(id));
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

}
