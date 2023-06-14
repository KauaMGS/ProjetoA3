package com.br.telas;

import com.br.main.Tenis;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.TenisObserver;
import utils.globalMethods;

public class EditarTenis extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    private final ArrayList<TenisObserver> observers = new ArrayList<>();
    private ArrayList<Tenis> tenisList;   
    
    private EditarTenis(){
        
    }
    
    public EditarTenis(ArrayList<Tenis> listaDeTenis, Menu menu) {
        this.tenisList = listaDeTenis;        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                menu.setEnabled(true); 
                menu.telaExcluirTenis.fillTenisList();
            }
        });               
        
        initComponents();
        setLocationRelativeTo(this);        
        showInfoSelectedTenis();
        fillTenisList();
    }
    
    public final void fillTenisList(){      
        cbListaDeTenis.removeAllItems();
        cbListaDeTenis.addItem("---- Selecione um tênis ----");
        for(Tenis tenis : tenisList){
            String tenisSelecionado = tenis.getMarca() + " " + tenis.getModelo() + " | " + " Tam: " + tenis.getTamanho();
            cbListaDeTenis.addItem(tenisSelecionado);
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
                for(int x = 0; x < cbTamanhoTenis.getItemCount(); x++){
                    if(cbTamanhoTenis.getItemAt(x).equals(tn.getTamanho())){
                        cbTamanhoTenis.setSelectedIndex(x);
                    }
                } 
                txtCor.setText(tn.getCor());
                ftxtPreco.setText(tn.getPreco());              
            }
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
        pnlInformacoesTenis = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblTamanho = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        lblMarca1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cbTamanhoTenis = new javax.swing.JComboBox<>();
        ftxtPreco = new javax.swing.JFormattedTextField();
        pnlControles = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");

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
                .addGap(18, 18, 18)
                .addGroup(pnlSelecionarTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelecionar)
                    .addComponent(cbListaDeTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        lblMarca1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMarca1.setText("Id");

        txtId.setEditable(false);

        cbTamanhoTenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48" }));
        cbTamanhoTenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTamanhoTenisActionPerformed(evt);
            }
        });

        ftxtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftxtPreco.setText("0,00");

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
                            .addGroup(pnlInformacoesTenisLayout.createSequentialGroup()
                                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTamanhoTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ftxtPreco))
                        .addContainerGap())))
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
                    .addComponent(cbTamanhoTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacoesTenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(ftxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pnlControles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Controles"));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-edit-32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-restore-30.png"))); // NOI18N
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlesLayout = new javax.swing.GroupLayout(pnlControles);
        pnlControles.setLayout(pnlControlesLayout);
        pnlControlesLayout.setHorizontalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlControlesLayout.setVerticalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelecionarTenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInformacoesTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelecionarTenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInformacoesTenis, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja editar esse item?", "Confirmar edição", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(input == 0){
            try {
                conn = globalMethods.conectDatabase(conn);
                String command = "UPDATE tenis SET marca = ?, modelo = ?, cor = ?, tamanho = ?, preco = ? WHERE id = ?";
                
                int id = Integer.parseInt(txtId.getText());
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                int tamanho = Integer.parseInt((String) cbTamanhoTenis.getSelectedItem());
                String cor = txtCor.getText();
                double preco = extractValueOfPrice(ftxtPreco);                
                
                try (PreparedStatement pst = conn.prepareStatement(command)) {                   
                    pst.setString(1, marca);
                    pst.setString(2, modelo);
                    pst.setString(3, cor);
                    pst.setInt(4, tamanho);                   
                    pst.setDouble(5, preco);
                    pst.setInt(6, id);
                    pst.executeUpdate();
                }
                conn.close();
                
                JOptionPane.showMessageDialog(this, "Item modificado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);           
                btnRestaurarActionPerformed(evt);
                notifyObservers();   
                globalMethods.fillMyArray(tenisList, rs);
                fillTenisList();
            } catch (SQLException ex) {
                Logger.getLogger(EditarTenis.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao modificar os dados no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        txtId.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        cbTamanhoTenis.setSelectedIndex(0);
        txtCor.setText("");
        ftxtPreco.setText("0,00");
        cbListaDeTenis.setSelectedIndex(0);
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void cbTamanhoTenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTamanhoTenisActionPerformed

    }//GEN-LAST:event_cbTamanhoTenisActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EditarTenis().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox<String> cbListaDeTenis;
    private javax.swing.JComboBox<String> cbTamanhoTenis;
    private javax.swing.JFormattedTextField ftxtPreco;
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
    // End of variables declaration//GEN-END:variables
}
