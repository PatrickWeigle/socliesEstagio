/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.model.Pedido;
import br.com.soclies.repository.Pedidos;
import br.com.soclies.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{
     private Pedidos repoPedidos;

    /**
     * Construtor padrão para resolver o problema de falta de injeção de 
     * dependencias em conversores JSF.
     */
    public PedidoConverter(){
        repoPedidos = CDIServiceLocator.getBean(Pedidos.class);
    }
    
    /* recebe uma string e a partir dela retorna um objeto do tipo de Produto */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Pedido retorno = null;
        
        /* veio alguma coisa */
        if(string != null){
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = repoPedidos.retornaPorId(id);
        }
        return retorno;
    }
    
    /* recebe um objeto do tipo object (Produto) e retorna uma String, que no caso vai
        ser o proprio ID no formato de String */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if(o != null){
            Pedido pedido = (Pedido) o;
            /* retorna a string do id do produto */
            return pedido.getId_Pedido()== null ? null : pedido.getId_Pedido().toString();
        }    
        return "";
    }
}
