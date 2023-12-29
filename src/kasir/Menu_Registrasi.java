package kasir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu_Registrasi extends javax.swing.JFrame {
    private DefaultTableModel model=null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public Menu_Registrasi() {
        initComponents();
        k.connect();
        refreshTable();
    }
     class user extends Menu_Registrasi {
        int id_user, id_level;
        String username, password, nama_user;
        
        public user() {
            username = text_username.getText();
            password = Text_password.getText();
            nama_user= Text_nama_user.getText();
            id_level= Integer.parseInt(Combo_id_level.getSelectedItem().toString());
        }
    }

     
     public void refreshTable(){
         model = new DefaultTableModel();
         model.addColumn("ID User");
         model.addColumn("Username");
         model.addColumn("Password");
         model.addColumn("Nama User");
         model.addColumn("ID Level");
         table_registrasi.setModel(model);
         try {
               this.stat = k.getCon().prepareStatement("select * from user");
               this.rs=this.stat.executeQuery();
               while (rs.next()){
                   Object [] data = {
                       rs.getString("id_user"),
                       rs.getString("username"),
                       rs.getString("password"),
                       rs.getString("nama_user"),
                       rs.getString("id_level")
                   };
                   model.addRow(data);
               }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         Text_id_user.setText("");
         text_username.setText("");
         Text_password.setText("");
         Text_nama_user.setText("");
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Text_id_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Text_password = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Combo_id_level = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_registrasi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_menu_masakan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Text_nama_user = new javax.swing.JTextField();

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
        jLabel2.setText("MENU REGISTRASI");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("ID User");

        Text_id_user.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_id_user.setEnabled(false);
        Text_id_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_id_userActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Username");

        text_username.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        text_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_usernameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel5.setText("Password");

        Text_password.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_passwordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel6.setText("Id Level");

        Combo_id_level.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        Combo_id_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        Combo_id_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_id_levelActionPerformed(evt);
            }
        });

        table_registrasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID User", "Username", "Password", "Nama User", "Level"
            }
        ));
        table_registrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_registrasiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_registrasi);

        btn_input.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_menu_masakan.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        btn_menu_masakan.setText("MENU MASAKAN");
        btn_menu_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menu_masakanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_menu_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_menu_masakan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        btn_logout.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        btn_logout.setText("LOG OUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Nama User");

        Text_nama_user.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_nama_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_nama_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Combo_id_level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Text_id_user, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                                    .addComponent(text_username)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Text_password, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Text_nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_id_user, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_username, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Text_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Combo_id_level, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Text_id_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_id_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_id_userActionPerformed

    private void text_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_usernameActionPerformed

    private void Text_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_passwordActionPerformed

    private void Combo_id_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_id_levelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_id_levelActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            user u =new user();
            this.stat=k.getCon().prepareStatement("insert into user values(?,?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2, u.username);
            stat.setString(3, u.password);
            stat.setString(4, u.nama_user);
            stat.setInt(5,u.id_level);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            user u=new user();
            this.stat=k.getCon().prepareStatement("update user set username=?,"
                    + "password=?,nama_user=?,id_level=? where id_user=?");
            stat.setString(1, u.username);
            stat.setString(2, u.password);
            stat.setString(3, u.nama_user);
            stat.setInt(4,u.id_level);
             stat.setString(5,Text_id_user.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            user u=new user();
            this.stat=k.getCon().prepareStatement("delete from user where id_user=?");
            stat.setString(1, Text_id_user.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void Text_nama_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_nama_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_nama_userActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        Login l =new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void table_registrasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_registrasiMouseClicked
        // TODO add your handling code here:
        Text_id_user.setText(model.getValueAt(table_registrasi.getSelectedRow(), 0).toString());
        text_username.setText(model.getValueAt(table_registrasi.getSelectedRow(), 1).toString());
        Text_password.setText(model.getValueAt(table_registrasi.getSelectedRow(), 2).toString());
        Text_nama_user.setText(model.getValueAt(table_registrasi.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_table_registrasiMouseClicked

    private void btn_menu_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menu_masakanActionPerformed
        // TODO add your handling code here:
        Menu_Masakan masak = new Menu_Masakan();
        masak.setVisible(true);
        this.setVisible(false);
        masak.Btn_input.setEnabled(true);
        masak.Btn_delete.setEnabled(true);
        masak.Btn_update.setEnabled(true);
        masak.Btn_transaksi.setEnabled(true);
        masak.Btn_registrasi.setEnabled(true);
    }//GEN-LAST:event_btn_menu_masakanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Registrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_id_level;
    private javax.swing.JTextField Text_id_user;
    private javax.swing.JTextField Text_nama_user;
    private javax.swing.JTextField Text_password;
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_logout;
    public javax.swing.JButton btn_menu_masakan;
    public javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table_registrasi;
    private javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
}
