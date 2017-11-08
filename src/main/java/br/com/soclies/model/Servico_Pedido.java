/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Servico_Pedido")
public class Servico_Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_Servico_Pedido;
    private Servico servico;
    private Pedido pedido;
    private BigDecimal valor_unitario = BigDecimal.ZERO;
    private Integer quantidade_Servico = 1;

    @Id
    @GeneratedValue
    public Long getId_Servico_Pedido() {
        return id_Servico_Pedido;
    }

    public void setId_Servico_Pedido(Long id_Servico_Pedido) {
        this.id_Servico_Pedido = id_Servico_Pedido;
    }

    
    @Column(name = "valor_unitario",  precision = 10, scale = 2)
    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "servico_id", nullable = false)
    public Servico getId_Servico() {
        return servico;
    }

    public void setId_Servico(Servico servico) {
        this.servico = servico;
    }

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Column(name = "quantidade_Servico")
    public Integer getQuantidade_Servico() {
        return quantidade_Servico;
    }

    public void setQuantidade_Servico(Integer quantidade_Servico) {
        this.quantidade_Servico = quantidade_Servico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id_Servico_Pedido);
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
        if (!Objects.equals(this.id_Servico_Pedido, other.id_Servico_Pedido)) {
            return false;
        }
        return true;
    }

   
  
    
    @Transient
    public BigDecimal getValorTotal(){
        return this.getValor_unitario().multiply(new BigDecimal(this.getQuantidade_Servico()));
    }
    
    @Transient
    public boolean isServicoAssociado(){
        return this.getId_Servico() != null && this.getId_Servico().getId_Servico() != null;
    }

}
