/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import br.com.soclies.repository.filtros.FiltrosCliente;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
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

    private List<Cliente> clientesPesquisados;
    
    private FiltrosCliente filtroCliente;
    private Cliente clienteSelecionado;

    public PesquisaClienteBean() {
        filtroCliente = new FiltrosCliente();
    }
    
    

    public FiltrosCliente getFiltroCliente() {
        return filtroCliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public void buscar() {
        clientesPesquisados = repositorioClientes.getbuscados(filtroCliente);
    }
    
    public void excluir(){
        repositorioClientes.remover(clienteSelecionado);
        clientesPesquisados.remove(clienteSelecionado);
        FacesUtil.addInfoMessage("Cliente removido com sucesso");
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

    public List<Cliente> getClientesPesquisados () {
        return clientesPesquisados;
    }

    public void setClientesPesquisados (List<Cliente> clientes) {
        this.clientesPesquisados = clientes;
    }

}
