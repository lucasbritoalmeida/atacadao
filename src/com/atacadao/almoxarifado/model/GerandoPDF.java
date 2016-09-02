/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.Saida;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfTable;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class GerandoPDF {
    public void pdfDeSaida(ArrayList<Equipamento> equipamentos, String solicitante, String autorizante,int numeroSaida){
        Document documento = new Document();
        
        try {
            PdfWriter pdf;
            pdf = PdfWriter.getInstance(documento, new FileOutputStream("saidas.pdf"));

            documento.open();
            documento.addTitle("SOLICITAÇÃO DE EQUIPAMENTOS");
            
            /**
             * Responsavel pelo cabeçalho do documento
             */
//            Image imagem = Image.getInstance(getClass().getResource("atacadao.jpg"));
//            imagem.setAlignment(Element.ALIGN_CENTER);
//            documento.add(imagem);
            
            Paragraph titulo = new Paragraph("SOLICITAÇÃO DE EQUIPAMENTOS"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 16, 0, BaseColor.BLACK));
           
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            
            documento.setMargins(0, 0, 18, 0);
            
            Date datas = new Date();
            Locale local = new Locale("pt", "BR");
            SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy", local);
            
            Paragraph espaco = new Paragraph("\n\nDeclaro para os devidos fins que eu " + solicitante
                +" recebi na " +sdf.format(datas) + " os equipamentos abaixo relacionados da empresa "
                    + "Atacadão dos Pisos por " + autorizante+".\n"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.BLACK));
            
            documento.add(espaco);
            
            documento.add(new Paragraph("\n Numero de registro : " + numeroSaida+"\n\n"));
            /**
             * Responsavel por cria a tabela da saída dos equipamentos
             */
            PdfPTable pdfT = new PdfPTable(4);
            PdfPCell celulas = new PdfPCell(new Paragraph("Relação de equipamentos solicitados para seus devidos fins."
                    + " Favor caso haja devolução manter o maximo possível do estado atual dos mesmos. Grato !!!"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 11, 0, BaseColor.GRAY)));
            celulas.setColspan(4);
            
            
            PdfPCell patrimonio = new PdfPCell(new Paragraph("PATRIMONIO"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)));
            patrimonio.setBackgroundColor(BaseColor.GRAY);
            patrimonio.setPadding((float) 1);
            
            PdfPCell Nome = new PdfPCell(new Paragraph("NOME"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)));
            Nome.setBackgroundColor(BaseColor.GRAY);
            Nome.setPadding((float) 1);
            
            PdfPCell Situacao = new PdfPCell(new Paragraph("SITUAÇÃO"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)));
            Situacao.setBackgroundColor(BaseColor.GRAY);
            Situacao.setPadding((float) 1);
            
            PdfPCell valor = new PdfPCell(new Paragraph("DESTINO"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)));
            valor.setBackgroundColor(BaseColor.GRAY);
            valor.setPadding((float) 1);
            
            pdfT.addCell(celulas);
            pdfT.addCell(patrimonio);pdfT.addCell(Nome);pdfT.addCell(Situacao);pdfT.addCell(valor);
            
            for (Equipamento equipamento : equipamentos) {
                
                PdfPCell patrimonios = new PdfPCell(new Paragraph(equipamento.getPatrimonio()
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 10, 0, BaseColor.BLACK)));
            patrimonios.setBackgroundColor(BaseColor.WHITE);
            Situacao.setPadding((float) 0.8);
                pdfT.addCell(patrimonios);
                
                PdfPCell nomes = new PdfPCell(new Paragraph(equipamento.getNome()
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 10, 0, BaseColor.BLACK)));
            nomes.setBackgroundColor(BaseColor.WHITE);
            nomes.setPadding((float) 0.8);
                pdfT.addCell(nomes);
                
                PdfPCell situacoes = new PdfPCell(new Paragraph(equipamento.getSituacao()
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 10, 0, BaseColor.BLACK)));
            situacoes.setBackgroundColor(BaseColor.WHITE);
            situacoes.setPadding((float) 0.8);
                pdfT.addCell(situacoes);
                
                PdfPCell valores = new PdfPCell(new Paragraph(equipamento.getCodigo()
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 10, 0, BaseColor.BLACK)));
            valores.setBackgroundColor(BaseColor.WHITE);
            valores.setPadding((float) 0.8);
                pdfT.addCell(valores);
                
            }
            documento.add(pdfT);
            
            /**
             * Cria tabela para assinatura do solicitante e autorizado
             */
            PdfPTable pdfTs = new PdfPTable(5);
          
            Paragraph sol = new Paragraph("\n\n" + solicitante
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, Font.ITALIC));
            sol.setAlignment(Element.ALIGN_CENTER);
            PdfPCell ass = new PdfPCell(sol);
            ass.setBorder(0);
            ass.setBorderWidthTop(1);
            ass.setColspan(2);
            
            PdfPCell espacos = new PdfPCell();
            espacos.setBorder(0);
            
            
            Paragraph auth = new Paragraph("\n\n" + autorizante
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, Font.ITALIC));
            auth.setAlignment(Element.ALIGN_CENTER);
            PdfPCell ass2 = new PdfPCell(auth);
            ass2.setBorder(0);
            ass2.setBorderWidthTop(1);
            ass2.setColspan(2);
            
            
            pdfTs.addCell(ass);
            pdfTs.addCell(espacos);
            pdfTs.addCell(ass2);
            
            
            documento.add(new Paragraph("\n\n\n"));
            documento.add(pdfTs);
            
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

    public void pdfRelatorio(ArrayList<Saida> saidas){
        Document documento = new Document(PageSize.A4,0,0,0,0);
        try {
            PdfWriter pdfs = PdfWriter.getInstance(documento, new FileOutputStream("relatoriosaida.pdf"));
            documento.open();
            
            PdfPTable table = new PdfPTable(2);
            Image imagem = Image.getInstance("atacadao.jpg");
            
            PdfPCell logo = new PdfPCell(imagem);
            logo.setBorder(0);
            
            PdfPCell titulos = new PdfPCell(new Paragraph("Relatórios de Saidas"
                    , new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 22, Font.BOLD, BaseColor.BLACK)));
            titulos.setBorder(0);
            titulos.setPadding(0);
            
            
            table.addCell(logo);
            table.addCell(titulos);
            
            documento.add(table);
            
            /* IMPLEMENTAR RELATÓRIO AQUI*/
            
            PdfPTable relatorio = new PdfPTable(7);
            relatorio.addCell(new PdfPCell(new Paragraph("Registro"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Patrimomio"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Equipamento"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Custo"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Solicitado"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Autorizado"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            relatorio.addCell(new PdfPCell(new Paragraph("Data de Saída"
                    ,new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 12, 0, BaseColor.WHITE)))).setBackgroundColor(BaseColor.DARK_GRAY);
            
            documento.add(relatorio);
            
            documento.close();
            Desktop.getDesktop().open(new File("relatoriosaida.pdf"));
            
        } catch (DocumentException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerandoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
