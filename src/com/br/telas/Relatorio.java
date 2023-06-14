package com.br.telas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.globalMethods;

public class Relatorio extends javax.swing.JFrame {
    Connection conn = null;
    Statement st = null;
    
    public Relatorio(){
        
    }
    
    public Relatorio(Menu menu) {        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                menu.setEnabled(true); 
            }
        });         
        
        initComponents();
        setLocationRelativeTo(null);
        atualizarRegistros();
    }

    private void atualizarRegistros() {
        try {
            conn = globalMethods.conectDatabase(conn);
            st = conn.createStatement();

            if (rbSemanal.isSelected()) {
                String queryByWeekAdd = "SELECT WEEK(data_registro) AS semana, COUNT(*) AS total FROM registros WHERE operacao = 'adicao' GROUP BY semana";
                ResultSet resultSetByWeekAdd = st.executeQuery(queryByWeekAdd);

                if (resultSetByWeekAdd.next()) {
                    int totalAdd = resultSetByWeekAdd.getInt("total");
                    qtdeAdicionados.setText(String.valueOf(totalAdd));
                }

                String queryByWeekRemoved = "SELECT WEEK(data_registro) AS semana, COUNT(*) AS total FROM registros WHERE operacao = 'exclusao' GROUP BY semana";
                ResultSet resultSetByWeekRemoved = st.executeQuery(queryByWeekRemoved);

                if (resultSetByWeekRemoved.next()) {
                    int totalRemoved = resultSetByWeekRemoved.getInt("total");
                    qtdeRemovidos.setText(String.valueOf(totalRemoved));
                }
            } else if (rbMensal.isSelected()) {
                String queryByMonthAdd = "SELECT MONTH(data_registro) AS mes, COUNT(*) AS total FROM registros WHERE operacao = 'adicao' GROUP BY mes";
                ResultSet resultSetByMonthAdd = st.executeQuery(queryByMonthAdd);

                if (resultSetByMonthAdd.next()) {
                    int totalAdd = resultSetByMonthAdd.getInt("total");
                    qtdeAdicionados.setText(String.valueOf(totalAdd));
                }

                String queryByMonthRemoved = "SELECT MONTH(data_registro) AS mes, COUNT(*) AS total FROM registros WHERE operacao = 'exclusao' GROUP BY mes";
                ResultSet resultSetByMonthRemoved = st.executeQuery(queryByMonthRemoved);

                if (resultSetByMonthRemoved.next()) {
                    int totalRemoved = resultSetByMonthRemoved.getInt("total");
                    qtdeRemovidos.setText(String.valueOf(totalRemoved));
                }
            } else if (rbAnual.isSelected()) {
                String queryByYearAdd = "SELECT YEAR(data_registro) AS ano, COUNT(*) AS total FROM registros WHERE operacao = 'adicao' GROUP BY ano";
                ResultSet resultSetByYearAdd = st.executeQuery(queryByYearAdd);

                if (resultSetByYearAdd.next()) {
                    int totalAdd = resultSetByYearAdd.getInt("total");
                    qtdeAdicionados.setText(String.valueOf(totalAdd));
                }

                String queryByYearRemoved = "SELECT YEAR(data_registro) AS ano, COUNT(*) AS total FROM registros WHERE operacao = 'exclusao' GROUP BY ano";
                ResultSet resultSetByYearRemoved = st.executeQuery(queryByYearRemoved);

                if (resultSetByYearRemoved.next()) {
                    int totalRemoved = resultSetByYearRemoved.getInt("total");
                    qtdeRemovidos.setText(String.valueOf(totalRemoved));
                }
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupOpcao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        qtdeRemovidos = new javax.swing.JLabel();
        lblRemovidos = new javax.swing.JLabel();
        qtdeAdicionados = new javax.swing.JLabel();
        lblAdicionados = new javax.swing.JLabel();
        rbSemanal = new javax.swing.JRadioButton();
        rbMensal = new javax.swing.JRadioButton();
        rbAnual = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        qtdeRemovidos.setFont(new java.awt.Font("Lucida Sans", 0, 50)); // NOI18N
        qtdeRemovidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qtdeRemovidos.setText("0");
        qtdeRemovidos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblRemovidos.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        lblRemovidos.setText("Removidos");

        qtdeAdicionados.setFont(new java.awt.Font("Lucida Sans", 0, 50)); // NOI18N
        qtdeAdicionados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qtdeAdicionados.setText("0");
        qtdeAdicionados.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblAdicionados.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        lblAdicionados.setText("Adicionados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(qtdeAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qtdeRemovidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemovidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtdeAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdeRemovidos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRemovidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdicionados, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnGroupOpcao.add(rbSemanal);
        rbSemanal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbSemanal.setSelected(true);
        rbSemanal.setText("Semanal");
        rbSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSemanalActionPerformed(evt);
            }
        });

        btnGroupOpcao.add(rbMensal);
        rbMensal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbMensal.setText("Mensal");
        rbMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMensalActionPerformed(evt);
            }
        });

        btnGroupOpcao.add(rbAnual);
        rbAnual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAnual.setText("Anual");
        rbAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAnualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(rbSemanal)
                .addGap(95, 95, 95)
                .addComponent(rbMensal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbAnual)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSemanal)
                    .addComponent(rbMensal)
                    .addComponent(rbAnual))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemanalActionPerformed
        atualizarRegistros();
    }//GEN-LAST:event_rbSemanalActionPerformed

    private void rbMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMensalActionPerformed
        atualizarRegistros();
    }//GEN-LAST:event_rbMensalActionPerformed

    private void rbAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAnualActionPerformed
        atualizarRegistros();      
    }//GEN-LAST:event_rbAnualActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Relatorio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupOpcao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdicionados;
    private javax.swing.JLabel lblRemovidos;
    private javax.swing.JLabel qtdeAdicionados;
    private javax.swing.JLabel qtdeRemovidos;
    private javax.swing.JRadioButton rbAnual;
    private javax.swing.JRadioButton rbMensal;
    private javax.swing.JRadioButton rbSemanal;
    // End of variables declaration//GEN-END:variables

}
