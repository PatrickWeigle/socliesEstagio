/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.soclies.testes;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author patrickweigle
 */
public class GerarTabelas {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soclies");
    }
}
