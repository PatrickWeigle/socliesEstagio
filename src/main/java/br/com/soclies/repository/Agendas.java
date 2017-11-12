/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Agenda;
import br.com.soclies.repository.filtros.FiltrosAgenda;
import br.com.soclies.service.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author patrickweigle
 */
public class Agendas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Agenda guardar(Agenda agenda) {
        agenda = manager.merge(agenda);
        return agenda;
    }

    public Agenda retornaPorID(Long id) {
        return manager.find(Agenda.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Agenda> getBuscados(FiltrosAgenda filtros) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Agenda.class);

        if (filtros.getId() != null) {
            criteria.add(Restrictions.ge("id_Agenda", filtros.getId()));
        }
        
        return criteria.addOrder(Order.asc("id_Agenda")).list();
    }
    
     public void remover(Agenda agenda) {
        try {
            agenda = retornaPorID(agenda.getId_Agenda());
            manager.remove(agenda);
            manager.flush();
        } catch (Exception e) {
            throw new NegocioException("Agendamento não pode ser excluido!");
        }
        
    }
}
