/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

/**
 *
 * @author lucas
 */
public enum Codigos {
    MAN("MANUTENCAO",1),
    INF("INFORMATICA",2),
    CX("CAIXA",3),
    ESC("ESCRITORIO",4),
    LIMP("LIMPEZA",5),
    LJ("LOJA",6),
    ALIM("ALIMENTACAO",7);
    
    private String codigo;
    private Integer numero;

    private Codigos(String codigo, Integer numero) {
        this.codigo = codigo;
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
    
}
