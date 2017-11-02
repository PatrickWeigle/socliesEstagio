/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.service.CadastroClienteService;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Cliente cliente;
    @Inject
    private CadastroClienteService cadastroClienteService;

    public CadastroClienteBean() {
        limparCampos();
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void salvar() {
        this.cliente = cadastroClienteService.salvar(this.cliente);
        FacesUtil.addInfoMessage("Cliente adicionado com sucesso");
        limparCampos();
    }
    
        public void excluir(Cliente cliente){
        cadastroClienteService.excluir(cliente);
    }
        
    private void limparCampos(){
        this.cliente = new Cliente();
    }
}
