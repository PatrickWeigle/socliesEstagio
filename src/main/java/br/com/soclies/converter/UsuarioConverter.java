/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.model.Usuario;
import br.com.soclies.repository.Usuarios;
import br.com.soclies.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{
    
    private Usuarios usuarios;

    public UsuarioConverter() {
        this.usuarios = CDIServiceLocator.getBean(Usuarios.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       Usuario retorno = null;
        
        /* veio alguma coisa */
        if(string != null){
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = usuarios.retornaPorId(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if(o != null){
            Usuario usuario = (Usuario) o;
            /* retorna a string do id do produto */
            return usuario.getId()== null ? null : usuario.getId().toString();
        }    
        return "";
    }
    
}
