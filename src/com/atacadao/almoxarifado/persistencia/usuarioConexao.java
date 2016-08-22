/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.persistencia;

import java.sql.Connection;
import com.atacadao.almoxarifado.conectividade.Connections;
import com.atacadao.almoxarifado.entidade.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class usuarioConexao {
        
    public static void Cadastrar(Usuario user){
        Connection conn = Connections.getConnection();    
        String sql = "insert into usuarios (login,nome,sobrenome,senha,niveis) values(?,?,?,?,?);";
        PreparedStatement prepare = null;
        try {
             prepare = conn.prepareStatement(sql);
             prepare.setString(1, user.getLogin());
             prepare.setString(2, user.getNome());
             prepare.setString(3, user.getSobrenome());
             prepare.setString(4, user.getSenha());
             prepare.setString(5, user.getNiveis());
             prepare.execute();
             
             prepare.close();
             conn.close();
             
        } catch (SQLException ex) {
            try {
                conn.close();
            } catch (SQLException ex1) {
                System.out.println("erro de conexão");
            }
            System.out.println("erro de conexão");
        }
    }
    
    public static void atualizar(Usuario user) {
            Connection conn = Connections.getConnection();
            String sql = "update usuarios set nome=?, sobrenome=?, senha=? where login=?;";
            
            PreparedStatement prepare = null;
            
        try {
            
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, user.getNome());
            prepare.setString(2, user.getSobrenome());
            prepare.setString(3, user.getSenha());
            prepare.setString(4, user.getLogin());
            
            prepare.execute();
            
            prepare.close();
            conn.close();
        } catch (SQLException ex) {
                try {
                    conn.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex1);
                }
            Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizarPorId(Usuario user) {
            Connection conn = Connections.getConnection();
            String sql = "update usuarios set nome=?, sobrenome=?, login=? where id=?;";
            
            PreparedStatement prepare = null;
            
        try {
            
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, user.getNome());
            prepare.setString(2, user.getSobrenome());
            prepare.setString(3, user.getLogin());
            prepare.setInt(4, user.getId());
            
            prepare.execute();
            
            prepare.close();
            conn.close();
        } catch (SQLException ex) {
                try {
                    conn.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex1);
                }
            Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizarVarios(ArrayList<Usuario> users){
        Connection conn = Connections.getConnection();
        String sql = "update usuarios set nome=?, sobrenome=?, senha=? where login=?;";
        PreparedStatement prepare = null;
        
        for (Usuario user : users) {
            try {
                prepare = conn.prepareStatement(sql);
                prepare.setString(1, user.getNome());
                prepare.setString(2, user.getSobrenome());
                prepare.setString(3, user.getSenha());
                prepare.setString(4, user.getLogin());
                
                prepare.execute();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            prepare.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public static void deletar(String login){
        Connection conn = Connections.getConnection();
        String sql = "delete from usuarios where login=?";
        
        PreparedStatement prepare = null;
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, login);
            
            prepare.execute();
            
            prepare.close();
            conn.close();
        } catch (SQLException ex) {
            
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Usuario> buscarPorLogin(String login){
        Connection conn = Connections.getConnection();
        String sql = "select * from usuarios where login like ?";
        PreparedStatement prepare = null;
        ArrayList<Usuario> users  = new  ArrayList<Usuario>();
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + login + "%");
            
            
            ResultSet resultSet = prepare.executeQuery();
            
            while(resultSet.next()) {                       
                users.add( new Usuario(resultSet.getString("nome"),resultSet.getString("sobrenome") , Integer.valueOf(resultSet.getString("id"))
                        ,resultSet.getString("senha") , resultSet.getString("login")));
            }
            
            return users;
        } catch (SQLException ex) {
            try {
                conn.close();
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
        }finally{
            try {
                prepare.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public static ArrayList<Usuario> buscarTodos(){
        Connection conn = Connections.getConnection();
        String sql = "select * from usuarios";
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            
            ArrayList<Usuario> usuarios = new ArrayList<>();
            
            ResultSet resultSet = prepare.executeQuery();
            
            while (resultSet.next()) {                
                usuarios.add(new Usuario(resultSet.getString("nome"), resultSet.getString("sobrenome"),
                        resultSet.getInt("id"), resultSet.getString("senha"), resultSet.getString("login")));
            }
            prepare.close();
            conn.close();
            
            
            return  usuarios;
        } catch (SQLException ex) {
            try {
                conn.close();
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
        }
    } 
    
    public static boolean autenticar(String login, String senha){
        Connection conn = Connections.getConnection();
        String sql = "select * from usuarios where login = ? AND senha = ?";
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, login);
            prepare.setString(2, senha);
            
            ResultSet resultSet = prepare.executeQuery();
            
            if (resultSet.next()) {
                return true;
            }
            
            return false;
            
            } catch (SQLException ex) {
            Logger.getLogger(usuarioConexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}