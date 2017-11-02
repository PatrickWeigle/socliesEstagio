/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Caixa")
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_Caixa;
    private Pedido id_Pedido;
    private Produto id_Produto;
    private Date data_Caixa;
    private BigDecimal valor_Entrada;
    private TipoEntrada Tipo_entrada_Caixa;
    private EntradaCaixa entrada_Caixa;

    @Id
    @GeneratedValue
    public Long getId_Caixa() {
        return id_Caixa;
    }

    public void setId_Caixa(Long id_Caixa) {
        this.id_Caixa = id_Caixa;
    }

    @OneToOne
    @JoinColumn(name = "id_Pedido")
    public Pedido getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(Pedido id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    @OneToOne
    @JoinColumn(name = "id_Produto")
    public Produto getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(Produto id_Produto) {
        this.id_Produto = id_Produto;
    }

    @Column(name = "data_Caixa", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getData_Caixa() {
        return data_Caixa;
    }

    public void setData_Caixa(Date data_Caixa) {
        Date date = new Date();
        this.data_Caixa = date;
    }

    @Column(name = "valor_Entrada", nullable = false, precision = 10, scale = 2)
    public BigDecimal getValor_Entrada() {
        return valor_Entrada;
    }

    public void setValor_Entrada(BigDecimal valor_Entrada) {
        this.valor_Entrada = valor_Entrada;
    }

    @Column(name = "tipo_Entrada_Caixa", nullable = false)
    @Enumerated(EnumType.STRING)
    public TipoEntrada getTipo_entrada_Caixa() {
        return Tipo_entrada_Caixa;
    }

    public void setTipo_entrada_Caixa(TipoEntrada Tipo_entrada_Caixa) {
        this.Tipo_entrada_Caixa = Tipo_entrada_Caixa;
    }

    @Column(name = "Entrada_Caixa")
    @Enumerated(EnumType.STRING)
    public EntradaCaixa getEntrada_Caixa() {
        return entrada_Caixa;
    }

    public void setEntrada_Caixa(EntradaCaixa entrada_Caixa) {
        this.entrada_Caixa = entrada_Caixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id_Caixa);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.id_Caixa, other.id_Caixa)) {
            return false;
        }
        return true;
    }

   

}
