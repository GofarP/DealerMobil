/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.PaketController;
import Model.Paket;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class PaketCreditForm extends javax.swing.JFrame {

    /**
     * Creates new form PaketCreditForm
     */
    Paket paket;
    PaketController paketController;
    
    public PaketCreditForm() {
        initComponents();
        setLocationRelativeTo(null);
        paketController=new PaketController(this);
        paketController.showDataPaket();
        
    }
    
    public JLabel getJlabelKodePaket()
    {
        return lblkodepaket;
    }
    
    public JLabel getJlabelKodeMotor()
    {
        return lblkodemotor;
    }
    
    public JLabel getJlabelNamaMotor()
    {
        return lblnamamotor;
    }
    
    
    public JLabel getJlabelMerk()
    {
        return lblmerk;
    }
    
    public JLabel getJlabelWarna()
    {
        return lblwarna;
    }
    
    public JLabel getJlabelStok()
    {
        return lblstok;
    }
    
    public JLabel getJlabelHarga()
    {
        return lblharga;
    }
    
    public JLabel getJlabelNilaiCicilan()
    {
        return lblnilaicicilan;
    }
    
    public JLabel getJlabelHargaTotal()
    {
        return lblhargatotal;
    }
    
    public JLabel getJlabelHutangPokok()
    {
        return lblhutangpokok;
    }
    
    public JLabel getJlabelTotalBunga()
    {
        return lbltotalbunga;
    }
    
    public JComboBox getCbCicilan()
    {
        return cbcicilan;
    }
    
    
    public JComboBox getCbKategori()
    {
        return cbkategori;
    }
    
    public JComboBox getCbBerdasarkan()
    {
        return cbberdasarkan;
    }
    
    public JTextField getTxtBunga()
    {
        return txtbunga;
    }
    
    public JTextField getTxtUangMuka()
    {
        return txtuangmuka;
    }
    
    public JTextField getTxtCari()
    {
        return txtcaridata;
    }
    
    public JTable getTblPaket()
    {
        return tblpaket;
    }
    
    public JRadioButton getRbpaket()
    {
        return rbpaket;
    }
    
    public JRadioButton getRbMotor()
    {
        return rbmotor;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jPanel4 = new javax.swing.JPanel();
        lblharga = new javax.swing.JLabel();
        lblhargatotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblkodepaket = new javax.swing.JLabel();
        lblkodemotor = new javax.swing.JLabel();
        lblnamamotor = new javax.swing.JLabel();
        lblmerk = new javax.swing.JLabel();
        lblwarna = new javax.swing.JLabel();
        lblstok = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbcicilan = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtuangmuka = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtbunga = new javax.swing.JTextField();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblnilaicicilan = new javax.swing.JLabel();
        rSButtonMetro4 = new rojerusan.RSButtonMetro();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbltotalbunga = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblhutangpokok = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtcaridata = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbberdasarkan = new javax.swing.JComboBox<>();
        cbkategori = new javax.swing.JComboBox<>();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();
        rSButtonMetro6 = new rojerusan.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpaket = new rojerusan.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        rbmotor = new javax.swing.JRadioButton();
        rbpaket = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(99, 111, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 30, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 720));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Paket Kredit:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(99, 111, 254))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblharga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblharga.setForeground(new java.awt.Color(99, 111, 254));
        lblharga.setText("...");
        jPanel4.add(lblharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        lblhargatotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblhargatotal.setForeground(new java.awt.Color(99, 111, 254));
        lblhargatotal.setText("...");
        jPanel4.add(lblhargatotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(99, 111, 254));
        jLabel11.setText("Uang Muka:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(99, 111, 254));
        jLabel12.setText(" Kode Motor:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(99, 111, 254));
        jLabel13.setText("Nama Motor:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(99, 111, 254));
        jLabel14.setText("Merk:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(99, 111, 254));
        jLabel15.setText("Warna:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(99, 111, 254));
        jLabel16.setText("Stok:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 200, -1, -1));

        lblkodepaket.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblkodepaket.setForeground(new java.awt.Color(99, 111, 254));
        lblkodepaket.setText("...");
        jPanel4.add(lblkodepaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        lblkodemotor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblkodemotor.setForeground(new java.awt.Color(99, 111, 254));
        lblkodemotor.setText("...");
        jPanel4.add(lblkodemotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        lblnamamotor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblnamamotor.setForeground(new java.awt.Color(99, 111, 254));
        lblnamamotor.setText("...");
        jPanel4.add(lblnamamotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        lblmerk.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblmerk.setForeground(new java.awt.Color(99, 111, 254));
        lblmerk.setText("...");
        jPanel4.add(lblmerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        lblwarna.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblwarna.setForeground(new java.awt.Color(99, 111, 254));
        lblwarna.setText("...");
        jPanel4.add(lblwarna, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        lblstok.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblstok.setForeground(new java.awt.Color(99, 111, 254));
        lblstok.setText("...");
        jPanel4.add(lblstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(99, 111, 254));
        jLabel17.setText("%");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        cbcicilan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "36", "48", "60", "72" }));
        jPanel4.add(cbcicilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 130, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(99, 111, 254));
        jLabel18.setText("Cicilan (Bulan):");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        txtuangmuka.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtuangmuka, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 130, 25));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(99, 111, 254));
        jLabel19.setText("Bunga Per Tahun:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        txtbunga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtbunga, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 40, 25));

        rSButtonMetro1.setBackground(new java.awt.Color(225, 0, 0));
        rSButtonMetro1.setText("Hapus");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 90, 36));

        rSButtonMetro2.setText("Tambah");
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 36));

        rSButtonMetro3.setText("Edit");
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 80, 36));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(99, 111, 254));
        jLabel20.setText("Harga:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 230, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(99, 111, 254));
        jLabel21.setText("Harga Total:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(99, 111, 254));
        jLabel22.setText("Total Bunga:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 80, -1));

        lblnilaicicilan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblnilaicicilan.setForeground(new java.awt.Color(99, 111, 254));
        lblnilaicicilan.setText("...");
        jPanel4.add(lblnilaicicilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        rSButtonMetro4.setText("Hitung");
        rSButtonMetro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro4ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButtonMetro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 95, 36));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(99, 111, 254));
        jLabel23.setText("Kode Paket:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(99, 111, 254));
        jLabel24.setText("Cicilan (Per bulan):");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 110, -1));

        lbltotalbunga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbltotalbunga.setForeground(new java.awt.Color(99, 111, 254));
        lbltotalbunga.setText("...");
        jPanel4.add(lbltotalbunga, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 110, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(99, 111, 254));
        jLabel26.setText("Hutang Pokok:");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 90, -1));

        lblhutangpokok.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblhutangpokok.setForeground(new java.awt.Color(99, 111, 254));
        lblhutangpokok.setText("...");
        jPanel4.add(lblhutangpokok, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 110, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 70, 670, 350));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(99, 111, 254))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(99, 111, 254));
        jLabel25.setText("Berdasarkan:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtcaridata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        txtcaridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaridataActionPerformed(evt);
            }
        });
        jPanel5.add(txtcaridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, 20));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(99, 111, 254));
        jLabel27.setText("Cari Data:");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(99, 111, 254));
        jLabel28.setText("Kategori:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cbberdasarkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode", "Nama" }));
        jPanel5.add(cbberdasarkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 150, -1));

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paket", "Mobil" }));
        jPanel5.add(cbkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 150, -1));

        rSButtonMetro5.setText("Reset Tabel");
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });
        jPanel5.add(rSButtonMetro5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 230, 30));

        rSButtonMetro6.setText("Cari");
        rSButtonMetro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro6ActionPerformed(evt);
            }
        });
        jPanel5.add(rSButtonMetro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 280, 280));

        tblpaket.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpaket);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 1100, 220));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tampilkan Data:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 112, 192))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbmotor.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbmotor);
        rbmotor.setText("Motor");
        rbmotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmotorActionPerformed(evt);
            }
        });
        jPanel6.add(rbmotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 18, -1, -1));

        rbpaket.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbpaket);
        rbpaket.setSelected(true);
        rbpaket.setText("Paket");
        rbpaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbpaketActionPerformed(evt);
            }
        });
        jPanel6.add(rbpaket, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 18, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 280, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSPanelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSPanelImage1MouseClicked
        // TODO add your handling code here:
        dispose();
        new DashboardForm().setVisible(true);
    }//GEN-LAST:event_rSPanelImage1MouseClicked

    private void rSButtonMetro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro4ActionPerformed
        // TODO add your handling code here:
        paketController.hitungPaket();
    }//GEN-LAST:event_rSButtonMetro4ActionPerformed

    private void txtcaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaridataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaridataActionPerformed

    private void rbpaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbpaketActionPerformed
        // TODO add your handling code here:
        paketController.showDataPaket();
        paketController.clear();
        
    }//GEN-LAST:event_rbpaketActionPerformed

    private void rbmotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmotorActionPerformed
        // TODO add your handling code here:
        paketController.showDataMotor();
        paketController.clear();
        
    }//GEN-LAST:event_rbmotorActionPerformed

    private void tblpaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpaketMouseClicked
        // TODO add your handling code here:
        paketController.getRowData();
    }//GEN-LAST:event_tblpaketMouseClicked

    private void rSButtonMetro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro6ActionPerformed
        // TODO add your handling code here:
        paketController.searchData();
    }//GEN-LAST:event_rSButtonMetro6ActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        // TODO add your handling code here:
        paketController.resetTable();
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        // TODO add your handling code here:
        paketController.tambahPaket();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // TODO add your handling code here:
        paketController.editPaket();
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        // TODO add your handling code here:
        paketController.hapusPaket();
        paketController.showDataPaket();
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

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
            java.util.logging.Logger.getLogger(PaketCreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaketCreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaketCreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaketCreditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaketCreditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbberdasarkan;
    private javax.swing.JComboBox<String> cbcicilan;
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblharga;
    private javax.swing.JLabel lblhargatotal;
    private javax.swing.JLabel lblhutangpokok;
    private javax.swing.JLabel lblkodemotor;
    private javax.swing.JLabel lblkodepaket;
    private javax.swing.JLabel lblmerk;
    private javax.swing.JLabel lblnamamotor;
    private javax.swing.JLabel lblnilaicicilan;
    private javax.swing.JLabel lblstok;
    private javax.swing.JLabel lbltotalbunga;
    private javax.swing.JLabel lblwarna;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojerusan.RSButtonMetro rSButtonMetro4;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private rojerusan.RSButtonMetro rSButtonMetro6;
    private rojerusan.RSPanelImage rSPanelImage1;
    private javax.swing.JRadioButton rbmotor;
    private javax.swing.JRadioButton rbpaket;
    private rojerusan.RSTableMetro tblpaket;
    private javax.swing.JTextField txtbunga;
    private javax.swing.JTextField txtcaridata;
    private javax.swing.JTextField txtuangmuka;
    // End of variables declaration//GEN-END:variables
}
