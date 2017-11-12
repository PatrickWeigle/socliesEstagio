/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Agenda;
import br.com.soclies.repository.Agendas;
import br.com.soclies.repository.filtros.FiltrosAgenda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class PesquisaAgendaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Agendas repoAgendas;

    @Inject
    private Agenda agenda;

    private ScheduleModel listagem;
    
    private Agenda agendaSelecionado;
    
    private ScheduleEvent evento = new DefaultScheduleEvent();
    
    private FiltrosAgenda filtrosAgenda;

    private List<Agenda> agendasPesquisados;

    public PesquisaAgendaBean() {
        agendasPesquisados = new ArrayList<>();
        agenda = new Agenda();
        filtrosAgenda = new FiltrosAgenda();
        listagem = new DefaultScheduleModel();
        listagem.addEvent(new DefaultScheduleEvent("Champions League Match", new Date(), new Date()));
    }

    public ScheduleModel getListagem() {
        return listagem;
    }

    public void setListagem(ScheduleModel listagem) {
        this.listagem = listagem;
    }

    public Agendas getRepoAgendas() {
        return repoAgendas;
    }

    public void setRepoAgendas(Agendas repoAgendas) {
        this.repoAgendas = repoAgendas;
    }

    public Agenda getAgendaSelecionado() {
        return agendaSelecionado;
    }

    public void setAgendaSelecionado(Agenda agendaSelecionado) {
        this.agendaSelecionado = agendaSelecionado;
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
    
    public void buscar(){
        agendasPesquisados = repoAgendas.getBuscados(filtrosAgenda);
        eventos();
    }
    
    public void eventos(){
        listagem = new DefaultScheduleModel();
        for(Agenda temp : agendasPesquisados){
            listagem.addEvent(new DefaultScheduleEvent(temp.getCliente().getNome_Cliente(), temp.getHorario_Agenda(), temp.getHorario_Agenda_Termino()));
        }
    }
    
    
    public void remover(){
        repoAgendas.remover(agendaSelecionado);
    }

}
