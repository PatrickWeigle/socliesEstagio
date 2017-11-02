   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Caixa;
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
public class SangriasCaixa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Caixa guardar(Caixa caixa) {
        EntityTransaction transa = manager.getTransaction();
        transa.begin();
        caixa = manager.merge(caixa);
        transa.commit();
        return caixa;
    }

    @SuppressWarnings("unchecked")
    public List<Caixa> getbuscados(String pesquisa) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Caixa.class);
        if (pesquisa != null && !pesquisa.equals(" ")) {
            criteria.add(Restrictions.ilike("nome_Cliente", pesquisa, MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome_Cliente")).list();
    }

    public void remover(Caixa caixa) {
        EntityTransaction et = manager.getTransaction();
        et.begin();

        caixa = manager.find(Caixa.class, caixa.getId_Caixa());
        manager.remove(caixa);

        et.commit();
    }

    public Caixa retornaPorID(Long id) {
        return manager.find(Caixa.class, id);
    }

}
