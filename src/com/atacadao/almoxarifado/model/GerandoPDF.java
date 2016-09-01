/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import com.atacadao.almoxarifado.entidade.Saida;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class GerandoPDF {
    public void pdfDeSaida(ArrayList<Saida> saidas){
        Document documento = new Document();
        
        try {
            PdfWriter pdf;
            pdf = PdfWriter.getInstance(documento, new FileOutputStream("saidas.pdf"));

            documento.open();
            
            for (Saida saida : saidas) {
                documento.add(new Paragraph(saida.getNome() +"\t"
                +saida.getPatrimonio() + "\t" + String.valueOf(saida.getValor())
                + "\t" + saida.getAutorizador() + "\t " + saida.getSolicitador()));
            }
            
            documento.close();
            Desktop.getDesktop().open(new File("saidas.pdf"));
            
        } catch (DocumentException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
