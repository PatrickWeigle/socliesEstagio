/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Agenda;
import br.com.soclies.service.CadastroAgendaService;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author patrickweigle
 */
public class CadastroAgendaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Agenda agenda;
    
    @Inject
    private CadastroAgendaService cadastroAgendaService;

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    public void salvar(){
        
    }
}
