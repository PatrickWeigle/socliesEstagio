/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@SessionScoped
public class PesquisaClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clientes;

    private List<Cliente> clientesBuscados;
    
    private Cliente cliente;

    public void buscar() {
        clientesBuscados = clientes.buscados();
    }

    public void setClientesBuscados(List<Cliente> clientesBuscados) {
        this.clientesBuscados = clientesBuscados;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public List<Cliente> getClientesBuscados() {
        return clientesBuscados;
    }

}
