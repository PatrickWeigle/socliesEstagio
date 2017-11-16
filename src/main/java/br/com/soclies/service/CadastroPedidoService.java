/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Pedido;
import br.com.soclies.repository.Pedidos;
import br.com.soclies.util.jpa.Transactional;
import br.com.soclies.util.jsf.FacesUtil;
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

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (pedido.isNovo()) {
            pedido.setData_pedido(new Date());
        }
        pedido.recalcularValorTotal();
        if (pedido.getItensPedido().isEmpty()) {
            throw new NegocioException("Pedido deve possuir pelo um serviço!");
        }
        //Metodo para verificar se pedido tem valor negativo
        pedido = this.pedidos.guardar(pedido);
        return pedido;
    }

}
