/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Caixa;
import br.com.soclies.repository.filtros.FiltrosCaixa;
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
public class Caixas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Caixa guardar(Caixa caixa) {
        caixa = manager.merge(caixa);
        return caixa;
    }

    public Caixa retornaPorID(Long id) {
        return manager.find(Caixa.class, id);
    }

    public List<Caixa> getBuscados(FiltrosCaixa filtros) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Caixa.class);

        if (filtros.getDataInicio() != null) {
            criteria.add(Restrictions.ge("data_Caixa", filtros.getDataInicio()));
        }
        if (filtros.getDataFim() != null) {
            criteria.add(Restrictions.le("data_Caixa", filtros.getDataInicio()));
        }
        if (filtros.getTipoEntrada() != null) {
            criteria.add(Restrictions.eq("Tipo_entrada_Caixa", filtros.getTipoEntrada()));
        }

        return criteria.addOrder(Order.asc("id_Caixa")).list();
    }
}
