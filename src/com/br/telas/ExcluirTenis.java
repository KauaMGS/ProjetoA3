package com.br.telas;

import com.br.main.Tenis;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.TenisObserver;
import utils.globalMethods;

public class ExcluirTenis extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    private ArrayList<Tenis> tenisList;
    private final ArrayList<TenisObserver> observers = new ArrayList<>();
    
    private ExcluirTenis() {
        
    }
    
    public ExcluirTenis(ArrayList<Tenis> listaDeTenis, Menu menu) {
        this.tenisList = listaDeTenis;        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                menu.setEnabled(true); 
                menu.telaEditarTenis.fillTenisList();
            }
        });
        
        initComponents();
        setLocationRelativeTo(this);  
        showInfoSelectedTenis();
        fillTenisList();
    }
    
    private void showInfoSelectedTenis(){
        cbListaDeTenis.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                showInfoSelectedTenis();
            }
        });               
        
        for(Tenis tn : tenisList){
            if((tn.getMarca() + " " + tn.getModelo() + " | " + " Tam: " + tn.getTamanho()).equals(cbListaDeTenis.getSelectedItem())){
                txtId.setText(tn.getId());
                txtMarca.setText(tn.getMarca());
                txtModelo.setText(tn.getModelo());
                txtTamanho.setText(tn.getTamanho());     
                txtCor.setText(tn.getCor());
                txtPreco.setText(tn.getPreco());
                
            }
        }
    }
    
    public final void fillTenisList(){  
        cbListaDeTenis.removeAllItems();
        cbListaDeTenis.addItem("---- Selecione um tênis ----");
        for(Tenis tenis : tenisList){
            String tenisSelecionado = tenis.getMarca() + " " + tenis.getModelo() + " | " + " Tam: " + tenis.getTamanho();
            cbListaDeTenis.addItem(tenisSelecionado);
        }    
    }
    
    public void addObserver(TenisObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TenisObserver observer) {
        observers.remove(observer);
    }    
    
    private void notifyObservers() {
        for (TenisObserver observer : observers) {
            observer.update();
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSelecionarTenis = new javax.swing.JPanel();
        lblSelecionar = new javax.swing.JLabel();
        cbListaDeTenis = new javax.swing.JComboBox<>();
        pnlControles = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        pnlInformacoesTenis = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblTamanho = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        lblMarca1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir ");
        setResizable(false);

        pnlSelecionarTenis.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblSelecionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSelecionar.setText("Selecionar");

        javax.swing.GroupLayout pnlSelecionarTenisLayout = new javax.swing.GroupLayout(pnlSelecionarTenis);
        pnlSelecionarTenis.setLayout(pnlSelecionarTenisLayout);
        pnlSelecionarTenisLayout.setHorizontalGroup(
            pnlSelecionarTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecionarTenisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelecionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbListaDeTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSelecionarTenisLayout.setVerticalGroup(
            pnlSelecionarTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecionarTenisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSelecionarTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelecionar)
                    .addComponent(cbListaDeTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(246, 246, 246))
        );

        pnlControles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Controles"));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-check-mark-48.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-30.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlesLayout = new javax.swing.GroupLayout(pnlControles);
        pnlControles.setLayout(pnlControlesLayout);
        pnlControlesLayout.setHorizontalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlControlesLayout.setVerticalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlInformacoesTenis.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarca.setText("Marca");

        lblModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblModelo.setText("Modelo");

        lblTamanho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTamanho.setText("Tamanho");

        lblCor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCor.setText("Cor");

        lblPreco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPreco.setText("Preço");

        txtModelo.setEditable(false);

        txtMarca.setEditable(false);

        txtTamanho.setEditable(false);

        txtPreco.setEditable(false);

        txtCor.setEditable(false);

        lblMarca1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarca1.setText("Id");

        txtId.setEditable(false);

        javax.swing.GroupLayout pnlInformacoesTenisLayout = new javax.swing.GroupLayout(pnlInformacoesTenis);
        pnlInformacoesTenis.setLayout(pnlInformacoesTenisLayout);
        pnlInformacoesTenisLayout.setHorizontalGroup(
            pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacoesTenisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCor)
                    .addComponent(lblMarca)
                    .addComponent(lblModelo)
                    .addComponent(lblTamanho)
                    .addComponent(lblMarca1)
                    .addComponent(lblPreco))
                .addGap(30, 30, 30)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacoesTenisLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInformacoesTenisLayout.createSequentialGroup()
                        .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlInformacoesTenisLayout.setVerticalGroup(
            pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacoesTenisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca1))
                .addGap(9, 9, 9)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamanho)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlSelecionarTenis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlInformacoesTenis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelecionarTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInformacoesTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtId.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtTamanho.setText("");  
        txtCor.setText("");
        txtPreco.setText(""); 
        cbListaDeTenis.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esse item?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        switch(input){
            case 0 -> {
                try {
                    conn = globalMethods.conectDatabase(conn);
                    String command = "DELETE FROM tenis WHERE id = ?";
                    int id = Integer.parseInt(txtId.getText());
                    
                    try (PreparedStatement pst = conn.prepareStatement(command)) {
                        pst.setInt(1, id);
                        pst.executeUpdate();
                    }                    
                    
                    JOptionPane.showMessageDialog(null, "Item deletado com sucesso!", "Excluir", HEIGHT);           
                                                  
                    String operacao = "exclusao";
                    String commandOperation = "INSERT INTO registros (operacao) VALUES (?)";
                    try (PreparedStatement pst = conn.prepareStatement(commandOperation)) {
                        pst.setString(1, operacao);
                        pst.executeUpdate();
                    }
                    
                    btnLimparActionPerformed(evt);   
                    globalMethods.fillMyArray(tenisList, rs);
                    fillTenisList();
                    notifyObservers();
                    
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ExcluirTenis().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbListaDeTenis;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarca1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblSelecionar;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JPanel pnlInformacoesTenis;
    private javax.swing.JPanel pnlSelecionarTenis;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
