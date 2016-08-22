/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.entidade;

import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class Entrada {
    private String numeroNota;
    private String fornecedor;
    private String dataCompra;
    private Double custo;
    private ArrayList<Equipamento> Produtos;

    @Override
    public String toString() {
        return "entrada{" + "numeroNota=" + numeroNota +  ", dataCompra=" + dataCompra + ", custo=" + custo + ", Produtos" + Produtos + '}';
    }

    public Entrada() {
    }

    public Entrada(String numeroNota, Integer quantidade, String dataCompra, Double custo, ArrayList<Equipamento> Produtos) {
        this.numeroNota = numeroNota;       
        this.dataCompra = dataCompra;
        this.custo = custo;
        this.Produtos = Produtos;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }
    
    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ArrayList<Equipamento> getProdutos() {
        return Produtos;
    }

    public void setProdutos(ArrayList<Equipamento> Produtos) {
        this.Produtos = Produtos;
    }
    
}
