/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.converter;

import br.com.soclies.util.cdi.CDIServiceLocator;
import br.com.soclies.model.Produto;
import br.com.soclies.repository.Produtos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author patrickweigle
 */
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    private Produtos repoProdutos;

    public ProdutoConverter() {
        this.repoProdutos = CDIServiceLocator.getBean(Produtos.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Produto retorno = null;
        
        if(value != null){
            Long id = new Long(value);
            retorno = repoProdutos.retornaPorID(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        
        if(o != null){
            Produto produto = (Produto) o;
            
            return produto.getId_produto() == null ? null : produto.getId_produto().toString();
        }
        
        return "";
    }
}
