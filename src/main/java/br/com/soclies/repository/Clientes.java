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
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cliente guardar(Cliente cliente) {
        cliente = manager.merge(cliente);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> getbuscados(String pesquisa) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);
        if (pesquisa != null && !pesquisa.equals(" ")) {
            criteria.add(Restrictions.ilike("nome_Cliente", pesquisa, MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome_Cliente")).list();
    }

    public void remover(Cliente cliente) {
        EntityTransaction et = manager.getTransaction();
        et.begin();

        cliente = manager.find(Cliente.class, cliente.getId_Cliente());
        manager.remove(cliente);

        et.commit();
    }

    public Cliente retornaPorID(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> porNome(String nome) {
        return this.manager.createQuery("from Cliente "+ "where upper(nome_Cliente) like :nome_Cliente",
                Cliente.class).setParameter("nome_Cliente", nome.toUpperCase() + "%").getResultList();
    }

}
