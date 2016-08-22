/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.conectividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Connections {
    
    /**
     * Esse metodo retorna um Connection - para fazer a conexão com o banco de dados
     * @return 
     */
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://almoxarifado.postgresql.dbaas.com.br:5432/almoxarifado","almoxarifado","master");
        } catch (SQLException ex) {
            System.out.println("com.atacadao.almoxarifado.Connections.getConnection() FALHA NA CONEXÃO");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("com.atacadao.almoxarifado.Connections.getConnection() ERRO NA CLASS");
            return null;
        }
    }
}
