/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Produto;
import br.com.soclies.repository.Produtos;
import br.com.soclies.repository.filtros.FiltrosProdutos;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos repoProdutos;

    @Inject
    private Produto produto;

    private List<Produto> produtosPesquisados;
    
    private FiltrosProdutos filtroProduto;
    
    private Produto produtoSelecionado;

    public PesquisaProdutoBean() {
        filtroProduto = new FiltrosProdutos();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutosPesquisados() {
        return produtosPesquisados;
    }

    public void setProdutosPesquisados(List<Produto> produtosPesquisados) {
        this.produtosPesquisados = produtosPesquisados;
    }
    
    

    public FiltrosProdutos getFiltroProduto() {
        return filtroProduto;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
    
    
    public void buscar(){
        produtosPesquisados = repoProdutos.getbuscados(filtroProduto);
    }
    
    public void excluir(){
        repoProdutos.remover(produtoSelecionado);
        produtosPesquisados.remove(produtoSelecionado);
        FacesUtil.addInfoMessage("Produto removido com sucesso!");
    }

}
