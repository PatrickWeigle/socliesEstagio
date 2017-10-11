/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.cdi.CDIServiceLocator;
import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
    
    private Clientes clientes;

    public ClienteConverter() {
        this.clientes = CDIServiceLocator.getBean(Clientes.class);
    }
    
    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Cliente retorno = null;
        if(string != null){
            Long id = new Long(string);
            retorno = clientes.retornaPorID(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            return ""+((Cliente) o).getId_Cliente();
        }
        return "";
    }
    
    
}
