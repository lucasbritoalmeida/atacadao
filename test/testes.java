
import com.atacadao.almoxarifado.model.GerandoPDF;
import com.atacadao.almoxarifado.persistencia.saidaConexao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerandoPDF gpdf = new GerandoPDF();
        gpdf.pdfRelatorio(saidaConexao.buscarTodos());
    }
    
}
