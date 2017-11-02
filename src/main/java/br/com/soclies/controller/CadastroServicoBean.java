/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Servico;
import br.com.soclies.service.CadastroServicoService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class CadastroServicoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Servico servico;
    @Inject
    private CadastroServicoService cadastroServicoService;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    

    public void salvar() {
        this.servico = cadastroServicoService.salvar(this.servico);
        System.out.println("Salvo com Sucesso");
    }
    
        public void excluir(Servico servico){
        cadastroServicoService.excluir(servico);
    }
}
