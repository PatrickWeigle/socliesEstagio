/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Cliente;
import br.com.soclies.repository.filtros.FiltrosCliente;
import br.com.soclies.service.NegocioException;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
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
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cliente guardar(Cliente cliente) {
        cliente = manager.merge(cliente);
        return cliente;
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> getbuscados(FiltrosCliente filtrados) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);
        if(StringUtils.isNotBlank(filtrados.getNome())){
            criteria.add(Restrictions.ilike("nome_Cliente", filtrados.getNome(), MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome_Cliente")).list();
    }

    @Transactional
    public void remover(Cliente cliente) {
        try {
         
            cliente = retornaPorID(cliente.getId_Cliente());
            manager.remove(cliente);
            manager.flush();
            
        } catch (PersistenceException e) {
            throw new NegocioException("Cliente não pode ser excluido");
        }
    }

    public Cliente retornaPorID(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> porNome(String nome) {
        return this.manager.createQuery("from Cliente "+ "where upper(nome_Cliente) like :nome_Cliente",
                Cliente.class).setParameter("nome_Cliente", nome.toUpperCase() + "%").getResultList();
    }

    public Cliente verificaCPF(String cpf_cliente) {
        try {
            return manager.createQuery("from Cliente where upper(cpf_Cliente) =:"+
                    "cpf_Cliente", Cliente.class).setParameter("cpf_Cliente",cpf_cliente.toUpperCase()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
