/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Servico;
import br.com.soclies.repository.Servicos;
import br.com.soclies.repository.filtros.FiltrosServico;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
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
public class PesquisaServicoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Servicos repoServicos;

    @Inject
    private Servico servico;

    private List<Servico> servicosPesquisados;
    
    private Servico servicoSelecionado;
    
    private String servicoPesquisado;
    
    private FiltrosServico filtroServico;

    public PesquisaServicoBean() {
        filtroServico = new FiltrosServico();
    }
    
    
    public Servico getServicoSelecionado() {
        return servicoSelecionado;
    }

    public void setServicoSelecionado(Servico servicoSelecionado) {
        this.servicoSelecionado = servicoSelecionado;
    }

    public FiltrosServico getFiltroServico() {
        return filtroServico;
    }

    public String getServicoPesquisado() {
        return servicoPesquisado;
    }

    public void setServicoPesquisado(String servicoPesquisado) {
        this.servicoPesquisado = servicoPesquisado;
    }

    public List<Servico> getServicosPesquisados() {
        return servicosPesquisados;
    }

    public void setServicosPesquisados(List<Servico> servicosPesquisados) {
        this.servicosPesquisados = servicosPesquisados;
    }
    
    
    
    public void buscar() {
        servicosPesquisados = repoServicos.getbuscados(filtroServico);
    }
    
    public void excluir(){
        repoServicos.remover(servicoSelecionado);
        servicosPesquisados.remove(servicoSelecionado);
        FacesUtil.addInfoMessage("Servico Removido com Sucesso");
                
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }



}
