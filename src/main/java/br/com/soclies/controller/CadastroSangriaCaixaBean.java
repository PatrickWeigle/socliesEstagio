/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Caixa;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.service.CadastroSangriaCaixaService;
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
public class CadastroSangriaCaixaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Caixa caixa;
    
    @Inject
    private CadastroSangriaCaixaService cadastroSangriaCaixaService;

    public CadastroSangriaCaixaBean() {
        limparCampos();
    }
    

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    public void salvar(){
        caixa.setTipo_entrada_Caixa(TipoEntrada.SANGRIA);
        this.caixa = cadastroSangriaCaixaService.salvar(caixa);
        FacesUtil.addInfoMessage("Sangria salva com sucesso!");
        limparCampos();
    }
    
    private void limparCampos(){
        this.caixa = new Caixa();
    }
}
