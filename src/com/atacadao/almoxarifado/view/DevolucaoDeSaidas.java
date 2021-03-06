/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atacadao.almoxarifado.view;

import com.atacadao.almoxarifado.entidade.Equipamento;
import com.atacadao.almoxarifado.entidade.Saida;
import com.atacadao.almoxarifado.model.FormatandoDouble;
import com.atacadao.almoxarifado.model.FormatosDeData;
import com.atacadao.almoxarifado.persistencia.equipamentoConexao;
import com.atacadao.almoxarifado.persistencia.saidaConexao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class DevolucaoDeSaidas extends javax.swing.JInternalFrame {

    /**
     * Creates new form DevolucaoDeSaidas
     */
    public DevolucaoDeSaidas() {
        initComponents();
        carregarSaidas(saidaConexao.buscarTodos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFrtValidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPatrimonio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtFrtValor = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Devolução de Saidas");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipamento"));

        jLabel1.setText("Nome");

        txtNome.setEditable(false);

        jLabel2.setText("Validade");

        txtFrtValidade.setEditable(false);
        txtFrtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel3.setText("Código");

        txtCodigo.setEditable(false);

        jLabel4.setText("Tipo");

        txtTipo.setEditable(false);

        jLabel5.setText("Patrimonio");

        txtPatrimonio.setEditable(false);

        jLabel6.setText("Situação");

        jLabel7.setText("Valor");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Excelente", "Boa", "Regular", "Ruim", "Em Manutenção" }));

        txtFrtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPatrimonio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(txtFrtValidade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, 0, 113, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(txtTipo)
                            .addComponent(txtFrtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFrtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFrtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButton1.setForeground(new java.awt.Color(0, 153, 204));
        jButton1.setText("Devolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Devolução das Saídas", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registro", "Solicitante", "Autorizado", "Patrimonio", "Nome", "Validade", "Situação", "Codigo", "Tipo", "Valor", "Data de Saida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta de Saídas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        equipamentoConexao.CadastrarComPatrimonio(new Equipamento(txtPatrimonio.getText(), txtNome.getText()
                , FormatosDeData.formatarDatasParaLong(txtFrtValidade.getText()), String.valueOf(jComboBox1.getSelectedItem())
                ,txtCodigo.getText(), txtTipo.getText(), FormatandoDouble.FormatandoValores(txtFrtValor.getText())));
        limparTela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
       txtNome.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 4));
       txtFrtValidade.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 5));
       txtCodigo.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 7));
       txtTipo.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 8));
       txtPatrimonio.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 3));
       txtFrtValor.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 9));
       
    }//GEN-LAST:event_jTable3MouseClicked
private void carregarSaidas(ArrayList<Saida> saidas){
        
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        
        while (dtm.getRowCount() > 0) {            
            dtm.removeRow(0);
        }
        
        if(saidas.isEmpty()){
            dtm.addRow(new String[] {"","","","","","","","",""});
        }else{
            for (Saida saida : saidas) {
                dtm.addRow(new String[] {
                    saida.getRegistro(),saida.getSolicitador(),saida.getAutorizador(),saida.getPatrimonio(),
                    saida.getNome(),FormatosDeData.formatarLongParaDatas(saida.getValidade().getTime()),saida.getSituacao(),saida.getCodigo(),
                    saida.getTipo(),String.valueOf(saida.getValor()),FormatosDeData.formatarLongParaDatas(saida.getDatasaida().getTime())
                });
            }
        }
        
    }
private void limparTela(){
    txtNome.setText("");txtPatrimonio.setText("");txtCodigo.setText("");
    txtPatrimonio.setText("");txtFrtValor.setText("");txtFrtValidade.setText("");
    jComboBox1.setSelectedIndex(0);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtFrtValidade;
    private javax.swing.JFormattedTextField txtFrtValor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPatrimonio;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
