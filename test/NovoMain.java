
import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.Saida;
import com.atacadao.almoxarifado.model.GerandoPDF;
import com.atacadao.almoxarifado.persistencia.saidaConexao;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.html.HTML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class NovoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GerandoPDF pdf = new GerandoPDF();
//        ArrayList<Equipamento> equips = new ArrayList<>();
//       equips.add(new Equipamento("patrimonio", "nome", Long.valueOf("1213545"), "situacao", "codigo", "tipo"));
//        pdf.pdfDeSaida(equips, "solicitante", "autorizante", "responsavel", "numeroSaida");

//    pdf.pdfImpressaoBarraDeCodigo("123456789");

        ArrayList<Saida> saidas = saidaConexao.buscarRelatorio("", "", "", "3239185099", "", "", "", null, null);
        System.out.println(saidas);
        pdf.pdfRelatorioSaida(saidas);
    }
    
}
