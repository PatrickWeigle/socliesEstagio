/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Pedido;
import br.com.soclies.repository.Pedidos;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author patrickweigle
 */
public class CadastroPedidoService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Pedidos pedidos;

    public Pedido salvar(Pedido pedido) {
        if (pedido.isNovo()) {
            pedido.setData_pedido(new Date());
        }
        if (pedido.getItensPedido().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido deve possuir pelo menos 1 item!!!", ""));

        }
        //Metodo para verificar se pedido tem valor negativo
        pedido = this.pedidos.guardar(pedido);
        return pedido;
    }

}
