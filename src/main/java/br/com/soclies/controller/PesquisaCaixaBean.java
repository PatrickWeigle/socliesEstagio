/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.model.FormaDePagamento;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.repository.Caixas;
import br.com.soclies.repository.filtros.FiltrosCaixa;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class PesquisaCaixaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Caixa caixa;

    @Inject
    private Caixas caixas;

    @Inject
    private FiltrosCaixa filtrosCaixa;

    private FiltrosCaixa filtrosCaixaSangria;

    private List<Caixa> caixasPesquisados;

    private List<Caixa> caixasPesquisadosSangria;

    private Caixa caixaSelecionado;

    private BigDecimal valorTotal;

    public PesquisaCaixaBean() {
        caixasPesquisados = new ArrayList<>();
        caixasPesquisadosSangria = new ArrayList<>();
        filtrosCaixa = new FiltrosCaixa();
        filtrosCaixaSangria = new FiltrosCaixa();
    }

    public void pesquisar() {
        caixasPesquisados = caixas.getBuscados(filtrosCaixa);
        calculaValorTotal();
    }

    public void pesquisarSangria() {
        filtrosCaixaSangria.setTipoEntrada(TipoEntrada.SANGRIA);
        caixasPesquisadosSangria = caixas.getBuscados(filtrosCaixaSangria);
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Caixa getCaixaSelecionado() {
        return caixaSelecionado;
    }

    public void setCaixaSelecionado(Caixa caixaSelecionado) {
        this.caixaSelecionado = caixaSelecionado;
    }

    public Caixas getCaixas() {
        return caixas;
    }

    public void setCaixas(Caixas caixas) {
        this.caixas = caixas;
    }

    public FiltrosCaixa getFiltrosCaixa() {
        return filtrosCaixa;
    }

    public void setFiltrosCaixa(FiltrosCaixa filtrosCaixa) {
        this.filtrosCaixa = filtrosCaixa;
    }

    public List<Caixa> getCaixasPesquisados() {
        return caixasPesquisados;
    }

    public void setCaixasPesquisados(List<Caixa> caixasPesquisados) {
        this.caixasPesquisados = caixasPesquisados;
    }

    public List<Caixa> getCaixasPesquisadosSangria() {
        return caixasPesquisadosSangria;
    }

    public void setCaixasPesquisadosSangria(List<Caixa> caixasPesquisadosSangria) {
        this.caixasPesquisadosSangria = caixasPesquisadosSangria;
    }

    public FiltrosCaixa getFiltrosCaixaSangria() {
        return filtrosCaixaSangria;
    }

    public void setFiltrosCaixaSangria(FiltrosCaixa filtrosCaixaSangria) {
        this.filtrosCaixaSangria = filtrosCaixaSangria;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoEntrada[] getTipoEntrada() {
        return TipoEntrada.values();
    }

    public TipoEntrada[] tipoEntrada() {
        return TipoEntrada.values();
    }

    public FormaDePagamento[] getFormaPagamento() {
        return FormaDePagamento.values();
    }

    public void remover() {
        caixas.remover(caixaSelecionado);
        caixasPesquisados.remove(caixaSelecionado);
        FacesUtil.addInfoMessage("Sangria excluida com sucesso!");
        calculaValorTotal();
    }

    public void calculaValorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Caixa SomaCaixa : caixasPesquisados) {

            if (SomaCaixa.getTipo_entrada_Caixa() == TipoEntrada.PEDIDO) {
                total = total.add(SomaCaixa.getValor_Entrada());
            } else {
                total = total.subtract(SomaCaixa.getValor_Entrada());
            }

        }
        setValorTotal(total);
    }

}
