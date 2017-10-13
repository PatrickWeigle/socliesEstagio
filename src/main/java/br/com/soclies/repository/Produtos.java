/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

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
    
    @SuppressWarnings("unchecked")
    public List<Produto> getbuscados(){
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Produto.class);
        
        return criteria.addOrder(Order.asc("nome_Produto")).list();
    }
    
        public void remover(Produto produto) {
        EntityTransaction et = manager.getTransaction();
        et.begin();

        produto = manager.find(Produto.class, produto.getId_produto());
        manager.remove(produto);

        et.commit();
    }

    public Produto retornaPorID(Long id) {
        return manager.find(Produto.class, id);
    }
}
