package kasir;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



import java.text.DateFormat;
public class Menu_Transaksi extends javax.swing.JFrame {
    private DefaultTableModel model=null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
   
    public Menu_Transaksi() {
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
     class transaksi extends Menu_Transaksi {
        int id_transaksi,id_masakan,harga,jumlah_beli,total_bayar;
        String nama_pelanggan, nama_masakan, tanggal;
        
        public transaksi() {
            this.nama_pelanggan= Text_nama_pelanggan.getText();
            String combo = Combo_id_masakan.getSelectedItem().toString();
            String arr[]=combo.split(":");
            this.id_masakan=Integer.parseInt(arr[0]);
            try {
                Date date=text_tanggal.getDate();
                DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal=dateFormat.format(date);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            this.nama_masakan=arr[1];
            harga=Integer.parseInt(arr[2]);
            this.jumlah_beli=Integer.parseInt(Text_jumlah_beli.getText());
            this.total_bayar=harga*jumlah_beli;
        }
    }
     
    public void refreshTable(){
         model = new DefaultTableModel();
         model.addColumn("ID Transaksi");
         model.addColumn("Nama Pelanggan");
         model.addColumn("ID Masakan");
         model.addColumn("Tanggal");
         model.addColumn("Nama Masakan");
         model.addColumn("Harga");
         model.addColumn("Jumlah Beli");
         model.addColumn("Total Beli");
         Table_transaksi.setModel(model);
         try {
               this.stat = k.getCon().prepareStatement("select * from transaksi");
               this.rs=this.stat.executeQuery();
               while (rs.next()){
                   Object [] data = {
                       rs.getString("id_Transaksi"),
                       rs.getString("nama_pelanggan"),
                       rs.getString("id_masakan"),
                       rs.getString("tanggal"),
                       rs.getString("nama_masakan"),
                       rs.getString("harga"),
                       rs.getString("jumlah_beli"),
                       rs.getString("total_bayar"),
                           
                   };
                   model.addRow(data);
               }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         text_id_transaksi.setText("");
         Text_nama_pelanggan.setText("");
         Text_total_bayar.setText("");
         Text_jumlah_beli.setText("");
     }
    
    public void refreshCombo(){
        try {
            this.stat = k.getCon().prepareStatement("Select * from masakan "
                    + "where status='tersedia'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                Combo_id_masakan.addItem(rs.getString("id_masakan")+":"
                        +rs.getString("nama_masakan")+":"+rs.getString("harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_id_transaksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Text_nama_pelanggan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Text_jumlah_beli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Combo_id_masakan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_transaksi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Btn_input = new javax.swing.JButton();
        Btn_update = new javax.swing.JButton();
        Btn_delete = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Text_total_bayar = new javax.swing.JTextField();
        Btn_lihat_menu = new javax.swing.JButton();
        text_tanggal = new com.toedter.calendar.JDateChooser();
        Btn_cetak_laporan = new javax.swing.JButton();

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
        jLabel2.setText("TRANSAKSI");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel3.setText("ID Transaksi");

        text_id_transaksi.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        text_id_transaksi.setEnabled(false);
        text_id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_transaksiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Nama Pelanggan");

        Text_nama_pelanggan.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_nama_pelangganActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel5.setText("Id Masakan");

        Text_jumlah_beli.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_jumlah_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_jumlah_beliActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel6.setText("Jumlah Beli");

        Combo_id_masakan.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        Combo_id_masakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Combo_id_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_id_masakanActionPerformed(evt);
            }
        });

        Table_transaksi.setAutoCreateRowSorter(true);
        Table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Nama Pelanggan", "ID Masakan", "Tanggal", "Nama Masakan", "Harga", "Jumlah Beli", "Total Bayaran"
            }
        ));
        Table_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_transaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_transaksi);

        Btn_input.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_input.setText("INPUT");
        Btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_inputActionPerformed(evt);
            }
        });

        Btn_update.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_update.setText("UPDATE");
        Btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_updateActionPerformed(evt);
            }
        });

        Btn_delete.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_delete.setText("DELETE");
        Btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_update)
                    .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btn_logout.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 18)); // NOI18N
        btn_logout.setText("LOG OUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel7.setText("Tanggal");

        jLabel8.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        jLabel8.setText("Total Bayar");

        Text_total_bayar.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        Text_total_bayar.setEnabled(false);
        Text_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_total_bayarActionPerformed(evt);
            }
        });

        Btn_lihat_menu.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_lihat_menu.setText("LIHAT MENU");
        Btn_lihat_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_lihat_menuActionPerformed(evt);
            }
        });

        Btn_cetak_laporan.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 24)); // NOI18N
        Btn_cetak_laporan.setText("CETAK LAPORAN");
        Btn_cetak_laporan.setEnabled(false);
        Btn_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cetak_laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_logout))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Combo_id_masakan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_lihat_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Text_nama_pelanggan, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(text_id_transaksi, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Text_total_bayar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Text_jumlah_beli)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(925, Short.MAX_VALUE)
                .addComponent(Btn_cetak_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Btn_lihat_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Combo_id_masakan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Text_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_cetak_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void text_id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_id_transaksiActionPerformed

    private void Text_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_nama_pelangganActionPerformed

    private void Text_jumlah_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_jumlah_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_jumlah_beliActionPerformed

    private void Combo_id_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_id_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_id_masakanActionPerformed

    private void Btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_inputActionPerformed
        // TODO add your handling code here:
          try {
            transaksi tran =new transaksi();
            Text_total_bayar.setText(""+tran.total_bayar);
            this.stat=k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2, tran.nama_pelanggan);
            stat.setInt(3, tran.id_masakan);
            stat.setString(4, tran.tanggal);
            stat.setString(5,tran.nama_masakan);
            stat.setInt(6, tran.harga);
            stat.setInt(7, tran.jumlah_beli);
            stat.setInt(8, tran.total_bayar); 
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Tanggal: "+tran.tanggal+
                    "\nNama Pelanggan: "+tran.nama_pelanggan+
                    "\nPembelian: "+tran.jumlah_beli+" "+tran.nama_masakan+
                    "\nTotal Bayar "+tran.total_bayar+"\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
              if (pilihan==JOptionPane.YES_OPTION) {
                  this.stat.executeUpdate();
                  refreshTable();
              } else {
                  refreshTable(); 
              }
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_inputActionPerformed

    private void Btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            transaksi tran = new transaksi();
            tran.id_masakan= Integer.parseInt(text_id_transaksi.getText());
            this.stat=k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                    + "id_masakan=?,tanggal=?,nama_masakan=?,harga=?,jumlah_beli=?,total_bayar=? where id_transaksi=?");
            this.stat.setString(1, tran.nama_pelanggan);
            this.stat.setInt(2, tran.id_masakan);
            this.stat.setString(3, tran.tanggal);
            this.stat.setString(4, tran.nama_masakan);
            this.stat.setInt(5, tran.harga);
            this.stat.setInt(6, tran.jumlah_beli);
            this.stat.setInt(7, tran.total_bayar);
            this.stat.setInt(8, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_updateActionPerformed

    private void Btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            transaksi tran=new transaksi();
            tran.id_masakan= Integer.parseInt(text_id_transaksi.getText());
            this.stat=k.getCon().prepareStatement("delete from transaksi where id_transaksi=?");
            stat.setInt(1, tran.id_transaksi);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_deleteActionPerformed

    private void Text_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_total_bayarActionPerformed

    private void Btn_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cetak_laporanActionPerformed
        // TODO add your handling code here:
        try {
            File namafile= new File("src/laporan/laporan_transaksi.jasper");
            JasperPrint jp=JasperFillManager.fillReport(namafile.getPath(), null, k.getCon());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_Btn_cetak_laporanActionPerformed

    private void Btn_lihat_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_lihat_menuActionPerformed
        // TODO add your handling code here:
        Menu_Masakan masak = new Menu_Masakan();
        masak.setVisible(true);
        this.setVisible(false);
        masak.Btn_delete.setEnabled(true);
        masak.Btn_input.setEnabled(true);
        masak.Btn_update.setEnabled(true);
        masak.Btn_transaksi.setEnabled(true);
    }//GEN-LAST:event_Btn_lihat_menuActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        Login l =new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void Table_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_transaksiMouseClicked
        // TODO add your handling code here:
        text_id_transaksi.setText((String) model.getValueAt(Table_transaksi.getSelectedRow(), 0));
        Text_nama_pelanggan.setText(model.getValueAt(Table_transaksi.getSelectedRow(), 1).toString());
        Text_jumlah_beli.setText(model.getValueAt(Table_transaksi.getSelectedRow(), 6).toString());
        Text_total_bayar.setText(model.getValueAt(Table_transaksi.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_Table_transaksiMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_cetak_laporan;
    public javax.swing.JButton Btn_delete;
    public javax.swing.JButton Btn_input;
    private javax.swing.JButton Btn_lihat_menu;
    public javax.swing.JButton Btn_update;
    private javax.swing.JComboBox<String> Combo_id_masakan;
    private javax.swing.JTable Table_transaksi;
    private javax.swing.JTextField Text_jumlah_beli;
    private javax.swing.JTextField Text_nama_pelanggan;
    private javax.swing.JTextField Text_total_bayar;
    public javax.swing.JButton btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField text_id_transaksi;
    private com.toedter.calendar.JDateChooser text_tanggal;
    // End of variables declaration//GEN-END:variables
}
