/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.model;

import com.atacadao.almoxarifado.entidade.Saida;
import com.sun.xml.internal.bind.CycleRecoverable;
import com.sun.xml.internal.ws.util.Pool;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author lucas
 */
public class XMLsaidas {
    JAXBContext jaxb;

    public XMLsaidas(Saida saidas) {
        try {
            this.jaxb = JAXBContext.newInstance(Saida.class);
            Marshaller marshal = this.jaxb.createMarshaller();
            
            marshal.marshal(saidas, System.out);
            
        } catch (JAXBException ex) {
            Logger.getLogger(XMLsaidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
