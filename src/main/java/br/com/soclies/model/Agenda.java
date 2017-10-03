/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Agenda")
public class Agenda {
    private int id_Agenda;
    private Cliente id_Cliente;
    private Date horario_Agenda;
    private String observacao_agenda;

    
    @Id
    @GeneratedValue
    public int getId_Agenda() {
        return id_Agenda;
    }

    public void setId_Agenda(int id_Agenda) {
        this.id_Agenda = id_Agenda;
    }

    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    public Cliente getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

   
    @Column(name = "horario_Agenda",nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getHorario_Agenda() {
        return horario_Agenda;
    }

    public void setHorario_Agenda(Date horario_Agenda) {
        this.horario_Agenda = horario_Agenda;
    }

    public String getObservacao_agenda() {
        return observacao_agenda;
    }

    public void setObservacao_agenda(String observacao_agenda) {
        this.observacao_agenda = observacao_agenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_Agenda;
        hash = 59 * hash + Objects.hashCode(this.id_Cliente);
        hash = 59 * hash + Objects.hashCode(this.horario_Agenda);
        hash = 59 * hash + Objects.hashCode(this.observacao_agenda);
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
        final Agenda other = (Agenda) obj;
        if (this.id_Agenda != other.id_Agenda) {
            return false;
        }
        if (!Objects.equals(this.observacao_agenda, other.observacao_agenda)) {
            return false;
        }
        if (!Objects.equals(this.id_Cliente, other.id_Cliente)) {
            return false;
        }
        if (!Objects.equals(this.horario_Agenda, other.horario_Agenda)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
