/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Servico;
import br.com.soclies.repository.filtros.FiltrosServico;
import br.com.soclies.service.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author patrickweigle
 */
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Servico guardar(Servico servico) {
        servico = manager.merge(servico);
        return servico;
    }

    @SuppressWarnings("unchecked")
    public List<Servico> getbuscados(FiltrosServico filtrados) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Servico.class);
        if(StringUtils.isNotBlank(filtrados.getServico())){
            criteria.add(Restrictions.ilike("nome_Servico", filtrados.getServico(), MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome_Servico")).list();
    }

    public void remover(Servico servico) {
        try {
            servico = retornaPorID(servico.getId_Servico());
            manager.remove(servico);
            manager.flush();
        } catch (Exception e) {
            throw new NegocioException("Servico não pode ser excluido!");
        }
        
    }

    public Servico retornaPorID(Long id) {
        return manager.find(Servico.class, id);
    }
    
    public List<Servico> porNome(String servico){
        return this.manager.createQuery("from Servico "+ "where upper(nome_Servico) like :nome_Servico",
                Servico.class).setParameter("nome_Servico", servico.toUpperCase() + "%").getResultList();
    
    }

}
