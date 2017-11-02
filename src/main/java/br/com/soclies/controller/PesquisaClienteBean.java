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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nomePesquisado;

    @Inject
    private Clientes repositorioClientes;

    @Inject
    private Cliente cliente;

    private List<Cliente> clientes;

    public void buscar() {
        clientes = repositorioClientes.getbuscados(nomePesquisado);
    }
    

    public String getNomePesquisado() {
        return nomePesquisado;
    }

    public void setNomePesquisado(String nomePesquisado) {
        this.nomePesquisado = nomePesquisado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
