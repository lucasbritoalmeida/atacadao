/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.persistencia;

import com.atacadao.almoxarifado.conectividade.Connections;
import com.atacadao.almoxarifado.entidade.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class equipamentoConexao {
    
    public static ArrayList<Equipamento> consultar(Equipamento equipamentos, Integer quantidade){
        Connection conn = Connections.getConnection();
        String sql = "select * from equipamentos where nome like ? AND codigo like ?";
        Integer i = 1;
        
        ArrayList<Equipamento> equips = new ArrayList<>();
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, equipamentos.getNome());
            prepare.setString(2, equipamentos.getCodigo());

            ResultSet result = prepare.executeQuery();
            
            while (result.next() && i <= quantidade) {                
                equips.add(new Equipamento(result.getString("patrimonio"), result.getString("nome"),
                        result.getLong("validade"), result.getString("situacao"),result.getString("codigo")
                        , result.getString("tipo"), result.getDouble("valor")));
                i++;
            }
            
            if(quantidade <= i){
                if (!conn.isClosed()) {
                    conn.close();
                    prepare.close();
                }
                return equips;
            }else{
                conn.close();
                prepare.close();
                return equips;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(equipamentoConexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            System.out.println("AQUI *******************");
        }
        
        
        
        return null;
    }
    
    public static void Cadastrar(Equipamento equipamento){
        Connection conn = Connections.getConnection();    
        String sql = "insert into equipamentos (nome,validade,situacao,codigo,tipo,valor) values(?,?,?,?,?,?);";
        PreparedStatement prepare = null;
        try {
             prepare = conn.prepareStatement(sql);
             prepare.setString(1, equipamento.getNome());
             prepare.setLong(2, equipamento.getValidade());
             prepare.setString(3, equipamento.getSituacao());
             prepare.setString(4, equipamento.getCodigo());
             prepare.setString(5, equipamento.getTipo());
             prepare.setDouble(6, equipamento.getValor());
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
    
    public static void CadastrarComPatrimonio(Equipamento equipamento){
        Connection conn = Connections.getConnection();    
        String sql = "insert into equipamentos (nome,validade,situacao,codigo,tipo,valor,patrimonio) values(?,?,?,?,?,?,?);";
        PreparedStatement prepare = null;
        try {
             prepare = conn.prepareStatement(sql);
             prepare.setString(1, equipamento.getNome());
             prepare.setLong(2, equipamento.getValidade());
             prepare.setString(3, equipamento.getSituacao());
             prepare.setString(4, equipamento.getCodigo());
             prepare.setString(5, equipamento.getTipo());
             prepare.setDouble(6, equipamento.getValor());
             prepare.setInt(7, Integer.valueOf(equipamento.getPatrimonio()));
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
    
    
    public static void atualizar(Equipamento equipamento) {
            Connection conn = Connections.getConnection();
            String sql = "update equipamentos set nome=?, validade=?, situacao=?, codigo=?, tipo=?, valor=? where patrimonio=?;";
            
            PreparedStatement prepare = null;
            
        try {
            
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, equipamento.getNome());
            prepare.setLong(2, equipamento.getValidade());
            prepare.setString(3, equipamento.getSituacao());
            prepare.setString(4, equipamento.getCodigo());
            prepare.setString(5, equipamento.getTipo());
            prepare.setDouble(6, equipamento.getValor());
            prepare.setInt(7, Integer.valueOf(equipamento.getPatrimonio()));
            
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
    
    public static void atualizarVarios(ArrayList<Equipamento> equipamentos){
        Connection conn = Connections.getConnection();
        String sql = "update equipamentos set nome=?, validade=?, situacao=?, codigo=?, tipo=?, valor=? where patrimonio=?;";
        PreparedStatement prepare = null;
        
        for (Equipamento equipamento : equipamentos) {
            try {
                prepare = conn.prepareStatement(sql);
                prepare.setString(1, equipamento.getNome());
                prepare.setLong(2, equipamento.getValidade());
                prepare.setString(3, equipamento.getSituacao());
                prepare.setString(4, equipamento.getCodigo());
                prepare.setString(5, equipamento.getTipo());
                prepare.setDouble(6, equipamento.getValor());
                prepare.setInt(6, Integer.valueOf(equipamento.getPatrimonio()));
                
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
    
    public static void deletar(String patrimonio){
        Connection conn = Connections.getConnection();
        String sql = "delete from equipamentos where patrimonio=?";
        
        PreparedStatement prepare = null;
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(patrimonio));
            
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
    
    public static void CasdastrarVarios(ArrayList<Equipamento> equipamentos){
        Connection conn = Connections.getConnection();
        String sql = "insert into equipamentos (nome,validade,situacao,codigo,tipo,valor) values(?,?,?,?,?,?);";
        PreparedStatement prepare = null;
        
        for (Equipamento equipamento : equipamentos) {
            try {
                prepare = conn.prepareStatement(sql);
                prepare.setString(1, equipamento.getNome());
                prepare.setLong(2, equipamento.getValidade());
                prepare.setString(3, equipamento.getSituacao());
                prepare.setString(4, equipamento.getCodigo());
                prepare.setString(5, equipamento.getTipo());
                prepare.setDouble(6, equipamento.getValor());
                
                prepare.execute();
                
            } catch (SQLException ex) {
                Logger.getLogger(equipamentoConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            if (!conn.isClosed()) {
                prepare.close();
                conn.close();                
            }
        } catch (SQLException ex) {
            Logger.getLogger(equipamentoConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<Equipamento> buscarTodos(){
        Connection conn = Connections.getConnection();
        String sql = "select * from equipamentos";
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            
            ArrayList<Equipamento> equipamentos = new ArrayList<>();
            
            ResultSet resultSet = prepare.executeQuery();
            
            while (resultSet.next()) {                
                equipamentos.add(new Equipamento(resultSet.getString("patrimonio"), resultSet.getString("nome"),
                        resultSet.getLong("validade"), resultSet.getString("situacao"),
                        resultSet.getString("codigo"), resultSet.getString("tipo"),resultSet.getDouble("valor")));
            }
            
            prepare.close();
            conn.close();
            return  equipamentos;
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
    
    public static ArrayList<Equipamento> buscarPorNome(String nome){
        Connection conn = Connections.getConnection();
        String sql = "select * from equipamentos where nome like ?";
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, '%'+nome+'%');
            
            ResultSet result = prepare.executeQuery();
            
            while (result.next()) {                
                equipamentos.add(new Equipamento( result.getString("patrimonio"), result.getString("nome"),
                        Long.valueOf(result.getString("validade")),result.getString("situacao"),
                        result.getString("codigo"),result.getString("tipo"),result.getDouble("valor")));        
            }
            
            if (!conn.isClosed()) {
                prepare.close();
                conn.close();
                if (equipamentos.isEmpty()) {
                    return null;
                }else{
                    return equipamentos;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(equipamentoConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return null;
    }
    
    public static Integer consultaQuantidade(Equipamento equipamento){
        Connection conn = Connections.getConnection();
        String sql = "select * from where nome = ? ";
        int cont = 0;
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, equipamento.getNome());
            ResultSet result = prepare.executeQuery();
            
            while (result.next()) {                
                ++cont;
            }
            
            if (!conn.isClosed()) {
                prepare.close();
                conn.close();
            }
            
            return cont;
            
        } catch (SQLException ex) {
            Logger.getLogger(equipamentoConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cont;
    }
        
}
