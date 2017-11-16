/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.service;

import br.com.soclies.model.Caixa;
import br.com.soclies.repository.Caixas;
import br.com.soclies.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author patrickweigle
 */
public class CadastroSangriaCaixaService implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    Caixas sangriasCaixa;
    
    @Transactional
    public Caixa salvar(Caixa caixa){
        return sangriasCaixa.guardar(caixa);
    }
}
