/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import com.atacadao.almoxarifado.entidade.Entrada;
import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.persistencia.entradaConexao;
import com.atacadao.almoxarifado.persistencia.equipamentoConexao;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class EntradaDeEquipamentos {
    public void equipamentosRegistro(ArrayList<Equipamento> equipamento,Entrada entrada){
        equipamentoConexao.CasdastrarVarios(equipamento);
        entradaConexao.Cadastrar(entrada);
        
    }
}