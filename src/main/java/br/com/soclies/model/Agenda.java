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
import javax.validation.constraints.NotNull;

/**
 *
 * @author patrickweigle
 */
@Entity
@Table(name = "tab_Agenda")
public class Agenda {

    private Long id_Agenda;
    private Cliente cliente;
    private Date horario_Agenda;
    private String observacao_agenda;

    @Id
    @GeneratedValue
    public Long getId_Agenda() {
        return id_Agenda;
    }

    public void setId_Agenda(Long id_Agenda) {
        this.id_Agenda = id_Agenda;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_Cliente", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente id_Cliente) {
        this.cliente = id_Cliente;
    }

    @NotNull
    @Column(name = "horario_Agenda", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getHorario_Agenda() {
        return horario_Agenda;
    }

    public void setHorario_Agenda(Date horario_Agenda) {
        this.horario_Agenda = horario_Agenda;
    }

    @Column(name = "observacao_Agenda",  columnDefinition = "text")
    public String getObservacao_agenda() {
        return observacao_agenda;
    }

    public void setObservacao_agenda(String observacao_agenda) {
        this.observacao_agenda = observacao_agenda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id_Agenda);
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
        if (!Objects.equals(this.id_Agenda, other.id_Agenda)) {
            return false;
        }
        return true;
    }

}
