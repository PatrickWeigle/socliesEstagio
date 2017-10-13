/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Produto;
import br.com.soclies.repository.Produtos;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */

@Named
@SessionScoped
public class PesquisaProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos repoProdutos;

    @Inject
    private Produto produto;

    private List<Produto> listProdutos;
    
    public void buscar(){
        listProdutos = repoProdutos.getbuscados();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

}
