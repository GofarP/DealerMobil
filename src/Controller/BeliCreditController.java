/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCreditDao;
import Dao.InterfaceBeliCredit;
import Dao.InterfacePaket;
import Dao.PaketDao;
import Form.BeliCreditForm;
import Model.BeliCredit;
import Model.Paket;
import Table.TableModelDataBeliCredit;
import Table.TableModelDataPaket;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class BeliCreditController  {
    
    BeliCreditForm beliCreditForm;
    InterfaceBeliCredit interfaceBeliCredit;
    InterfacePaket interfacePaket;
    ArrayList<BeliCredit> beliCreditArrayList;
    ArrayList<Paket> paketArrayList;
    String idBeli="", idMotor="", idPaket="";
    BeliCredit beliCredit;
  
    
    public BeliCreditController(BeliCreditForm beliCreditForm)
    {
        this.beliCreditForm=beliCreditForm;
        
        interfaceBeliCredit=new BeliCreditDao();
        interfacePaket=new PaketDao();
        
        beliCreditArrayList=new ArrayList<>();
        paketArrayList=new ArrayList<>();
        
        beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
        paketArrayList=interfacePaket.showDataPaket();
        
        
    }
    
    public void showDataBeliCredit()
    {
        beliCreditArrayList.clear();
      
        beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
        TableModelDataBeliCredit modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
        beliCreditForm.getTblKredit().setModel(modelDataBeliCredit);
        
        beliCreditForm.getJButtonEdit().setEnabled(true);
        beliCreditForm.getJButtonHapus().setEnabled(true);
    }
    
    public void showPaket()
    {
        paketArrayList.clear();
        paketArrayList=interfacePaket.showDataPaket();
        TableModelDataPaket modelDataPaket=new TableModelDataPaket(paketArrayList);
        beliCreditForm.getTblKredit().setModel(modelDataPaket);
        
        beliCreditForm.getJButtonEdit().setEnabled(false);
        beliCreditForm.getJButtonHapus().setEnabled(false);
    }
    
    public boolean validation()
    {
        boolean kosong=false;
        
        JTextField[] tfbeliCredit={beliCreditForm.getJTextFieldNoKtp(), beliCreditForm.getJTextFieldNama(), beliCreditForm.getJTextFieldNoKtp(), 
            beliCreditForm.getJTextFieldAlamat(), beliCreditForm.getJTextFieldNoTelp()};
        
        for(JTextField jtf:tfbeliCredit)
        {
            if(jtf.getText().trim().equals("")) kosong=true;
        }
        
        return kosong;
    }
    
    
    public void tambahBeliCredit()
    {
        if(validation())
        {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Biodata Pembeli Secara Lengkap");
        }
        
        else if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Dibeli");
        }
        
        else
        {
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date tglSekarang=new Date();
           int row=beliCreditForm.getTblKredit().getSelectedRow();
           
           String noBeli=interfaceBeliCredit.noOtomatis();
           String noKtp=beliCreditForm.getJTextFieldNoKtp().getText().trim();
           String nama=beliCreditForm.getJTextFieldNama().getText().trim();
           String jenisKelamin=beliCreditForm.getCbJenisKelamin().getSelectedItem().toString();
           String alamat=beliCreditForm.getJTextFieldAlamat().getText().trim();
           String noTelp=beliCreditForm.getJTextFieldNoTelp().getText().trim();
           int uangmuka=beliCreditArrayList.get(row).getUangMuka();
           
           
           beliCredit=new BeliCredit();
           
           beliCredit.setNoBeli(noBeli);
           beliCredit.setNoKtp(noKtp);
           beliCredit.setNama(nama);
           beliCredit.setJenisKelamin(jenisKelamin);
           beliCredit.setAlamat(alamat);
           beliCredit.setNoTelp(noTelp);
           beliCredit.setIdPaket(Integer.parseInt(idPaket));
           beliCredit.setTglBeli(sdf.format(tglSekarang));
           beliCredit.setUangMuka(uangmuka);
           beliCredit.setStatus("belum");
           
           interfaceBeliCredit.tambahData(beliCredit);
           
           
           
           clearPembeli();
        }
    }
    
    public void updateCredit()
    {
        if(idBeli.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Yang Akan Diedit");
        }
        
        else if(interfaceBeliCredit.cekCicilan(Integer.parseInt(idBeli)))
        {
            JOptionPane.showMessageDialog(null, "Tidak Bisa Mengedit Data, Sedang dalam Proses Cicilan");
        }
        
        else
        {
             
              String noKtp=beliCreditForm.getJTextFieldNoKtp().getText().trim();
              String nama=beliCreditForm.getJTextFieldNama().getText().trim();
              String jenisKelamin=beliCreditForm.getCbJenisKelamin().getSelectedItem().toString();
              String alamat=beliCreditForm.getJTextFieldAlamat().getText().trim();
              String noTelp=beliCreditForm.getJTextFieldNoTelp().getText().trim();
              
              beliCredit=new BeliCredit();
              
              beliCredit.setNoKtp(noKtp);
              beliCredit.setNama(nama);
              beliCredit.setJenisKelamin(jenisKelamin);
              beliCredit.setAlamat(alamat);
              beliCredit.setNoTelp(noTelp);
              beliCredit.setIdBeli(Integer.parseInt(idBeli));
                            
              interfaceBeliCredit.editData(beliCredit);
        }
    }
    
    public void deleteCredit()
    {
        if(idBeli.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Yang Akan Dihapus");
        }
        
        else if(interfaceBeliCredit.cekCicilan(Integer.parseInt(idBeli)))
        {
            JOptionPane.showMessageDialog(null, "Tidak Bisa Menghapus Data, Sedang dalam Proses Cicilan");
        }
        
        else
        {
               int opsi=JOptionPane.showConfirmDialog(null, "Hapus data pembelian ini ?","Hapus Data Pembelian",JOptionPane.YES_NO_OPTION);
               
               if(opsi==JOptionPane.YES_OPTION) interfaceBeliCredit.deletedata(Integer.parseInt(idBeli), Integer.parseInt(idMotor));
        }
            
    }
    
    
    public void getValueAt()
    {
        int row=beliCreditForm.getTblKredit().getSelectedRow();
        
        idPaket=String.valueOf(paketArrayList.get(row).getIdPaket());
        idBeli=String.valueOf(beliCreditArrayList.get(row).getIdBeli());
        idMotor=String.valueOf(beliCreditArrayList.get(row).getIdMotor());
        
        if(beliCreditForm.getRbPembeli().isSelected())
        {
            beliCreditForm.getJTextFieldNoKtp().setText(beliCreditArrayList.get(row).getNoKtp());
            beliCreditForm.getJTextFieldNama().setText(beliCreditArrayList.get(row).getNama());
            beliCreditForm.getCbJenisKelamin().setSelectedItem(beliCreditArrayList.get(row).getJenisKelamin());
            beliCreditForm.getJTextFieldAlamat().setText(beliCreditArrayList.get(row).getAlamat());
            beliCreditForm.getJTextFieldNoTelp().setText(beliCreditArrayList.get(row).getNoTelp());
            
        }
        
        beliCreditForm.getJlabelKodePaket().setText(paketArrayList.get(row).getKodePaket());
        beliCreditForm.getJlabelKodeMotor().setText(paketArrayList.get(row).getKodeMotor());
        beliCreditForm.getJlabelNamaMotor().setText(paketArrayList.get(row).getNamaMotor());
        beliCreditForm.getJlabelMerk().setText(paketArrayList.get(row).getMerkMotor());
        beliCreditForm.getJlabelWarna().setText(paketArrayList.get(row).getWarnaMotor());
        beliCreditForm.getJlabelJumlahCicilan().setText(String.valueOf(paketArrayList.get(row).getJumlahCicilan()));
        beliCreditForm.getJlabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getNilaiCicilan()));
        beliCreditForm.getJlabelBunga().setText(paketArrayList.get(row).getBunga()+"%");
        beliCreditForm.getJLabelUangMuka().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getUangMuka()));
        beliCreditForm.getJlabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getHargaTotal()));

        
    }
    
    
    public void cari()
    {
        int indexBerdasarkan=beliCreditForm.getCbBerdasarkan().getSelectedIndex();
        
        String cari=beliCreditForm.getTxtCari().getText().trim();

        if(beliCreditForm.getCbKategori().getSelectedIndex()==0)
        {
            beliCreditForm.getRbPembeli().setSelected(true);
            
            beliCreditArrayList=new ArrayList<>();
            
            TableModelDataBeliCredit tableModelDataBeliCredit;
            
            switch(indexBerdasarkan)
            {
                case 0:
                    beliCreditArrayList.clear();
                    beliCreditArrayList=interfaceBeliCredit.searchDataKreditByKode(cari);
                    break;
                    
                case 1:
                    beliCreditArrayList.clear();
                    beliCreditArrayList=interfaceBeliCredit.searchDatKreditByNama(cari);
                    break;
            }
            
            if(beliCreditArrayList.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Data Tidak DItemukan");
            }
            
            else
            {
                tableModelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
                beliCreditForm.getTblKredit().setModel(tableModelDataBeliCredit);
            }
        }
        
        else if(beliCreditForm.getCbKategori().getSelectedIndex()==1)
        {
            paketArrayList.clear();
            
            paketArrayList=new ArrayList<>();
            
            TableModelDataPaket tableModelDataPaket;
            
            beliCreditForm.getRbpaket().setSelected(true);
            
            switch(indexBerdasarkan)
            {
                
                case 0:
                    paketArrayList=interfacePaket.searchDataPaketByKode(cari);
                    break;
                    
                case 1:
                    paketArrayList=interfacePaket.searchDataPaketByMotor(cari);
                    break;
            }
            
            if(paketArrayList.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Data tidak Ditemukan");
            }
            
            else 
            {
                beliCreditForm.getTblKredit().remove(0);
                tableModelDataPaket=new TableModelDataPaket(paketArrayList);
                beliCreditForm.getTblKredit().setModel(tableModelDataPaket);
            }
        }
    }
    
    
    public void cetaStrukBeliCredit(ArrayList<BeliCredit>beliCreditArrayList)
    {
        try
        {
           int row=beliCreditForm.getTblKredit().getSelectedRow();
           File reportFile=new File("src/report/NoteCredit.jrxml");
           JasperDesign jDesign=JRXmlLoader.load(reportFile);
           Map formValues=new HashMap();
                
           formValues.put("kodeMotor", beliCreditArrayList.get(row).getKodeMotor());
           formValues.put("namaMotor", beliCreditArrayList.get(row).getNamaMotor());
           formValues.put("merk", beliCreditArrayList.get(row).getMerkMotor());
           formValues.put("kodePaket", beliCreditArrayList.get(row).getKodePaket());
           formValues.put("jumlahCicilan", beliCreditArrayList.get(row).getJumlahCicilan());
           formValues.put("nilaiCicilan", beliCreditArrayList.get(row).getNilaiCicilan());
           formValues.put("warna", beliCreditArrayList.get(row).getWarna());
           formValues.put("harga", beliCreditArrayList.get(row).getHarga());
           formValues.put("tglBeli", beliCreditArrayList.get(row).getTglBeli());
           formValues.put("bunga", beliCreditArrayList.get(row).getBunga());
           
           formValues.put("uangMuka", beliCreditArrayList.get(row).getUangMuka());
           formValues.put("hargaTotal", beliCreditArrayList.get(row).getTglBeli());
                
           JasperReport jr=JasperCompileManager.compileReport(jDesign);
           JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
           JasperViewer.viewReport(jp,false); 
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
           
    }
    
    
    public void clearPaket()
    {
        idMotor="";
        idPaket="";
        
        beliCreditForm.getJlabelKodePaket().setText("...");
        beliCreditForm.getJlabelKodeMotor().setText("...");
        beliCreditForm.getJlabelNamaMotor().setText("...");
        beliCreditForm.getJlabelMerk().setText("...");
        beliCreditForm.getJlabelWarna().setText("...");
        beliCreditForm.getJlabelJumlahCicilan().setText("...");
        beliCreditForm.getJlabelNilaiCicilan().setText("...");
        beliCreditForm.getJlabelBunga().setText("...");
        beliCreditForm.getJLabelUangMuka().setText("...");
        beliCreditForm.getJlabelHargaTotal().setText("...");

    }
    
    public void clearPembeli()
    {
        idBeli="";
        
        beliCreditForm.getJTextFieldNoKtp().setText("");
        beliCreditForm.getJTextFieldNama().setText("");
        beliCreditForm.getCbJenisKelamin().setSelectedIndex(0);
        beliCreditForm.getJTextFieldAlamat().setText("");
        beliCreditForm.getJTextFieldNoTelp().setText("");
        
        beliCreditForm.getJlabelKodePaket().setText("...");
        beliCreditForm.getJlabelKodeMotor().setText("...");
        beliCreditForm.getJlabelNamaMotor().setText("...");
        beliCreditForm.getJlabelMerk().setText("...");
        beliCreditForm.getJlabelWarna().setText("...");
        beliCreditForm.getJlabelJumlahCicilan().setText("...");
        beliCreditForm.getJlabelNilaiCicilan().setText("...");
        beliCreditForm.getJlabelBunga().setText("...");
        beliCreditForm.getJLabelUangMuka().setText("...");
        beliCreditForm.getJlabelHargaTotal().setText("...");

    }
    
    
}
