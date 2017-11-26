/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.events;

import br.com.soclies.model.Pedido;

/**
 *
 * @author patrickweigle
 */
public class PedidoAlteradoEvento {
    
    private Pedido pedido;

    public PedidoAlteradoEvento(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

       
            
            
    
}
