/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Agenda;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author patrickweigle
 */
public class Agendas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    public Agenda guardar(Agenda agenda){
        agenda = manager.merge(agenda);
        return agenda;
    }
    
    public Agenda retornaPorID(Long id) {
        return manager.find(Agenda.class, id);
    }
    
}
