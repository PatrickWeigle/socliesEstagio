/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.util.cdi.CDIServiceLocator;
import br.com.soclies.model.Caixa;
import br.com.soclies.repository.SangriasCaixa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Caixa.class)
public class CaixaConverter implements Converter {

    private SangriasCaixa repoSCaixas;

    public CaixaConverter() {
        this.repoSCaixas = CDIServiceLocator.getBean(SangriasCaixa.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
         Caixa retorno = null;
        
        /* veio alguma coisa */
        if(string != null){
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = repoSCaixas.retornaPorID(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if(o != null){
            Caixa caixa = (Caixa) o;
            /* retorna a string do id do produto */
            return caixa.getId_Caixa()== null ? null : caixa.getId_Caixa().toString();
        }    
        return "";
    }
}
