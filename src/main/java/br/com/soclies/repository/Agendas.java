/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Agenda;
import br.com.soclies.repository.filtros.FiltrosAgenda;
import br.com.soclies.service.NegocioException;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
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
        Criteria criteria = session.createCriteria(Agenda.class).createAlias("cliente", "c");
        
//        if(filtros.getDataInicio() == null){
//            criteria.add(Restrictions.ge("horario_Agenda", new Date()));
//        }
        if (filtros.getNome_Cliente() != null) {
            criteria.add(Restrictions.ilike("c.nome_Cliente", filtros.getNome_Cliente(), MatchMode.ANYWHERE));
        }
        
        return criteria.addOrder(Order.asc("id_Agenda")).list();
    }
    
    @Transactional
     public void remover(Agenda agenda) {
        try {
            agenda = retornaPorID(agenda.getId_Agenda());
            manager.remove(agenda);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Agendamento não pode ser excluido!");
        }
        
    }
}
