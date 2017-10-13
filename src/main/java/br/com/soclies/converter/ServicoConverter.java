/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.cdi.CDIServiceLocator;
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
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("\\d+")) {
            throw new ConverterException("O valor não é ID válido: " + value);
        }

        Long id = new Long(value);
        return repoServicos.retornaPorID(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        if (!(o instanceof Servico)) {
            throw new ConverterException("Esse valor não é uma Pessoa Válida: " + o);
        }

        Long id = ((Servico) o).getId_Servico();
        return (id != null) ? String.valueOf(id) : null;
    }
}
