/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.controleestoque.view;

import br.com.sudosu.controleestoque.domain.Bkup;
import br.com.sudosu.controleestoque.servicos.BancoServicos;
import br.com.sudosu.controleestoque.servicos.ServicosFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius.Vianna
 * @version 1.0.1
 */
public class TelaListaBkup extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListaBkup
     */
    public TelaListaBkup() throws SQLException {
        initComponents();
        preencherTabela();
    }

    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"CÓDIGO", "MIDIA", "CONTEUDO", "LOCAL", "OBSERVAÇÕES"});

    public void preencherTabela() {
        try {

            BancoServicos bs = ServicosFactory.getBancoServicos();
            ArrayList<Bkup> bkup = new ArrayList<>();

            bkup = bs.buscarBkup();

            for (int i = 0; i < bkup.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(bkup.get(i).getIdBkup()),
                    String.valueOf(bkup.get(i).getMidia()),
                    String.valueOf(bkup.get(i).getConteudo()),
                    String.valueOf(bkup.get(i).getLocal()),
                    String.valueOf(bkup.get(i).getObservacoes())
                });
            }//fecha for
            tblBkup.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro! " + e.getMessage());
        }//fecha catch
    }//fecha metodo

    public void limparTabela() {
        dtm.setNumRows(0);
    }//fecha metodo

    public void filtrarTabela() {
        try {
            if (tfPesquisa.getText().isEmpty()) {
                preencherTabela();
            } else {
                BancoServicos bs = ServicosFactory.getBancoServicos();

                String query;
                query = "where id_bkup like '%" + tfPesquisa.getText() + "%'";

                ArrayList<Bkup> bkup = new ArrayList<>();
                bkup = bs.filtrarBkup(query);

                for (int i = 0; i < bkup.size(); i++) {
                    dtm.addRow(new String[]{
                        String.valueOf(bkup.get(i).getIdBkup()),
                        String.valueOf(bkup.get(i).getMidia()),
                        String.valueOf(bkup.get(i).getConteudo()),
                        String.valueOf(bkup.get(i).getLocal()),
                        String.valueOf(bkup.get(i).getObservacoes())
                    });
                }//fecha for     
                tblBkup.setModel(dtm);
            }//fecha else
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao Filtrar! " + e.getMessage());
        }//fecha catch
    }//fecha metodo

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBkup = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle(" Lista de Bkups");
        setFrameIcon(null);

        tblBkup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBkup);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sudosu/controleestoque/imagens/icon_refresh.png"))); // NOI18N
        btnRefresh.setPreferredSize(new java.awt.Dimension(64, 64));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel1.setText("CÓDIGO");

        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        limparTabela();
        preencherTabela();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        limparTabela();
        filtrarTabela();
    }//GEN-LAST:event_tfPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBkup;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
