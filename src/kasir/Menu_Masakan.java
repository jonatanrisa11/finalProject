package kasir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Menu_Masakan extends javax.swing.JFrame {
    private DefaultTableModel model=null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
   
    public Menu_Masakan() {
        initComponents();
        k.connect();
        refreshTable();
    }
    
    class masakan extends Menu_Masakan {
        int id_masakan, harga;
        String nama_masakan, status;
        
        public masakan(){
            this.nama_masakan=Text_nama_masakan.getText();
            this.harga=Integer.parseInt(Text_harga_masakan.getText());
            this.status=Combo_status_masakan.getSelectedItem().toString();
        }
    }
    public void refreshTable(){
        model= new DefaultTableModel();
        model.addColumn("ID Masakan");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Status Makanan");
        Table_masakan.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("Select * from masakan");
            this.rs= this.stat.executeQuery();
            while (rs.next()) {
                Object [] data = {
                rs.getInt("id_masakan"),
                rs.getString("nama_masakan"),
                rs.getInt("harga"),
                rs.getString("status"),
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Text_harga_masakan.setText("");
        Text_id_masakan.setText("");
        Text_nama_masakan.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Text_id_masakan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Text_nama_masakan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Text_harga_masakan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Combo_status_masakan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_masakan = new javax.swing.JTable();
        Btn_logout = new javax.swing.JButton();
        Btn_transaksi = new javax.swing.JButton();
        Btn_input = new javax.swing.JButton();
        Btn_delete = new javax.swing.JButton();
        Btn_update = new javax.swing.JButton();
        Btn_registrasi = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENU MASAKAN");

        jLabel3.setFont(new java.awt.Font("Asap", 1, 24)); // NOI18N
        jLabel3.setText("ID Masakan");

        Text_id_masakan.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_id_masakan.setEnabled(false);
        Text_id_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_id_masakanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Asap", 1, 24)); // NOI18N
        jLabel4.setText("Nama Masakan");

        Text_nama_masakan.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_nama_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_nama_masakanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Asap", 1, 24)); // NOI18N
        jLabel5.setText("Harga");

        Text_harga_masakan.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_harga_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_harga_masakanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Asap", 1, 24)); // NOI18N
        jLabel6.setText("Status Makanan");

        Combo_status_masakan.setBackground(new java.awt.Color(204, 255, 255));
        Combo_status_masakan.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        Combo_status_masakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERSEDIA", "HABIS", " " }));
        Combo_status_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_status_masakanActionPerformed(evt);
            }
        });

        Table_masakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Masakan", "Nama Masakan", "Harga", "Status Masakan"
            }
        ));
        Table_masakan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_masakanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_masakan);

        Btn_logout.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        Btn_logout.setText("LOG OUT");
        Btn_logout.setEnabled(false);
        Btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_logoutActionPerformed(evt);
            }
        });

        Btn_transaksi.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        Btn_transaksi.setText("MENU TRANSAKSI");
        Btn_transaksi.setEnabled(false);
        Btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_transaksiActionPerformed(evt);
            }
        });

        Btn_input.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_input.setText("INPUT");
        Btn_input.setEnabled(false);
        Btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_inputActionPerformed(evt);
            }
        });

        Btn_delete.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_delete.setText("DELETE");
        Btn_delete.setEnabled(false);
        Btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_deleteActionPerformed(evt);
            }
        });

        Btn_update.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_update.setText("UPDATE");
        Btn_update.setEnabled(false);
        Btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_updateActionPerformed(evt);
            }
        });

        Btn_registrasi.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_registrasi.setText("MENU REGISTRASI");
        Btn_registrasi.setEnabled(false);
        Btn_registrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btn_transaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(Text_harga_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Combo_status_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Text_nama_masakan))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(Text_id_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(Btn_registrasi, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_logout)
                    .addComponent(Btn_transaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Text_id_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Text_nama_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Text_harga_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(Combo_status_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_input)
                    .addComponent(Btn_delete)
                    .addComponent(Btn_update)
                    .addComponent(Btn_registrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Text_id_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_id_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_id_masakanActionPerformed

    private void Text_nama_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_nama_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_nama_masakanActionPerformed

    private void Text_harga_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_harga_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_harga_masakanActionPerformed

    private void Combo_status_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_status_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_status_masakanActionPerformed

    private void Btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            masakan m =new masakan();
            this.stat=k.getCon().prepareStatement("insert into masakan values(?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2, m.nama_masakan);
            stat.setInt(3, m.harga);
            stat.setString(4, m.status);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_inputActionPerformed

    private void Btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_updateActionPerformed
        // TODO add your handling code here:
        try {
           masakan m=new masakan();
            this.stat=k.getCon().prepareStatement("update masakan set nama_masakan=?,"
                    + "harga=?,status=? where id_masakan=?");
            stat.setString(1, m.nama_masakan);
            stat.setInt(2, m.harga);
            stat.setString(3, m.status);
            stat.setInt(4,Integer.parseInt(Text_id_masakan.getText()));
            stat.executeUpdate();
            refreshTable(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_updateActionPerformed

    private void Btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            this.stat=k.getCon().prepareStatement("delete from masakan where id_masakan=?");
            stat.setInt(1,Integer.parseInt(Text_id_masakan.getText()));
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }//GEN-LAST:event_Btn_deleteActionPerformed

    private void Btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_transaksiActionPerformed
        // TODO add your handling code here:
        Menu_Transaksi tran=new Menu_Transaksi();
        tran.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Btn_transaksiActionPerformed

    private void Btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_logoutActionPerformed
        // TODO add your handling code here:
        Login l =new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Btn_logoutActionPerformed

    private void Table_masakanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_masakanMouseClicked
        // TODO add your handling code here:
        Text_id_masakan.setText(model.getValueAt(Table_masakan.getSelectedRow(), 0).toString());
        Text_nama_masakan.setText(model.getValueAt(Table_masakan.getSelectedRow(), 1).toString());
        Text_harga_masakan.setText(model.getValueAt(Table_masakan.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_Table_masakanMouseClicked

    private void Btn_registrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrasiActionPerformed
        // TODO add your handling code here:
        Menu_Registrasi reg=new Menu_Registrasi();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Btn_registrasiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Masakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Masakan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_delete;
    public javax.swing.JButton Btn_input;
    public javax.swing.JButton Btn_logout;
    public javax.swing.JButton Btn_registrasi;
    public javax.swing.JButton Btn_transaksi;
    public javax.swing.JButton Btn_update;
    private javax.swing.JComboBox<String> Combo_status_masakan;
    private javax.swing.JTable Table_masakan;
    private javax.swing.JTextField Text_harga_masakan;
    private javax.swing.JTextField Text_id_masakan;
    private javax.swing.JTextField Text_nama_masakan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
