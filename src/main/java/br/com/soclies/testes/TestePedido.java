/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.testes;

import br.com.soclies.model.Cliente;
import br.com.soclies.model.FormaDePagamento;
import br.com.soclies.model.Pedido;
import br.com.soclies.model.Servico;
import br.com.soclies.model.Servico_Pedido;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author patrickweigle
 */
public class TestePedido {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soclies");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction trx = manager.getTransaction();

        trx.begin();

        Cliente cliente = new Cliente();
        cliente.setNome_Cliente("Patrick Weigle");
        cliente.setEndereco_Cliente("AV. jk");
        cliente.setBairro_cliente("Centro");
        cliente.setCidade_cliente("Londrina");
        cliente.setTelefone_Cliente("999600586");

        Servico servico = new Servico();
        servico.setNome_Servico("Massagem");
        servico.setValor_Servico(new BigDecimal(50));

        manager.persist(cliente);
        manager.persist(servico);
        trx.commit();
        
        trx.begin();
        
        Cliente cliente2 = manager.find(Cliente.class, 1L);
        Servico servico2 = manager.find(Servico.class, 1L);

        Pedido pedido = new Pedido();
        pedido.setData_pedido(new Date());
        pedido.setObservacao_Pedido("NADA");
        pedido.setDesconto_Pedido(new BigDecimal(0));
        pedido.setPagamento_Pedido(FormaDePagamento.CARTAO_CREDITO);
        pedido.setId_cliente(cliente2);
        
        
        
        Servico_Pedido servico_pedido = new Servico_Pedido();
        servico_pedido.setQuantidade_Servico(1);
        servico_pedido.setPedido(pedido);
        servico_pedido.setId_Servico(servico2);
        pedido.getItensPedido().add(servico_pedido);
        
        manager.persist(pedido);
        trx.commit();
        
       
        
       

    }
}
