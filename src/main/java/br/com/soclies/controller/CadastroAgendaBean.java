/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Agenda;
import br.com.soclies.model.Cliente;
import br.com.soclies.repository.Clientes;
import br.com.soclies.service.CadastroAgendaService;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author patrickweigle
 */

@Named
@ViewScoped
public class CadastroAgendaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Agenda agenda;
    
    @Inject
    private Clientes repoClientes;
    
    @Inject
    private CadastroAgendaService cadastroAgendaService;
    
    private ScheduleModel agendaSchedule;

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public ScheduleModel getAgendaSchedule() {
        return agendaSchedule;
    }

    public void setAgendaSchedule(ScheduleModel agendaSchedule) {
        this.agendaSchedule = agendaSchedule;
    }
    
    public List<Cliente> completarCliente(String nome) {
        return this.repoClientes.porNome(nome);
    }
    
    public void salvar(){
        this.agenda = cadastroAgendaService.salvar(agenda);
        FacesUtil.addInfoMessage("Agenda salva com sucesso!");
        limparCampos();
    }
    
    public void limparCampos(){
        agenda = new Agenda();
    }
    
    public void capturaData(SelectEvent dataSelecionada){
        agenda = new Agenda();
        agenda.setHorario_Agenda((Date)dataSelecionada.getObject());
    }
}
