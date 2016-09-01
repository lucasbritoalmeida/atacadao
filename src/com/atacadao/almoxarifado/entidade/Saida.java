/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.entidade;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@XmlRootElement(name = "saida")
public class Saida {
    
    private String registro;
    private String solicitador;
    private String autorizador;
    private String patrimonio;
    private String nome;
    private Long validade;
    private String situacao;
    private String codigo;
    private String tipo;
    private Double valor;
    private String datasaida;

    public Saida(String registro, String solicitador, String autorizador, String patrimonio, String nome, Long validade, String situacao, String codigo, String tipo, Double valor) {
        this.registro = registro;
        this.solicitador = solicitador;
        this.autorizador = autorizador;
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.validade = validade;
        this.situacao = situacao;
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Saida(String registro, String solicitador, String autorizador, String patrimonio, String nome, Long validade, String situacao, String codigo, String tipo, Double valor, String datasaida) {
        this.registro = registro;
        this.solicitador = solicitador;
        this.autorizador = autorizador;
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.validade = validade;
        this.situacao = situacao;
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.datasaida = datasaida;
    }
    
    

    public Saida() {
    }

    @Override
    public String toString() {
        return "Saida{" + "registro=" + registro + ", solicitador=" + solicitador + ", autorizador=" + autorizador + ", patrimonio=" + patrimonio + ", nome=" + nome + ", validade=" + validade + ", situacao=" + situacao + ", codigo=" + codigo + ", tipo=" + tipo + ", valor=" + valor + '}';
    }

    @XmlElement(name="dataSaida")
    public String getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(String datasaida) {
        this.datasaida = datasaida;
    }
    
    
    @XmlElement(name="patrimonio")
    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    @XmlElement(name="nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlElement(name="validade")
    public Long getValidade() {
        return validade;
    }

    public void setValidade(Long validade) {
        this.validade = validade;
    }

    @XmlElement(name="situacao")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @XmlElement(name="codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlElement(name="tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlElement(name="valor")
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    @XmlElement(name="registro")
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @XmlElement(name="=solicitador")
    public String getSolicitador() {
        return solicitador;
    }

    public void setSolicitador(String solicitador) {
        this.solicitador = solicitador;
    }

    @XmlElement(name="autorizador")
    public String getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(String autorizador) {
        this.autorizador = autorizador;
    }
}
