package com.br.telas;

import com.br.main.Tenis;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.TenisObserver;
import utils.globalMethods;

public class AdicionarTenis extends javax.swing.JFrame {
    Connection conn = null;
    private final ArrayList<TenisObserver> observers = new ArrayList<>();  
    
    private AdicionarTenis(){
        
    }
    
    public AdicionarTenis(ArrayList<Tenis> listaDeTenis, Menu menu) {       
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                menu.setEnabled(true); 
                menu.telaExcluirTenis.fillTenisList();
                menu.telaEditarTenis.fillTenisList();
            }
        });       
    
        initComponents();       
        setLocationRelativeTo(this);
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
    
    private double extractValueOfPrice(JTextField textField) {
        String texto = textField.getText();
        texto = texto.replaceAll("[^\\d.,]", "");
        texto = texto.replace(',', '.'); 

        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }    
    
    public boolean isEmpty(){
        boolean est = false;
        
        if(txtMarca.getText().equals("")){
            txtMarca.requestFocus();
        }else if(txtModelo.getText().equals("")){
            txtModelo.requestFocus();            
        }else if(txtCor.getText().equals("")){
            txtCor.requestFocus();            
        }else if(ftxtPreco.getText().equals("")){
            ftxtPreco.requestFocus();            
        }else{
            est = true;
        }                
        
        return est;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlControles = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblTamanho = new javax.swing.JLabel();
        cbTamanhoTenis = new javax.swing.JComboBox<>();
        lblCor = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        ftxtPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar");
        setResizable(false);

        pnlControles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Controles"));

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-check-mark-48.png"))); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-30.png"))); // NOI18N
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlesLayout = new javax.swing.GroupLayout(pnlControles);
        pnlControles.setLayout(pnlControlesLayout);
        pnlControlesLayout.setHorizontalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        pnlControlesLayout.setVerticalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarca.setText("Marca : ");

        lblModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblModelo.setText("Modelo : ");

        lblTamanho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTamanho.setText("Tamanho : ");

        cbTamanhoTenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48" }));

        lblCor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCor.setText("Cor : ");

        lblPreco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPreco.setText("Preço : ");

        ftxtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftxtPreco.setText("0,00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca)
                    .addComponent(lblModelo)
                    .addComponent(lblTamanho)
                    .addComponent(lblCor)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMarca)
                    .addComponent(txtModelo)
                    .addComponent(txtCor)
                    .addComponent(ftxtPreco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbTamanhoTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 279, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTamanhoTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (!(isEmpty())) {
            JOptionPane.showMessageDialog(this, "Preencha os campos vazios", "Faltam dados", HEIGHT);
        } else {
            conn = globalMethods.conectDatabase(conn);
          
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int tamanho = Integer.parseInt((String) cbTamanhoTenis.getSelectedItem());
            String cor = txtCor.getText();
            double preco = extractValueOfPrice(ftxtPreco);

            try {            
                String command = "INSERT INTO tenis (marca, modelo, tamanho, cor, preco) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pst = conn.prepareStatement(command)) {
                    pst.setString(1, marca);
                    pst.setString(2, modelo);
                    pst.setInt(3, tamanho);
                    pst.setString(4, cor);
                    pst.setDouble(5, preco);
                    pst.executeUpdate();
                }               

                JOptionPane.showMessageDialog(this, "Item adicionados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
              
                String operacao = "adicao";
                String commandOperation = "INSERT INTO registros (operacao) VALUES (?)";
                try (PreparedStatement pst = conn.prepareStatement(commandOperation)) {
                    pst.setString(1, operacao);
                    pst.executeUpdate();
                }
                
                btnApagarActionPerformed(evt);           
                notifyObservers(); 
                
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdicionarTenis.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao adicionar os dados no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        txtMarca.setText("");
        txtModelo.setText("");
        cbTamanhoTenis.setSelectedItem(0);
        txtCor.setText("");
        ftxtPreco.setText("0,00");
    }//GEN-LAST:event_btnApagarActionPerformed
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AdicionarTenis().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbTamanhoTenis;
    private javax.swing.JFormattedTextField ftxtPreco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
