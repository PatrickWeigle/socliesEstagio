/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author patrickweigle
 */
public class Clientes implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private EntityManager manager;
    
    public Cliente guardar(Cliente cliente){
        EntityTransaction transa = manager.getTransaction();
        transa.begin();
        cliente= manager.merge(cliente);
        transa.commit();
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> buscados() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.ilike("nome_Cliente", cliente.getNome_Cliente(),MatchMode.ANYWHERE));
        
        return criteria.addOrder(Order.asc("nome_Cliente")).list();
    }
   
    
}
