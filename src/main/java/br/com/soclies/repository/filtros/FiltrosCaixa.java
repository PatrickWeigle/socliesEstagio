/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository.filtros;

import br.com.soclies.model.FormaDePagamento;
import br.com.soclies.model.TipoEntrada;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author patrickweigle
 */
public class FiltrosCaixa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataInicio;
    private Date dataFim;
    private TipoEntrada tipoEntrada;
    private FormaDePagamento formaPagamento;

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

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    
    
    

}
