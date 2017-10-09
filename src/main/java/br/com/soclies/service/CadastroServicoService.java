/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Servico;
import br.com.soclies.repository.Servicos;
import java.io.Serializable;
import javax.inject.Inject;


/**
 *
 * @author patrickweigle
 */
public class CadastroServicoService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private Servicos servicos;

    public Servico salvar(Servico servico) {
        return servicos.guardar(servico);
    }
}
