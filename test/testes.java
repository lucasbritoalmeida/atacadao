
import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.Saida;
import com.atacadao.almoxarifado.model.Codigos;
import com.atacadao.almoxarifado.model.GerandoPDF;
import com.atacadao.almoxarifado.model.XMLsaidas;
import com.atacadao.almoxarifado.persistencia.equipamentoConexao;
import com.atacadao.almoxarifado.persistencia.saidaConexao;
import java.util.ArrayList;

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
       ArrayList<Saida> saidas = saidaConexao.buscarTodos();
        GerandoPDF gpdf = new GerandoPDF();
        gpdf.pdfDeSaida(saidas);
    }
    
}
