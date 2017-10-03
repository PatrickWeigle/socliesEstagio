/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.util.jpa;

import br.com.soclies.model.Cliente;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author patrickweigle
 */
public class Transacao {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soclies");
        EntityManager manager = factory.createEntityManager();
        
        EntityTransaction transa = manager.getTransaction();
        
        transa.begin();
        
        Cliente cliente = new Cliente();
        cliente.setNome_Cliente("Patrick");
        cliente.setAnamnese_Cliente("dasdasdas");
        cliente.setBairro_cliente("dsaasdas");
        cliente.setCelular_Cliente("3234223");
        cliente.setCidade_cliente("dasdasdas");
        cliente.setCpf_cliente(312312312);
        cliente.setEmail_Cliente("asddasdas");
        cliente.setEndereco_Cliente("dsadasdasd");
        cliente.setNascimento_cliente(new Date());
        cliente.setTelefone_Cliente("dasdas");
        cliente.setUf_cliente("PR");
        
        manager.persist(cliente);
        
        transa.commit();
    }
}
