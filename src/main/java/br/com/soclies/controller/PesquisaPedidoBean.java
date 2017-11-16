/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Pedido;
import br.com.soclies.model.TipoEntrada;
import br.com.soclies.repository.Pedidos;
import br.com.soclies.repository.filtros.FiltrosPedido;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@ViewScoped
@Named
public class PesquisaPedidoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    Pedidos pedidos;
    
    FiltrosPedido filtrosPedidos;
    
    List<Pedido> pedidosPesquisados;

    public PesquisaPedidoBean() {
       pedidosPesquisados = new ArrayList<>();
       filtrosPedidos = new FiltrosPedido();
    }
    
    public void pesquisar(){
        pedidosPesquisados = pedidos.getBuscados(filtrosPedidos);
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public FiltrosPedido getFiltrosPedidos() {
        return filtrosPedidos;
    }

    public void setFiltrosPedidos(FiltrosPedido filtrosPedidos) {
        this.filtrosPedidos = filtrosPedidos;
    }

    public List<Pedido> getPedidosPesquisados() {
        return pedidosPesquisados;
    }

    public void setPedidosPesquisados(List<Pedido> pedidosPesquisados) {
        this.pedidosPesquisados = pedidosPesquisados;
    }
}
    
    
    
    
    
    
