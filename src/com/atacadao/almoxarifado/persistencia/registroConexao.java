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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class registroConexao {

public static void Cadastrar(String nota, ArrayList<Equipamento> equipamentos){
    Connection conn = Connections.getConnection();
    
    String sql = "insert into registro (nota,nomeequipamento,validade,codigoequip,tipoequip,situequip,valorequip)"
            + "values(?,?,?,?,?,?,?);";
    
    PreparedStatement prepare = null;
    
    for (Equipamento equipamento : equipamentos) {
        
    try {
        prepare = conn.prepareStatement(sql);
        prepare.setString(1, nota);
        prepare.setString(2, equipamento.getNome());
        prepare.setString(3, String.valueOf(equipamento.getValidade()));
        prepare.setString(4, equipamento.getCodigo());
        prepare.setString(5, equipamento.getTipo());
        prepare.setString(6, equipamento.getSituacao());
        prepare.setDouble(7, Double.valueOf(equipamento.getValor()));
        
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
    
}
