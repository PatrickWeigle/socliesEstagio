/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Pedido;
import br.com.soclies.repository.filtros.FiltrosPedido;
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
public class Pedidos implements Serializable{
    
    private static final long serialVersionUID = 1L;

  
    
    @Inject
    private EntityManager manager;
    
    public Pedido guardar(Pedido pedido){
        return this.manager.merge(pedido);
    }
    
    public Pedido retornaPorId(Long id){
        return manager.find(Pedido.class, id);
    }

    public List<Pedido> getBuscados(FiltrosPedido filtros) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pedido.class).createAlias("id_cliente", "c");
        
        if(filtros.getNumeroDe()!= null){
            criteria.add(Restrictions.ge("id_Pedido", filtros.getNumeroDe()));
        }
        if(filtros.getNumeroAte() != null){
            criteria.add(Restrictions.le("id_Pedido", filtros.getNumeroAte()));
        }
        if(filtros.getDataInicio() != null){
            criteria.add(Restrictions.ge("data_pedido", filtros.getDataInicio()));
        }
        if(filtros.getDataFim() != null){
            criteria.add(Restrictions.le("data_pedido", filtros.getDataFim()));
        }
        if(StringUtils.isNotBlank(filtros.getNomeCliente())){
            criteria.add(Restrictions.ilike("c.nome_Cliente", filtros.getNomeCliente(), MatchMode.ANYWHERE));
        }
        
        return criteria.addOrder(Order.asc("id_Pedido")).list();
    }
    
}
