/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository;

import br.com.soclies.model.Usuario;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author patrickweigle
 */
public class Usuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    @Inject
    private EntityManager manager;
    
    public Usuario retornaPorEmail(String email){
       Usuario usuario = new Usuario();
        try {
            usuario = this.manager.createQuery("from Usuario where lower(email) =:email", 
                    Usuario.class).setParameter("email", email.toLowerCase()).getSingleResult();
        } catch (NoResultException e) {
        }
        
        return usuario;
    }
    
    public Usuario retornaPorId(Long id){
        return manager.find(Usuario.class, id);
    }
    
}
