/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository.filtros;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author patrickweigle
 */
public class FiltrosAgenda implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nome_Cliente;
    
    private Long id = 1L;
    
    private Date dataInicio;
    
    private Date dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    
    
    

    public String getNome_Cliente() {
        return nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
    }
    
    
    
    
}
