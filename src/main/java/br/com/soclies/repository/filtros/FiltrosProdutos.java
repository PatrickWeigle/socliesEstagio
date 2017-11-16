/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository.filtros;

import java.io.Serializable;

/**
 *
 * @author patrickweigle
 */
public class FiltrosProdutos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String produto;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    
}
