/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_Pedido;
    private BigDecimal total_Pedido;
    private BigDecimal desconto_Pedido;
    private String observacao_Pedido;
    private Date data_pedido;
    private FormaDePagamento pagamento_Pedido;
    private Cliente id_cliente;

    @Id
    @GeneratedValue
    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Column(name = "total_pedido", precision = 10, scale = 2)
    public BigDecimal getTotal_Pedido() {
        return total_Pedido;
    }

    public void setTotal_Pedido(BigDecimal total_Pedido) {
        this.total_Pedido = total_Pedido;
    }

    @Column(name = "desconto_pedido", precision = 10, scale = 2)
    public BigDecimal getDesconto_Pedido() {
        return desconto_Pedido;
    }

    public void setDesconto_Pedido(BigDecimal desconto_Pedido) {
        this.desconto_Pedido = desconto_Pedido;
    }

    @Column(name = "observacao_Pedido", columnDefinition = "text")
    public String getObservacao_Pedido() {
        return observacao_Pedido;
    }

    public void setObservacao_Pedido(String observacao_Pedido) {
        this.observacao_Pedido = observacao_Pedido;
    }

    @Column(name = "data_pedido", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    @Column(name = "pagamento_pedido")
    @Enumerated(EnumType.STRING)
    public FormaDePagamento getPagamento_Pedido() {
        return pagamento_Pedido;
    }

    public void setPagamento_Pedido(FormaDePagamento pagamento_Pedido) {
        this.pagamento_Pedido = pagamento_Pedido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_Pedido;
        hash = 89 * hash + Objects.hashCode(this.total_Pedido);
        hash = 89 * hash + Objects.hashCode(this.desconto_Pedido);
        hash = 89 * hash + Objects.hashCode(this.observacao_Pedido);
        hash = 89 * hash + Objects.hashCode(this.data_pedido);
        hash = 89 * hash + Objects.hashCode(this.pagamento_Pedido);
        hash = 89 * hash + Objects.hashCode(this.id_cliente);
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
        final Pedido other = (Pedido) obj;
        if (this.id_Pedido != other.id_Pedido) {
            return false;
        }
        if (!Objects.equals(this.observacao_Pedido, other.observacao_Pedido)) {
            return false;
        }
        if (!Objects.equals(this.total_Pedido, other.total_Pedido)) {
            return false;
        }
        if (!Objects.equals(this.desconto_Pedido, other.desconto_Pedido)) {
            return false;
        }
        if (!Objects.equals(this.data_pedido, other.data_pedido)) {
            return false;
        }
        if (this.pagamento_Pedido != other.pagamento_Pedido) {
            return false;
        }
        if (!Objects.equals(this.id_cliente, other.id_cliente)) {
            return false;
        }
        return true;
    }

}
