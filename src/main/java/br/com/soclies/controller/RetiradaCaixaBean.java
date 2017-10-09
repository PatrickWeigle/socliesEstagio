/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.service.RetiradaCaixaService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */

@Named
@SessionScoped
public class RetiradaCaixaBean implements Serializable{
    private static final long serialVersionUID = 1L;
   
    @Inject
    private Caixa caixa;
    @Inject
    private RetiradaCaixaService retiradaCaixaService;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    public void salvar(){
        this.caixa = retiradaCaixaService.salvar(caixa);
        System.out.println("Retirada salvo com sucesso");
    }
}
