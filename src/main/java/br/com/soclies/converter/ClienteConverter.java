package br.com.soclies.converter;

import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import br.com.soclies.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Um converter é uma classe que implementa a interface
 * javax.faces.convert.Converter, implementando os dois métodos desta interface,
 * o getAsObject e o getAsString.
 *
 * @author Fernando Ortiz
 */

/* Conversor para a entidade cliente */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    private Clientes clientes;

    /**
     * Construtor padrão para resolver o problema de falta de injeção de 
     * dependencias em conversores JSF.
     */
    public ClienteConverter() {
        clientes = CDIServiceLocator.getBean(Clientes.class);
    }
    
    /* recebe uma string e a partir dela retorna um objeto do tipo de Produto */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Cliente retorno = null;
        
        /* veio alguma coisa */
        if(string != null){
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = clientes.retornaPorID(id);
        }
        return retorno;
    }
    
    /* recebe um objeto do tipo object (Produto) e retorna uma String, que no caso vai
        ser o proprio ID no formato de String */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if(o != null){
            Cliente cliente = (Cliente) o;
            /* retorna a string do id do produto */
            return cliente.getId_Cliente()== null ? null : cliente.getId_Cliente().toString();
        }    
        return "";
    }

}
