/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.model.FormaDePagamento;
import br.com.soclies.model.Pedido;
import br.com.soclies.repository.Clientes;
import br.com.soclies.repository.Servicos;
import br.com.soclies.service.CadastroPedidoService;
import java.io.Serializable;
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
public class CadastroPedidoBean implements Serializable{
     private static final long serialVersionUID = 1L;
     
     @Inject
     private Clientes repoClientes;
     
     @Inject
     private Servicos repoServicos;
     
     @Inject
     private Pedido pedido;
     
     @Inject
     private CadastroPedidoService cadastroPedidoService;

    public CadastroPedidoBean() {
        Limpar();
    }
    
    public void Salvar(){
        this.pedido = this.cadastroPedidoService.salvar(this.pedido);
    }
    
    private void Limpar(){
        pedido = new Pedido();
    }
    
    public void Inicializar(){
        this.pedido.adicionarItemVazio();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public List<Cliente> completarCliente(String nome){
        return this.repoClientes.porNome(nome);
    }
    
    public FormaDePagamento[] getFormaPagamento(){
        return FormaDePagamento.values();
    }
    
    
     
     
     
     
}
