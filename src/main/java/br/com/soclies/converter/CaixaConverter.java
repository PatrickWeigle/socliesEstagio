/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.cdi.CDIServiceLocator;
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
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("O valor não é ID válido: " + value);
        }

        Long id = new Long(value);
        return repoSCaixas.retornaPorID(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        if (!(o instanceof Caixa)) {
            throw new ConverterException("Esse valor não é uma Pessoa Válida: " + o);
        }

        Long id = ((Caixa) o).getId_Caixa();
        return (id != null) ? String.valueOf(id) : null;
    }
}
