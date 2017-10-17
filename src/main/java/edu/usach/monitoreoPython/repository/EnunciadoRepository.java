/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.repository;

import edu.usach.monitoreoPython.model.Enunciado;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author benjamin
 */
@Transactional
public interface EnunciadoRepository extends JpaRepository<Enunciado, Long> {

}
