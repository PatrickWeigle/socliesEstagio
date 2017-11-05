/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.controller;

import br.com.soclies.model.Cliente;
import br.com.soclies.model.FormaDePagamento;
import br.com.soclies.model.Pedido;
import br.com.soclies.model.Servico;
import br.com.soclies.model.Servico_Pedido;
import br.com.soclies.repository.Clientes;
import br.com.soclies.repository.Servicos;
import br.com.soclies.service.CadastroPedidoService;
import br.com.soclies.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author patrickweigle
 */
@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes repoClientes;

    @Inject
    private Servicos repoServicos;

    @Inject
    private Pedido pedido;

    @Inject
    private CadastroPedidoService cadastroPedidoService;

    private Servico servicoLinhaEditavel;

    private Long id;

    public CadastroPedidoBean() {
        limpar();
    }

    public void salvar() {
        this.pedido.removerItemVazio();
        try {
            this.pedido = this.cadastroPedidoService.salvar(this.pedido);
            FacesUtil.addInfoMessage("Pedido adicionado com sucesso");
        } finally {
            this.pedido.adicionarItemVazio();
        }

    }

    private void limpar() {
        pedido = new Pedido();
    }

    public void inicializar() {

        if (FacesUtil.isNotPostback()) {
            this.pedido.adicionarItemVazio();
            this.recalcularPedido();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServicoLinhaEditavel() {
        return servicoLinhaEditavel;
    }

    public void setServicoLinhaEditavel(Servico servicoLinhaEditavel) {
        this.servicoLinhaEditavel = servicoLinhaEditavel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> completarCliente(String nome) {
        return this.repoClientes.porNome(nome);
    }

    public List<Servico> completarServico(String nome) {
        return this.repoServicos.porNome(nome);
    }

    public FormaDePagamento[] getFormaPagamento() {
        return FormaDePagamento.values();
    }

    public void recalcularPedido() {
        this.pedido.recalcularValorTotal();
        if (pedido != null) {
            pedido.recalcularValorTotal();
        }
    }

    public void carregarServicoPorID() {
        if (this.id != null) {
            this.servicoLinhaEditavel = this.repoServicos.retornaPorID(id);
        }
    }

    public void atualizarQuantidade(Servico_Pedido item, int linha) {
        if (item.getQuantidade_Servico() < 1) {
            if (linha == 0) {
                item.setQuantidade_Servico(1);
            } else {
                this.getPedido().getItensPedido().remove(linha);
            }
        }
        this.pedido.recalcularValorTotal();
    }

    private boolean existeItemComServico(Servico servico) {
        boolean resultado = false;
        for (Servico_Pedido item : this.getPedido().getItensPedido()) {
            if (servico.equals(item.getId_Servico())) {
                resultado = true;
                break;

            }
        }

        return resultado;
    }

    public void carregarServicoLinhaEditavel() {
        Servico_Pedido servico = this.pedido.getItensPedido().get(0);
        if (servicoLinhaEditavel != null) {
            if (this.existeItemComServico(this.servicoLinhaEditavel)) {
                FacesUtil.addInfoMessage("Esse item já existe no pedido");
            } else {
                servico.setId_Servico(this.servicoLinhaEditavel);
                servico.setValor_unitario(this.servicoLinhaEditavel.getValor_Servico());
                this.pedido.adicionarItemVazio();
                this.servicoLinhaEditavel = null;
                this.id = null;
                this.pedido.recalcularValorTotal();
            }
        }
    }

}
