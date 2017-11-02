/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Servico_Pedido")
public class Servico_Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_Servico_Pedido;
    private Servico servico;
    private Pedido pedido;
    private int quantidade_Servico;

    @Id
    @GeneratedValue
    public int getId_Servico_Pedido() {
        return id_Servico_Pedido;
    }

    public void setId_Servico_Pedido(int id_Servico_Pedido) {
        this.id_Servico_Pedido = id_Servico_Pedido;
    }

    @ManyToOne
    @JoinColumn(name = "servico", nullable = false)
    public Servico getId_Servico() {
        return servico;
    }

    public void setId_Servico(Servico servico) {
        this.servico = servico;
    }

    @ManyToOne
    @JoinColumn(name = "pedido", nullable = false)
    public Pedido getId_Pedido() {
        return pedido;
    }

    public void setId_Pedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Column(name = "quantidade_Servico")
    public int getQuantidade_Servico() {
        return quantidade_Servico;
    }

    public void setQuantidade_Servico(int quantidade_Servico) {
        this.quantidade_Servico = quantidade_Servico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_Servico_Pedido;
        hash = 67 * hash + Objects.hashCode(this.servico);
        hash = 67 * hash + Objects.hashCode(this.pedido);
        hash = 67 * hash + this.quantidade_Servico;
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
        final Servico_Pedido other = (Servico_Pedido) obj;
        if (this.id_Servico_Pedido != other.id_Servico_Pedido) {
            return false;
        }
        if (this.quantidade_Servico != other.quantidade_Servico) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }

}
