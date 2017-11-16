/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.model.Produto;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.repository.Produtos;
import br.com.soclies.service.CadastroProdutoService;
import br.com.soclies.service.CadastroSangriaCaixaService;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

    @Inject
    private Produtos produtos;

    @Inject
    private CadastroSangriaCaixaService caixaService;

    @Inject
    private Caixa caixa;

    private BigDecimal total = BigDecimal.ZERO;

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
        entradaCaixa();
        this.produto = cadastroProdutoService.salvar(this.produto);
        FacesUtil.addInfoMessage("Produto salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        this.produto = new Produto();
    }

    public void entradaCaixa() {
        int qtdnovo = this.produto.getQuantidade_Produto();
        System.out.println(qtdnovo);
        if (this.produto.getId_produto() == null) {
            total = getValorTotal();
            insereCaixa(total);
        }

    }

    public void insereCaixa(BigDecimal valor) {
        caixa.setData_Caixa(new Date());
        caixa.setTipo_entrada_Caixa(TipoEntrada.PRODUTO);
        caixa.setValor_Entrada(valor);
        this.caixa = this.caixaService.salvar(caixa);
    }

    public BigDecimal getValorTotal() {
        return this.produto.getValor_Produto().multiply(new BigDecimal(this.getProduto().getQuantidade_Produto()));
    }
}
