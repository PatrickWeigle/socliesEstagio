/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Agenda;
import br.com.soclies.repository.Agendas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class PesquisaAgendaBean implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Inject
     Agendas repoAgendas;
     
     @Inject
     Agenda agenda;
     
     List<Agenda> agendasPesquisados;

    public PesquisaAgendaBean() {
        agendasPesquisados = new ArrayList<>();
        agenda = new Agenda();
    }

    public Agendas getRepoAgendas() {
        return repoAgendas;
    }

    public void setRepoAgendas(Agendas repoAgendas) {
        this.repoAgendas = repoAgendas;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Agenda> getAgendasPesquisados() {
        return agendasPesquisados;
    }

    public void setAgendasPesquisados(List<Agenda> agendasPesquisados) {
        this.agendasPesquisados = agendasPesquisados;
    }
    
    
     
     
    
}
