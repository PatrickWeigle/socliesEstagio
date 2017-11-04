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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_Servico;
    private String nome_Servico;
    private BigDecimal valor_Servico;

    @Id
    @GeneratedValue
    public Long getId_Servico() {
        return id_Servico;
    }

    public void setId_Servico(Long id_Servico) {
        this.id_Servico = id_Servico;
    }

    @NotBlank @Size(max = 150)
    @Column(name = "nome_Servico", nullable = false, length = 150)
    public String getNome_Servico() {
        return nome_Servico;
    }

    public void setNome_Servico(String nome_Servico) {
        this.nome_Servico = nome_Servico;
    }

    @NotNull @DecimalMin("00.00")
    @Column(name = "valor_Servico", nullable = false, precision = 10, scale = 2)
    public BigDecimal getValor_Servico() {
        return valor_Servico;
    }

    public void setValor_Servico(BigDecimal valor_Servico) {
        this.valor_Servico = valor_Servico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id_Servico);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id_Servico, other.id_Servico)) {
            return false;
        }
        return true;
    }

   

    

}
