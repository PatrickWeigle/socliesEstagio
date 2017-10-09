/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Servico;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



/**
 *
 * @author patrickweigle
 */
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Servico guardar(Servico servico) {
        EntityTransaction transa = manager.getTransaction();
        transa.begin();
        servico = manager.merge(servico);
        transa.commit();
        return servico;
    }

}
