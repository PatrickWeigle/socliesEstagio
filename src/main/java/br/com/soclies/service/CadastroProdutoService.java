/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Produto;
import br.com.soclies.repository.Produtos;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author patrickweigle
 */
public class CadastroProdutoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtos;

    @Transactional
    public Produto salvar(Produto produto) {
        return produtos.guardar(produto);
    }
}
