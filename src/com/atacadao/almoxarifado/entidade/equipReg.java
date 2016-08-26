/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.entidade;

/**
 *
 * @author lucas
 */
public class equipReg {
    private String nota;
    private String nomeequipamento;
    private String validade;
    private String codigoequip;
    private String tipoequip;
    private String situequip;
    private Double valorquip;
    private String fornecedor;
    private Double custo;

    public equipReg(String nota, String nomeequipamento, String validade, String codigoequip, String tipoequip, String situequip, Double valorquip, String fornecedor, Double custo) {
        this.nota = nota;
        this.nomeequipamento = nomeequipamento;
        this.validade = validade;
        this.codigoequip = codigoequip;
        this.tipoequip = tipoequip;
        this.situequip = situequip;
        this.valorquip = valorquip;
        this.fornecedor = fornecedor;
        this.custo = custo;
    }

    
    
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNomeequipamento() {
        return nomeequipamento;
    }

    public void setNomeequipamento(String nomeequipamento) {
        this.nomeequipamento = nomeequipamento;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCodigoequip() {
        return codigoequip;
    }

    public void setCodigoequip(String codigoequip) {
        this.codigoequip = codigoequip;
    }

    public String getTipoequip() {
        return tipoequip;
    }

    public void setTipoequip(String tipoequip) {
        this.tipoequip = tipoequip;
    }

    public String getSituequip() {
        return situequip;
    }

    public void setSituequip(String situequip) {
        this.situequip = situequip;
    }

    public Double getValorquip() {
        return valorquip;
    }

    public void setValorquip(Double valorquip) {
        this.valorquip = valorquip;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
