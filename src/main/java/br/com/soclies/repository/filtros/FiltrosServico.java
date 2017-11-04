/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.repository.filtros;

import java.io.Serializable;

/**
 *
 * @author patrickweigle
 */
public class FiltrosServico implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String servico;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
}
