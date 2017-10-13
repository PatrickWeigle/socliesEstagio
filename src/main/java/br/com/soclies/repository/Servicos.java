/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Servico;
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

    @SuppressWarnings("unchecked")
    public List<Servico> getbuscados() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Servico.class);
//        criteria.add(Restrictions.ilike("nome_Cliente", servico.getNome_Cliente(),MatchMode.ANYWHERE));

        return criteria.addOrder(Order.asc("nome_Servico")).list();
    }

    public void remover(Servico servico) {
        EntityTransaction et = manager.getTransaction();
        et.begin();

        servico = manager.find(Servico.class, servico.getId_Servico());
        manager.remove(servico);

        et.commit();
    }

    public Servico retornaPorID(Long id) {
        return manager.find(Servico.class, id);
    }

}
