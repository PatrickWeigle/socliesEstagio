/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.model.Agenda;
import br.com.soclies.repository.Agendas;
import br.com.soclies.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Agenda.class)
public class AgendaConverter implements Converter{

    private Agendas agendas;

    public AgendaConverter() {
        this.agendas = CDIServiceLocator.getBean(Agendas.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Agenda retorno = null;

        /* veio alguma coisa */
        if (string != null) {
            Long id = new Long(string);
            // buscando no banco de dados 
            retorno = agendas.retornaPorID(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        /* se tiver algo no object o */
        if (o != null) {
            Agenda agenda = (Agenda) o;
            /* retorna a string do id do produto */
            return agenda.getId_Agenda()== null ? null : agenda.getId_Agenda().toString();
        }
        return "";
    }

}
