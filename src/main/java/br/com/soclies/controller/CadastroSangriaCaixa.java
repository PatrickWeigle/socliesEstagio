/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.model.EntradaCaixa;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.service.CadastroSangriaCaixaService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class CadastroSangriaCaixa implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    Caixa caixa;
    
    @Inject
    CadastroSangriaCaixaService cadastroSangriaCaixaService;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    public void salvar(){
        caixa.setTipo_entrada_Caixa(TipoEntrada.SANGRIA);
        caixa.setEntrada_Caixa(EntradaCaixa.DEBITO);
        this.caixa = cadastroSangriaCaixaService.salvar(caixa);
        System.out.println("SALVO COM SUCESSO");
    }
    
    public void excluir(){
        cadastroSangriaCaixaService.excluir(caixa);
    }
}
