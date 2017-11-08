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
public class FiltrosPedido implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long numeroDe;
    private Long numeroAte;
    private Date dataInicio;
    private Date dataFim;
    private String nomeCliente;

    public Long getNumeroDe() {
        return numeroDe;
    }

    public void setNumeroDe(Long numeroDe) {
        this.numeroDe = numeroDe;
    }

    public Long getNumeroAte() {
        return numeroAte;
    }

    public void setNumeroAte(Long numeroAte) {
        this.numeroAte = numeroAte;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
    
}
