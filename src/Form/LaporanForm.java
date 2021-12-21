/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.LaporanController;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class LaporanForm extends javax.swing.JFrame {

    /**
     * Creates new form LaporanForm
     */
    LaporanController laporanController;
    
    public LaporanForm() {
        initComponents();
        setLocationRelativeTo(null);
        laporanController=new LaporanController(this);
    }
    
    
    public JTextField getTxtCariMotor()
    {
        return txtcarimotor;
    }
    
    public JTextField getTxtCariPaket()
    {
        return txtcaripaket;
    }
    
    public JTextField getTxtCariPenjualan()
    {
        return txtcaritransaksi;
    }
    
    
    public JComboBox getCbMotorBerdasarkan()
    {
        return cbmotorberdasarkan;
    }
    
    public JComboBox getCbPaketBerdasarkan()
    {
        return cbpaketberdasarkan;
    }
    
    public JComboBox getCbTransaksiBerdasarkan()
    {
        return cbtransaksiberdasarkan;
    }
    
    
    public JComboBox getCbTransaksiJenis()
    {
        return cbtransaksijenis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcarimotor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbmotorberdasarkan = new javax.swing.JComboBox<>();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtcaritransaksi = new javax.swing.JTextField();
        cbtransaksijenis = new javax.swing.JComboBox<>();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        jLabel5 = new javax.swing.JLabel();
        cbtransaksiberdasarkan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtcaripaket = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbpaketberdasarkan = new javax.swing.JComboBox<>();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(99, 111, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        rSPanelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSPanelImage1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 30, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 680));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Motor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(99, 111, 254))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(99, 111, 254));
        jLabel1.setText("Berdasarkan:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 90, -1, -1));
        jPanel3.add(txtcarimotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 161, -1));

        jLabel2.setForeground(new java.awt.Color(99, 111, 254));
        jLabel2.setText("Cari:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 55, -1, -1));

        cbmotorberdasarkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Kode Motor", "Merk ", "Nama", "Warna" }));
        jPanel3.add(cbmotorberdasarkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, -1));

        rSButtonMetro1.setText("Cetak");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 230, 33));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 294, 205));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pembelian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(99, 111, 254))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(99, 111, 254));
        jLabel3.setText("Berdasarkan:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));
        jPanel4.add(txtcaritransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 161, -1));

        cbtransaksijenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash ", "Credit", "Cicilan" }));
        jPanel4.add(cbtransaksijenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, -1));

        rSButtonMetro2.setText("Cetak");
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 240, 33));

        jLabel5.setForeground(new java.awt.Color(99, 111, 254));
        jLabel5.setText("Jenis Transaksi:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        cbtransaksiberdasarkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Kode", "Nama" }));
        jPanel4.add(cbtransaksiberdasarkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 160, -1));

        jLabel8.setForeground(new java.awt.Color(99, 111, 254));
        jLabel8.setText("Cari:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 420, 250));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Paket:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(99, 111, 254))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(99, 111, 254));
        jLabel6.setText("Berdasarkan:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, -1));
        jPanel5.add(txtcaripaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 161, -1));

        jLabel7.setForeground(new java.awt.Color(99, 111, 254));
        jLabel7.setText("Cari:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 55, -1, -1));

        cbpaketberdasarkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Kode Paket", "Nama Motor" }));
        jPanel5.add(cbpaketberdasarkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, -1));

        rSButtonMetro3.setText("Cetak");
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        jPanel5.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 230, 33));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 290, 205));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSPanelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelImage1MouseClicked
        // TODO add your handling code here:
        dispose();
        new DashboardForm().setVisible(true);
    }//GEN-LAST:event_rSPanelImage1MouseClicked

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // TODO add your handling code here:
        laporanController.cetakLaporanPaket();
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        // TODO add your handling code here:
        laporanController.cetakLaporanMotor();
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        // TODO add your handling code here:
        laporanController.cetakLaporanTransaksi();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

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
            java.util.logging.Logger.getLogger(LaporanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbmotorberdasarkan;
    private javax.swing.JComboBox<String> cbpaketberdasarkan;
    private javax.swing.JComboBox<String> cbtransaksiberdasarkan;
    private javax.swing.JComboBox<String> cbtransaksijenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojerusan.RSPanelImage rSPanelImage1;
    private javax.swing.JTextField txtcarimotor;
    private javax.swing.JTextField txtcaripaket;
    private javax.swing.JTextField txtcaritransaksi;
    // End of variables declaration//GEN-END:variables
}
