/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Produto;
import br.com.soclies.repository.filtros.FiltrosProdutos;
import br.com.soclies.service.NegocioException;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Produto guardar(Produto produto) {
        produto = manager.merge(produto);
        return produto;
    }

    @SuppressWarnings("unchecked")
    public List<Produto> getbuscados(FiltrosProdutos filtrados) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Produto.class);
        if (StringUtils.isNotBlank(filtrados.getProduto())) {
            criteria.add(Restrictions.ilike("nome_Produto", filtrados.getProduto(), MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome_Produto")).list();
    }

    @Transactional
    public void remover(Produto produto) {

        try {
            produto = retornaPorID(produto.getId_produto());
            manager.remove(produto);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Produto não pode ser excluido");
        }

    }

    public Produto retornaPorID(Long id) {
        return manager.find(Produto.class, id);
    }

    public List<Produto> porNome(String produto) {
        return this.manager.createQuery("from Produto " + "where upper(nome_Produto) like :nome_Produto",
                Produto.class).setParameter("nome_Produto", produto.toUpperCase() + "%").getResultList();
    }

    public Produto retornoProduto(Long id) {
        try {
            return this.manager.createQuery("from Produto where id_Produto =:id_Produto",
                    Produto.class).setParameter("id_Produto", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
