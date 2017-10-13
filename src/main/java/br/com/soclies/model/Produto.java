/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_produto;
    private String nome_Produto;
    private BigDecimal valor_Produto;
    private int quantidade_Produto;

    @Id
    @GeneratedValue
    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    @Column(name = "nome_Produto", nullable = true, length = 150)
    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    @Column(name = "valor_Produto", precision = 10, scale = 2, nullable = true)
    public BigDecimal getValor_Produto() {
        return valor_Produto;
    }

    public void setValor_Produto(BigDecimal valor_Produto) {
        this.valor_Produto = valor_Produto;
    }

    @Column(name = "quantidade_Produto", nullable = true)
    public int getQuantidade_Produto() {
        return quantidade_Produto;
    }

    public void setQuantidade_Produto(int quantidade_Produto) {
        this.quantidade_Produto = quantidade_Produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id_produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id_produto, other.id_produto)) {
            return false;
        }
        return true;
    }

   

    
}
