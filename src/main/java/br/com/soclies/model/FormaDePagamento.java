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
public enum FormaDePagamento {
    DINHEIRO("Dinheiro"), CARTAO_CREDITO("Cartão de Crédito"), CARTAO_DEBITO("Cartão de Débito"),
    DUPLICATA("Duplicata"), CHEQUE("Cheque");

    private String descricao;

    private FormaDePagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
