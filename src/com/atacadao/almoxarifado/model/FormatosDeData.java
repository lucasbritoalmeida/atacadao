/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class FormatosDeData {
    public static String formatarLongParaDatas(Long data){
        Date datas = new Date(data);
        Locale lcl = new Locale("pt", "BR");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY", lcl);
        return sdf.format(datas);

    }
    
    public static Long formatarDatasParaLong(String data){
       
        String[] dataCortada = data.split("/");
        Locale lcl = new Locale("pt", "BR");
        
        Calendar clc = Calendar.getInstance();
        clc.set(Integer.valueOf(dataCortada[2]), Integer.valueOf(dataCortada[1]), Integer.valueOf(dataCortada[0]));
        return clc.getTimeInMillis();

    }
    
    public static void main(String[] args) {
        System.out.println(formatarLongParaDatas(formatarDatasParaLong("23/08/2016")));
        
    }
}
