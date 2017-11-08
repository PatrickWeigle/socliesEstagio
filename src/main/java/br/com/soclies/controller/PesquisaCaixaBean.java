/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.repository.Caixas;
import br.com.soclies.repository.filtros.FiltrosCaixa;
import java.io.Serializable;
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
    Caixas caixas;

    @Inject
    FiltrosCaixa filtrosCaixa;

    List<Caixa> caixasPesquisados;

    public PesquisaCaixaBean() {
        caixasPesquisados = new ArrayList<>();
        filtrosCaixa = new FiltrosCaixa();
    }

    public void pesquisar() {
        caixasPesquisados = caixas.getBuscados(filtrosCaixa);
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

    public TipoEntrada[] getTipoEntrada() {
        return TipoEntrada.values();
    }

}
