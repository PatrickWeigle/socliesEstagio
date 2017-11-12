/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Caixa;
import br.com.soclies.repository.filtros.FiltrosCaixa;
import br.com.soclies.service.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
public class Caixas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Caixa guardar(Caixa caixa) {
        caixa = manager.merge(caixa);
        return caixa;
    }
    
     public void remover(Caixa caixa) {
        try {
            caixa = retornaPorID(caixa.getId_Caixa());
            manager.remove(caixa);
            manager.flush();
        } catch (Exception e) {
            throw new NegocioException("Sangria não pode ser excluida!");
        }
        
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
        if(StringUtils.isNotBlank(filtros.getTipoEntrada())){
            criteria.add(Restrictions.ilike("Tipo_entrada_Caixa", filtros.getTipoEntrada(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("id_Caixa")).list();
    }
}
