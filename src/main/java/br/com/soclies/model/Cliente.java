/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id_Cliente;
    private String nome_Cliente;
    private String email_Cliente;
    private String telefone_Cliente;
    private String celular_Cliente;
    private String endereco_Cliente;
    private String bairro_cliente;
    private String cidade_cliente;
    private String uf_cliente;
    private String anamnese_Cliente;
    private long cpf_cliente;
    private Date nascimento_cliente;

  
    

    
    @Id
    @GeneratedValue
    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    @Column(name = "nome_Cliente", nullable = true, length = 150)
    public String getNome_Cliente() {
        return nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
    }

    @Column(name = "email_Cliente", length = 100)
    public String getEmail_Cliente() {
        return email_Cliente;
    }

    public void setEmail_Cliente(String email_Cliente) {
        this.email_Cliente = email_Cliente;
    }

    @Column(name = "telefone_Cliente", length = 20, nullable = true)
    public String getTelefone_Cliente() {
        return telefone_Cliente;
    }

    public void setTelefone_Cliente(String telefone_Cliente) {
        this.telefone_Cliente = telefone_Cliente;
    }

    @Column(name = "celular_Cliente", length = 20)
    public String getCelular_Cliente() {
        return celular_Cliente;
    }

    public void setCelular_Cliente(String celular_Cliente) {
        this.celular_Cliente = celular_Cliente;
    }

    @Column(name = "endereco_Cliente", length = 150)
    public String getEndereco_Cliente() {
        return endereco_Cliente;
    }

    public void setEndereco_Cliente(String endereco_Cliente) {
        this.endereco_Cliente = endereco_Cliente;
    }

    @Column(name = "anamnese_Cliente", columnDefinition = "text")
    public String getAnamnese_Cliente() {
        return anamnese_Cliente;
    }

    public void setAnamnese_Cliente(String anamnese_Cliente) {
        this.anamnese_Cliente = anamnese_Cliente;
    }

    @Column(name = "cpf_Cliente", unique = true)
    public long getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(long cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    @Column(name = "bairro_cliente", length = 100)
    public String getBairro_cliente() {
        return bairro_cliente;
    }

    public void setBairro_cliente(String bairro_cliente) {
        this.bairro_cliente = bairro_cliente;
    }

    @Column(name = "cidade_cliente", length = 50)
    public String getCidade_cliente() {
        return cidade_cliente;
    }

    public void setCidade_cliente(String cidade_cliente) {
        this.cidade_cliente = cidade_cliente;
    }

    @Column(name = "uf_cliente", length = 2)
    public String getUf_cliente() {
        return uf_cliente;
    }

    public void setUf_cliente(String uf_cliente) {
        this.uf_cliente = uf_cliente;
    }

    @Column(name = "nascimento_cliente")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getNascimento_cliente() {
        return nascimento_cliente;
    }

    public void setNascimento_cliente(Date nascimento_cliente) {
        this.nascimento_cliente = nascimento_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_Cliente;
        hash = 53 * hash + Objects.hashCode(this.nome_Cliente);
        hash = 53 * hash + Objects.hashCode(this.email_Cliente);
        hash = 53 * hash + Objects.hashCode(this.telefone_Cliente);
        hash = 53 * hash + Objects.hashCode(this.celular_Cliente);
        hash = 53 * hash + Objects.hashCode(this.endereco_Cliente);
        hash = 53 * hash + Objects.hashCode(this.bairro_cliente);
        hash = 53 * hash + Objects.hashCode(this.cidade_cliente);
        hash = 53 * hash + Objects.hashCode(this.uf_cliente);
        hash = 53 * hash + Objects.hashCode(this.anamnese_Cliente);
        hash = 53 * hash + (int) (this.cpf_cliente ^ (this.cpf_cliente >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nascimento_cliente);
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
        final Cliente other = (Cliente) obj;
        if (this.id_Cliente != other.id_Cliente) {
            return false;
        }
        if (this.cpf_cliente != other.cpf_cliente) {
            return false;
        }
        if (!Objects.equals(this.nome_Cliente, other.nome_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.email_Cliente, other.email_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.telefone_Cliente, other.telefone_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.celular_Cliente, other.celular_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.endereco_Cliente, other.endereco_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.bairro_cliente, other.bairro_cliente)) {
            return false;
        }
        if (!Objects.equals(this.cidade_cliente, other.cidade_cliente)) {
            return false;
        }
        if (!Objects.equals(this.uf_cliente, other.uf_cliente)) {
            return false;
        }
        if (!Objects.equals(this.anamnese_Cliente, other.anamnese_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.nascimento_cliente, other.nascimento_cliente)) {
            return false;
        }
        return true;
    }

    
   
 
    
    
}
