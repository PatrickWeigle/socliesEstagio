/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Pedido;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author patrickweigle
 */
public class Pedidos implements Serializable{

    @Inject
    private EntityManager manager;
    
    public Pedido guardar(Pedido pedido){
        return this.manager.merge(pedido);
    }
    
}
