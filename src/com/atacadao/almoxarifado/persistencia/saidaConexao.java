/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.persistencia;

import com.atacadao.almoxarifado.conectividade.Connections;
import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.Saida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class saidaConexao {
    
    public static void Deletar(String registro){
        Connection conn = Connections.getConnection();
        String sql = "delete from saida where numerosaida=?";
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, registro);
            prepare.execute();
            
            if (conn.isClosed()) {
                return;
            }else{
                conn.close();
                prepare.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(saidaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cadastro(ArrayList<Equipamento> equipamentos,String solicitado, String autorizado){
        Connection conn = Connections.getConnection();
        String sql = "insert into saida (nome,validade,situacao,codigo,tipo,valor,patrimonio,"
                + "numerosaida,solicitante,autorizado)"
                + "values(?,?,?,?,?,?,?,?,?,?);";
        Calendar cld = Calendar.getInstance();
        Random random = new Random(cld.getTimeInMillis());
        int numerosaida = random.nextInt();
        
        PreparedStatement prepare = null;
        
        for (Equipamento equipamento : equipamentos) {
            try {
                
                prepare = conn.prepareStatement(sql);
                
                prepare.setString(1, equipamento.getNome());
                prepare.setString(2, String.valueOf(equipamento.getValidade()));
                prepare.setString(3, equipamento.getSituacao());
                prepare.setString(4, equipamento.getCodigo());
                prepare.setString(5, equipamento.getTipo());
                prepare.setDouble(6, equipamento.getValor());
                prepare.setString(7, equipamento.getPatrimonio());
                prepare.setString(8, Integer.toUnsignedString(numerosaida));
                prepare.setString(9, solicitado);
                prepare.setString(10,autorizado);
                
                prepare.execute();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(saidaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } 
        
        try {
            if (!conn.isClosed()) {
                conn.close();
                prepare.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(saidaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Equipamento> buscarPorPatrimonio(String numeroSaida){
        
        Connection conn = Connections.getConnection();
        String sql = "select * from saida where numerosaida like ?";
        ArrayList<Equipamento> saidas = new ArrayList<>();
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, '%'+numeroSaida+'%');
            
            ResultSet result = prepare.executeQuery();
            
            while (result.next()) {                
                saidas.add(new Equipamento(result.getString("patrimonio"),result.getString("nome"), Long.valueOf(result.getString("validade"))
                        ,result.getString("situacao"), result.getString("codigo"),result.getString("tipo"), result.getDouble("valor")));
            }
            
            if (!conn.isClosed()) {
                conn.close();
                prepare.close();
            }
            
            if (saidas.isEmpty()) {
                return null;
            }else{
                return saidas;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(saidaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Saida> buscarTodos(){
        
        Connection conn = Connections.getConnection();
        String sql = "select * from saida";
        ArrayList<Saida> saidas = new ArrayList<>();
        
        PreparedStatement prepare = null;
        
        try {
            prepare = conn.prepareStatement(sql);
            
            ResultSet result = prepare.executeQuery();
            
            while (result.next()) {                
                saidas.add(new Saida(result.getString("numerosaida"),result.getString("solicitante"),result.getString("autorizado")
                ,result.getString("patrimonio"),result.getString("nome"),Long.valueOf(result.getString("validade")),result.getString("situacao"),
                result.getString("codigo"),result.getString("tipo"),result.getDouble("valor")));
            }
            
            if (!conn.isClosed()) {
                conn.close();
                prepare.close();
                    if (saidas.isEmpty()) {
                        return null;
                    }else{
                        return saidas;
                    }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(saidaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
