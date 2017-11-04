/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Produto;
import br.com.soclies.service.CadastroProdutoService;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Produto produto;
    @Inject
    private CadastroProdutoService cadastroProdutoService;

    public CadastroProdutoBean() {
        limparCampos();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void salvar() {
        this.produto = cadastroProdutoService.salvar(this.produto);
        FacesUtil.addInfoMessage("Produto adicionado com sucesso!");
        limparCampos();
    }
    
    private void limparCampos(){
        this.produto = new Produto();
    }
}
