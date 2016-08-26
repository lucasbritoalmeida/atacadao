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
public class FormatandoDouble {
    
    public static Double FormatandoValores(String doubles){
        String replaceAll = doubles.replace(".", "");
        String replace = replaceAll.replace(",", ".");
        Double valor = Double.valueOf(replace);
        return valor;
    }
    public static String FormatandoValoresString(String doubles){
        String replaceAll = doubles.replace(".", "");
        String replace = replaceAll.replace(",", ".");
        return replace;
    }
    
    public static String DoubleParaString(String valor){
        String replace = valor.replace(".", ",");
        return replace;
    }
    
    public static void main(String[] args) {
        System.out.println(FormatandoValoresString("1.251.254,34"));
    }
}
