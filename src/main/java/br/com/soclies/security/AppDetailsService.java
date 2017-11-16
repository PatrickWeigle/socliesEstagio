/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.security;

import br.com.soclies.model.Grupo;
import br.com.soclies.model.Usuario;
import br.com.soclies.repository.Usuarios;
import br.com.soclies.util.cdi.CDIServiceLocator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author patrickweigle
 */
public class AppDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
        Usuario usuario = usuarios.retornaPorEmail(email);
        UsuarioSistema usuarioSistema = null;
        
        if(usuario != null){
            usuarioSistema = new UsuarioSistema(usuario, getGrupos(usuario));
        }
        
        return usuarioSistema;
    }
    
    private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario){
        List<SimpleGrantedAuthority> grupos = new ArrayList<>();
        for(Grupo grupo : usuario.getGrupo()){
            grupos.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));

        }
        
        return grupos;
    }

   
    
    
    
}
