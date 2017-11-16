/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.security;

import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author patrickweigle
 */
@Named
@RequestScoped
public class Seguranca {

    @Inject
    private ExternalContext externalContext;

    public String getNomeUsuarioLogado() {
        String nome = null;
        UsuarioSistema usuarioSistema = getUsuarioLogado();
        if(usuarioSistema != null){
            nome = usuarioSistema.getUsuario().getNome();
        }
        
        return nome;

    }

    @Produces
    @UsuarioLogado
    public UsuarioSistema getUsuarioLogado() {
        UsuarioSistema usuarioSistema = null;
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
                FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if(auth != null && auth.getPrincipal() != null){
            usuarioSistema = (UsuarioSistema) auth.getPrincipal();
        }
        
        return usuarioSistema;
    }
}
