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
public class Equipamento {

    public Equipamento() {
    }

    public Equipamento(String nome, Long validade, String situacao, String codigo, String tipo, Double valor) {
        this.nome = nome;
        this.validade = validade;
        this.situacao = situacao;
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Equipamento(String patrimonio, String nome, Long validade, String situacao, String codigo, String tipo) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.validade = validade;
        this.situacao = situacao;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Equipamento(String patrimonio, String nome, Long validade, String situacao, String codigo, String tipo, Double valor) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.validade = validade;
        this.situacao = situacao;
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "patrimonio=" + patrimonio + ", nome=" + nome + ", validade=" + validade + ", situacao=" + situacao + ", codigo=" + codigo + ", tipo=" + tipo + '}';
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getValidade() {
        return validade;
    }

    public void setValidade(Long validade) {
        this.validade = validade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    private String patrimonio;
    private String nome;
    private Long validade;
    private String situacao;
    private String codigo;
    private String tipo;
    private Double valor;

}
