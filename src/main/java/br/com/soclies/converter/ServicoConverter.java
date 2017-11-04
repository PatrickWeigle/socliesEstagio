/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.util.cdi.CDIServiceLocator;
import br.com.soclies.model.Servico;
import br.com.soclies.repository.Servicos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Servico.class)
public class ServicoConverter implements Converter {

    private Servicos repoServicos;

    public ServicoConverter() {
        this.repoServicos = CDIServiceLocator.getBean(Servicos.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       Servico retorno = null;
        
        /* veio alguma coisa */
        if(string != null){
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = repoServicos.retornaPorID(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if(o != null){
            Servico servico = (Servico) o;
            /* retorna a string do id do produto */
            return servico.getId_Servico()== null ? null : servico.getId_Servico().toString();
        }    
        return "";
    }
}
