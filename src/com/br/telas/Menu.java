package com.br.telas;

import com.br.main.Tenis;
import com.formdev.flatlaf.intellijthemes.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.TenisObserver;
import utils.globalMethods;

public class Menu extends javax.swing.JFrame implements TenisObserver {
    ArrayList<Tenis> tenisList = new ArrayList<>();
    
    Connection conn = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    Relatorio telaRelatorio;
    AdicionarTenis telaAdicionarTenis;
    ExcluirTenis telaExcluirTenis;
    EditarTenis telaEditarTenis;
    DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
    
    public Menu() {       
        initComponents();        
        setLocationRelativeTo(null);     
        fillTable();
        initializeScreens(); 
    }
    
    private void initializeScreens(){
        telaRelatorio = new Relatorio(this);
        telaAdicionarTenis = new AdicionarTenis(tenisList, this);
        telaAdicionarTenis.addObserver(this);
        telaExcluirTenis = new ExcluirTenis(tenisList, this);
        telaExcluirTenis.addObserver(this);
        telaEditarTenis = new EditarTenis(tenisList, this);
        telaEditarTenis.addObserver(this);        
    } 
    
    private void fillTable(){
        DefaultTableModel tblModel = (DefaultTableModel) tblEstoque.getModel();
        tblModel.setRowCount(0);
        tenisList.clear();
        
        conn = globalMethods.conectDatabase(conn);
        String query = "SELECT * FROM tenis";
    
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String tamanho = String.valueOf(rs.getInt("tamanho"));
                String cor = rs.getString("cor");
                String preco = String.valueOf(rs.getDouble("preco"));

                Tenis tenis = new Tenis(id, marca, modelo, tamanho, cor, preco);
                tenisList.add(tenis);
            }
            
            for (Tenis tenis : tenisList) {
                String[] tbData = {
                    tenis.getId(),
                    tenis.getMarca(),
                    tenis.getModelo(),
                    tenis.getCor(),                    
                    tenis.getTamanho(),
                    tenis.getPreco()
                };
                tblModel.addRow(tbData);                
                alignTableColumns();
            }
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        tblEstoque.setModel(tblModel);
        tblEstoque.setDefaultEditor(Object.class, null);     
    }
    
    public void alignTableColumns(){
        for(int x = 0; x < tblEstoque.getColumnCount(); x++){
            renderRight.setHorizontalAlignment(SwingConstants.RIGHT);
            tblEstoque.getColumnModel().getColumn(x).setCellRenderer(renderRight);
        }
    }
    
    private void filter(String query, String selectedItem) {          
        DefaultTableModel tblModel = (DefaultTableModel) tblEstoque.getModel();
        tblModel.setRowCount(0);               
        tenisList.clear();
        
        conn = globalMethods.conectDatabase(conn);
        String command = "SELECT * FROM tenis WHERE "+selectedItem+" LIKE ?";
        
        try {
            pst = conn.prepareStatement(command);
            pst.setString(1, query+"%");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String tamanho = String.valueOf(rs.getInt("tamanho"));
                String cor = rs.getString("cor");
                String preco = String.valueOf(rs.getDouble("preco"));

                Tenis tenis = new Tenis(id, marca, modelo, tamanho, cor, preco);
                tenisList.add(tenis);
            }
            
            for (Tenis tenis : tenisList) {
                String[] tbData = {
                    tenis.getId(),
                    tenis.getMarca(),
                    tenis.getModelo(),
                    tenis.getCor(),                    
                    tenis.getTamanho(),
                    tenis.getPreco()
                };
                tblModel.addRow(tbData);                
                alignTableColumns();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        tblEstoque.setModel(tblModel);
        tblEstoque.setDefaultEditor(Object.class, null);    
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlControles = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        cbCategoriaPesquisa = new javax.swing.JComboBox<>();
        lblCategoriaCB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema controle de estoque");
        setResizable(false);

        pnlControles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Controles"));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-plus-16.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-trash-24.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-edit-24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paper_icon.png"))); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlesLayout = new javax.swing.GroupLayout(pnlControles);
        pnlControles.setLayout(pnlControlesLayout);
        pnlControlesLayout.setHorizontalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlControlesLayout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlControlesLayout.setVerticalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        tblEstoque = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblEstoque.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18));
        tblEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Marca", "Modelo", "Cor", "Tamanho", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEstoque.setCellSelectionEnabled(false);
        tblEstoque.setRowHeight(32);
        tblEstoque.setShowGrid(false);
        tblEstoque.getTableHeader().setResizingAllowed(false);
        tblEstoque.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEstoque);

        lblPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPesquisa.setText("Pesquisar");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        cbCategoriaPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cbCategoriaPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "marca", "modelo", "cor", "tamanho", "preco" }));

        lblCategoriaCB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCategoriaCB.setText("Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCategoriaCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        telaAdicionarTenis.show();       
        this.setEnabled(false);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        String query = txtPesquisa.getText();
        String selectedItem = (String) cbCategoriaPesquisa.getSelectedItem();
        filter(query, selectedItem);
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        telaExcluirTenis.show();        // TODO add your handling code here:
        this.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        telaEditarTenis.show();        // TODO add your handling code here:
        this.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        telaRelatorio = new Relatorio(this);
        telaRelatorio.show();        // TODO add your handling code here:
        this.setEnabled(false);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public static void main(String args[]) {
        try{
            FlatCarbonIJTheme.setup();
        }catch(Exception e){
            System.out.println("Failed to load Look and feel");
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbCategoriaPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoriaCB;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JTable tblEstoque;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        SwingUtilities.invokeLater(this::fillTable);
    }

}
