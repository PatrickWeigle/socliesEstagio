/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

/**
 *
 * @author patrickweigle
 */
public enum TipoEntrada {
    PRODUTO("Produto"), PEDIDO("Pedido"), SANGRIA("Sangria");

    private String descricao;

    private TipoEntrada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
