/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.service.CadastroClienteService;
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
public class CadastroClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Cliente cliente;
    @Inject
    private CadastroClienteService cadastroClienteService;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void salvar() {
        this.cliente = cadastroClienteService.salvar(this.cliente);
        System.out.println("Salvo com Sucesso");
    }
    
        public void excluir(Cliente cliente){
        cadastroClienteService.excluir(cliente);
    }
}
