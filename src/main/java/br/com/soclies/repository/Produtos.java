/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Produto;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author patrickweigle
 */
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Produto guardar(Produto produto) {
        EntityTransaction transa = manager.getTransaction();
        transa.begin();
        produto = manager.merge(produto);
        transa.commit();
        return produto;
    }
}
