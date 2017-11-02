/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author patrickweigle
 */
public class CadastroClienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clientes;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        
        return clientes.guardar(cliente);
    }
    
        public void excluir(Cliente cliente) {
        clientes.remover(cliente);
    }
}
