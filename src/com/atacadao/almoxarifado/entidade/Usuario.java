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
public class Usuario {
    
        private String nome;
        private String sobrenome;
        private int id;
        private String senha;
        private String login;
        private String niveis;

    public Usuario(String nome, String sobrenome, int id, String senha, String login, String niveis) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.id = id;
        this.senha = senha;
        this.login = login;
        this.niveis = niveis;
    }

    public Usuario(String nome, String sobrenome, int id, String senha, String login) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.id = id;
        this.senha = senha;
        this.login = login;
    }
      public Usuario(String nome, String sobrenome,String senha, String login) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.login = login;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNiveis() {
        return niveis;
    }

    public void setNiveis(String niveis) {
        this.niveis = niveis;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", id=" + id + ", senha=" + senha + ", login=" + login + '}';
    }    
}
