/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import org.jfree.util.PrintStreamLogTarget;

/**
 *
 * @author lucas
 */
public class ImpressaoDeDocumentos {

    public ImpressaoDeDocumentos(String documento) {
        PrintService[] prints = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        PrintService printDefault = PrintServiceLookup.lookupDefaultPrintService();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet();
        
        try {
            FileInputStream arquivo = new FileInputStream(documento);
            Doc doc = new SimpleDoc(arquivo, flavor, hashDocAttributeSet);
            HashPrintRequestAttributeSet printRequestAttribute = new HashPrintRequestAttributeSet();
            PrintService printServico = ServiceUI.printDialog(null, 0, 0, prints, printDefault, flavor, printRequestAttribute);
            
            if (printServico != null) {
                DocPrintJob docPrintJob = printServico.createPrintJob();
                docPrintJob.print(doc, printRequestAttribute);
            }
            
        } catch (FileNotFoundException | PrintException ex) {
            Logger.getLogger(ImpressaoDeDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}
