/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.LoginController;
import Model.Login;
import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class DashboardForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    
   
    
    public DashboardForm() {
        initComponents();
        setLocationRelativeTo(null);
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
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rSPanelImage5 = new rojerusan.RSPanelImage();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        rSPanelImage3 = new rojerusan.RSPanelImage();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rSPanelImage4 = new rojerusan.RSPanelImage();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rSPanelImage6 = new rojerusan.RSPanelImage();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        rSPanelImage10 = new rojerusan.RSPanelImage();
        jPanel8 = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        rSPanelImage8 = new rojerusan.RSPanelImage();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rSPanelImage9 = new rojerusan.RSPanelImage();
        kGradientPanel5 = new com.k33ptoo.components.KGradientPanel();
        rSPanelImage7 = new rojerusan.RSPanelImage();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(99, 111, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/Menu.png"))); // NOI18N

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

        jPanel1.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 13, 30, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("l");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 13, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dashboard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 20, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("-");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jLabel16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel16KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 20, 20));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Log Out");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage5.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage5Layout = new javax.swing.GroupLayout(rSPanelImage5);
        rSPanelImage5.setLayout(rSPanelImage5Layout);
        rSPanelImage5Layout.setHorizontalGroup(
            rSPanelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage5Layout.setVerticalGroup(
            rSPanelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.add(rSPanelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 220, 50));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Daftar Motor");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/motorcycle.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.add(rSPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, 50));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Pembelian Cash");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/idr.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage3Layout = new javax.swing.GroupLayout(rSPanelImage3);
        rSPanelImage3.setLayout(rSPanelImage3Layout);
        rSPanelImage3Layout.setHorizontalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage3Layout.setVerticalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(rSPanelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 50));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Paket Cicilan");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage4.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/cicilan.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage4Layout = new javax.swing.GroupLayout(rSPanelImage4);
        rSPanelImage4.setLayout(rSPanelImage4Layout);
        rSPanelImage4Layout.setHorizontalGroup(
            rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage4Layout.setVerticalGroup(
            rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel6.add(rSPanelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, 50));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Laporan");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage6.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/report.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage6Layout = new javax.swing.GroupLayout(rSPanelImage6);
        rSPanelImage6.setLayout(rSPanelImage6Layout);
        rSPanelImage6Layout.setHorizontalGroup(
            rSPanelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage6Layout.setVerticalGroup(
            rSPanelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel7.add(rSPanelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 50));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Pembelian Kredit");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, -1, -1));

        rSPanelImage10.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/credit.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage10Layout = new javax.swing.GroupLayout(rSPanelImage10);
        rSPanelImage10.setLayout(rSPanelImage10Layout);
        rSPanelImage10Layout.setHorizontalGroup(
            rSPanelImage10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage10Layout.setVerticalGroup(
            rSPanelImage10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel9.add(rSPanelImage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 50));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(99, 111, 254));
        kGradientPanel2.setkStartColor(new java.awt.Color(51, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage8.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/motorcycle.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage8Layout = new javax.swing.GroupLayout(rSPanelImage8);
        rSPanelImage8.setLayout(rSPanelImage8Layout);
        rSPanelImage8Layout.setHorizontalGroup(
            rSPanelImage8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        rSPanelImage8Layout.setVerticalGroup(
            rSPanelImage8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        kGradientPanel2.add(rSPanelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 50, 60));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Jenis Mobil");
        kGradientPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 25, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("...");
        kGradientPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 59, -1, -1));

        jPanel8.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 88, 220, 110));

        kGradientPanel3.setkEndColor(new java.awt.Color(51, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(99, 111, 254));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Income Bulan Ini");
        kGradientPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 25, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("...");
        kGradientPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 59, -1, -1));

        rSPanelImage9.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/idr.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage9Layout = new javax.swing.GroupLayout(rSPanelImage9);
        rSPanelImage9.setLayout(rSPanelImage9Layout);
        rSPanelImage9Layout.setHorizontalGroup(
            rSPanelImage9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        rSPanelImage9Layout.setVerticalGroup(
            rSPanelImage9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        kGradientPanel3.add(rSPanelImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 50, 60));

        jPanel8.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 220, 110));

        kGradientPanel5.setkEndColor(new java.awt.Color(51, 255, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(99, 111, 254));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage7.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Image/sales.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage7Layout = new javax.swing.GroupLayout(rSPanelImage7);
        rSPanelImage7.setLayout(rSPanelImage7Layout);
        rSPanelImage7Layout.setHorizontalGroup(
            rSPanelImage7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        rSPanelImage7Layout.setVerticalGroup(
            rSPanelImage7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        kGradientPanel5.add(rSPanelImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 50, 60));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("...");
        kGradientPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 59, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mobil Terjual");
        kGradientPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 25, -1, -1));

        jPanel8.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 88, 200, 110));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Selamat Datang");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 39, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(99,111,254));
        jLabel4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(99,111,254));
        jLabel5.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        jPanel6.setBackground(new Color(99,111,254));
        jLabel6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(99,111,254));
        jLabel7.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(Color.RED);
        jLabel3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(51,51,51));
        jLabel4.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(51,51,51));
        jLabel5.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(new Color(51,51,51));
        jLabel6.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(51,51,51));
        jLabel7.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new Color(51,51,51));
        jLabel3.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        this.setState(LoginForm.ICONIFIED);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel16KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16KeyPressed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        dispose();
        new DataMotorForm().setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(99,111,254));
        jLabel17.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(51,51,51));
        jLabel17.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        dispose();
        new BeliCashForm().setVisible(true);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        dispose();
        new BeliCreditForm().setVisible(true);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        dispose();
        new PaketCreditForm().setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        dispose();
        new LaporanForm().setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

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
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel5;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage10;
    private rojerusan.RSPanelImage rSPanelImage2;
    private rojerusan.RSPanelImage rSPanelImage3;
    private rojerusan.RSPanelImage rSPanelImage4;
    private rojerusan.RSPanelImage rSPanelImage5;
    private rojerusan.RSPanelImage rSPanelImage6;
    private rojerusan.RSPanelImage rSPanelImage7;
    private rojerusan.RSPanelImage rSPanelImage8;
    private rojerusan.RSPanelImage rSPanelImage9;
    // End of variables declaration//GEN-END:variables
}
