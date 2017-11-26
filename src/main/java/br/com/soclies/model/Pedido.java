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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_Pedido;
    private BigDecimal total_Pedido = BigDecimal.ZERO;
    private BigDecimal desconto_Pedido = BigDecimal.ZERO;
    private String observacao_Pedido;
    private Date data_pedido;
    private FormaDePagamento pagamento_Pedido;
    private Cliente id_cliente;
    private List<Servico_Pedido> itensPedido = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(Long id_Pedido) {
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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Servico_Pedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<Servico_Pedido> itensPedido) {
        this.itensPedido = itensPedido;
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
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id_Pedido);
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
        if (!Objects.equals(this.id_Pedido, other.id_Pedido)) {
            return false;
        }
        return true;
    }

    @Transient
    public boolean isNovo() {
        return getId_Pedido() == null;
    }

    @Transient
    public boolean isExistente() {
        return !isNovo();
    }

    @Transient
    public BigDecimal getValorSubTotal() {
        return this.getTotal_Pedido().subtract(this.getDesconto_Pedido());
    }

    public void recalcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.subtract(this.getDesconto_Pedido());

        for (Servico_Pedido servico : this.getItensPedido()) {
            if (servico.getId_Servico() != null && servico.getId_Servico().getId_Servico() != null) {
                total = total.add(servico.getValorTotal());
            }
        }
        this.setTotal_Pedido(total);
    }

    public void adicionarItemVazio() {
        
            Servico servico = new Servico();
            Servico_Pedido item = new Servico_Pedido();
            item.setId_Servico(servico);
            item.setPedido(this);
            this.getItensPedido().add(0, item);
        
    }

    /*Metodo para remover a primeira linha do item de serviço, para deixar editavel
     */
    public void removerItemVazio() {
        Servico_Pedido primeiroItem = this.getItensPedido().get(0);
        if (primeiroItem != null && primeiroItem.getId_Servico().getId_Servico() == null) {
            this.getItensPedido().remove(0);
        }
    }

}
