/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.persistencia;

import com.atacadao.almoxarifado.conectividade.Connections;
import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.equipReg;
import java.sql.Connection;
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
public class registroConexao {

public static void Cadastrar(String nota, String fornecedor, Double custos,String dtcompra,ArrayList<Equipamento> equipamentos){
    Connection conn = Connections.getConnection();
    
    String sql = "insert into registro (nota,fornecedor,custo,nomeequipamento,validade,codigoequip,tipoequip,situequip,valorequip,dtcompra)"
            + "values(?,?,?,?,?,?,?,?,?,?);";
    
    PreparedStatement prepare = null;
    
    for (Equipamento equipamento : equipamentos) {
        
    try {
        prepare = conn.prepareStatement(sql);
        prepare.setString(1, nota);
        prepare.setString(2, fornecedor);
        prepare.setDouble(3, custos);
        prepare.setString(4, equipamento.getNome());
        prepare.setString(5, String.valueOf(equipamento.getValidade()));
        prepare.setString(6, equipamento.getCodigo());
        prepare.setString(7, equipamento.getTipo());
        prepare.setString(8, equipamento.getSituacao());
        prepare.setDouble(9, Double.valueOf(equipamento.getValor()));
        prepare.setString(10, dtcompra);
        
        prepare.execute();
    } catch (SQLException ex) {
        Logger.getLogger(registroConexao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}    
        try {
            if (!conn.isClosed()) {
                prepare.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(registroConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}

public static ArrayList<equipReg> buscarTodos(String nota){
    Connection conn = Connections.getConnection();
    String sql = "select * from registro where nota like ?";
    
    ArrayList<equipReg> registros = new ArrayList<>();
    
    PreparedStatement prepare = null;
    
    try {
        prepare = conn.prepareCall(sql);
        prepare.setString(1, nota);
        ResultSet result = prepare.executeQuery();
        
        while (result.next()) {            
            registros.add(new equipReg(result.getString("nota"), result.getString("nomeequipamento"),
                    result.getString("validade"),result.getString("codigoequip") , result.getString("tipoequip")
                    ,result.getString("situequip"), result.getDouble("valorequip"), result.getString("fornecedor")
                    , result.getDouble("custo")));
        }
        if (registros.isEmpty()) {
            conn.close();
            prepare.close();
            return null;
        }else{
            conn.close();
            prepare.close();
            return registros;
        }
    } catch (SQLException ex) {
        Logger.getLogger(registroConexao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

    
}
