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
    ArrayList<Paket>strukPaketArrayList;
    String idBeli="", idMotor="", idPaket="",kodePaket="";
    BeliCredit beliCredit;
    TableModelDataPaket modelDataPaket;
    TableModelDataBeliCredit modelDataBeliCredit;
    
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
        modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
        beliCreditForm.getTblKredit().setModel(modelDataBeliCredit);
        
        beliCreditForm.getJButtonTambah().setEnabled(false);
        beliCreditForm.getJButtonEdit().setEnabled(true);
        beliCreditForm.getJButtonHapus().setEnabled(true);
        beliCreditForm.getJButtonCetak().setEnabled(true);
    }
    
    public void showPaket()
    {
        paketArrayList.clear();
        
        paketArrayList=interfacePaket.showDataPaket();
        modelDataPaket=new TableModelDataPaket(paketArrayList);
        beliCreditForm.getTblKredit().setModel(modelDataPaket);
        
        beliCreditForm.getJButtonTambah().setEnabled(true);
        beliCreditForm.getJButtonEdit().setEnabled(false);
        beliCreditForm.getJButtonHapus().setEnabled(false);
        beliCreditForm.getJButtonCetak().setEnabled(false);
    }
    
    
    public void resetTable()
    {
        if(beliCreditForm.getRbpaket().isSelected())
        {
            paketArrayList.clear();
        
            paketArrayList=interfacePaket.showDataPaket();
            modelDataPaket=new TableModelDataPaket(paketArrayList);
            beliCreditForm.getTblKredit().setModel(modelDataPaket);

            beliCreditForm.getJButtonTambah().setEnabled(true);
            beliCreditForm.getJButtonEdit().setEnabled(false);
            beliCreditForm.getJButtonHapus().setEnabled(false);
            beliCreditForm.getJButtonCetak().setEnabled(false);
            
        }
        
        else if(beliCreditForm.getRbPembeli().isSelected())
        {
            beliCreditArrayList.clear();
      
            beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
            modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
            beliCreditForm.getTblKredit().setModel(modelDataBeliCredit);

            beliCreditForm.getJButtonTambah().setEnabled(false);
            beliCreditForm.getJButtonEdit().setEnabled(true);
            beliCreditForm.getJButtonHapus().setEnabled(true);
            beliCreditForm.getJButtonCetak().setEnabled(true);
        }
    }
    
    public boolean validasiPembeli()
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
        int stok=Integer.parseInt(beliCreditForm.getJlabelStok().getText());
        
        if(validasiPembeli())
        {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Biodata Pembeli Secara Lengkap");
        }
        
        else if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Dibeli");
        }
        
        else if(stok==0)
        {
            JOptionPane.showMessageDialog(null, "Stok Motor Habis");
        }
        
        else
        {
            try 
            {
                File reportFile=new File("src/report/NotaCredit.jrxml");
                JasperDesign jDesign=JRXmlLoader.load(reportFile);
                Map formValues=new HashMap();

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date tglSekarang=new Date();
                beliCredit=new BeliCredit();
                strukPaketArrayList=new ArrayList<>();
                strukPaketArrayList=interfacePaket.searchDataPaketByKode(kodePaket);
 
                
                int row=beliCreditForm.getTblKredit().getSelectedRow();
                String noBeli=interfaceBeliCredit.noOtomatis();
                String noKtp=beliCreditForm.getJTextFieldNoKtp().getText().trim();
                String nama=beliCreditForm.getJTextFieldNama().getText().trim();
                String jenisKelamin=beliCreditForm.getCbJenisKelamin().getSelectedItem().toString();
                String alamat=beliCreditForm.getJTextFieldAlamat().getText().trim();
                String noTelp=beliCreditForm.getJTextFieldNoTelp().getText().trim();
                int uangmuka=paketArrayList.get(row).getUangMuka();
                

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
                
                
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                formValues.put("pembeli", nama);
                formValues.put("kodeBeli", interfaceBeliCredit.noOtomatis());
                formValues.put("kodeMotor", beliCreditForm.getJlabelKodeMotor().getText());
                formValues.put("namaMotor", beliCreditForm.getJlabelNamaMotor().getText());
                formValues.put("merkMotor", beliCreditForm.getJlabelMerk().getText());
                formValues.put("warnaMotor", beliCreditForm.getJlabelWarna().getText());
                formValues.put("kodePaket", strukPaketArrayList.get(0).getKodePaket());
                formValues.put("jumlahCicilan", strukPaketArrayList.get(0).getJumlahCicilan());
                formValues.put("nilaiCicilan", strukPaketArrayList.get(0).getNilaiCicilan());
                formValues.put("harga", strukPaketArrayList.get(0).getHarga());
                formValues.put("tglBeli", sdf.format(tglSekarang));
                formValues.put("bunga", strukPaketArrayList.get(0).getBunga()+"%");
                formValues.put("uangMuka", strukPaketArrayList.get(0).getUangMuka());
                formValues.put("hargaTotal", strukPaketArrayList.get(0).getHargaTotal());

                JasperReport jr=JasperCompileManager.compileReport(jDesign);
                JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
                JasperViewer.viewReport(jp,false); 

                
                idPaket="";
                idMotor="";
                kodePaket="";
                
                strukPaketArrayList.clear();
                

            } 
            
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                      
        }
    }
    
    public void updateCredit()
    {
        if(validasiPembeli())
        {
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Data Pembeli");
        }
        
        else
        {
            String kodePaket=beliCreditForm.getJlabelKodePaket().getText();
            
            ArrayList<BeliCredit>arraylistEditBeliCredit;
            ArrayList<Paket>arrayListEditPaket;
            
            arrayListEditPaket=interfacePaket.searchDataPaketByKode(kodePaket);
            Integer stokMotor=arrayListEditPaket.get(0).getStok();
            String idPaketLama=String.valueOf(arrayListEditPaket.get(0).getIdPaket());
            
            arraylistEditBeliCredit=interfaceBeliCredit.searchDataKreditById(idBeli);
            String idPaketBaru=String.valueOf(arraylistEditBeliCredit.get(0).getIdPaket());
            
            if(idBeli.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Yang Akan Diedit");
            }
            
            else if(idPaket.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Silhakan Pilih paket Yang Mau Diubah");
            }
            
            else if(stokMotor==0 && !idPaketBaru.equals(idPaketLama))
            {
                JOptionPane.showMessageDialog(null, "Stok Motor Ini Sudah Habis");
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

                  //interfaceBeliCredit.editData(beliCredit);
                  
                  idPaketBaru="";
                  idPaketLama="";
                  stokMotor=null;
            }
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
        
        if(beliCreditForm.getRbPembeli().isSelected())
        {
            idBeli=String.valueOf(beliCreditArrayList.get(row).getIdBeli());
            idMotor=String.valueOf(beliCreditArrayList.get(row).getIdMotor());
            idPaket=String.valueOf(beliCreditArrayList.get(row).getIdPaket());
            kodePaket=beliCreditArrayList.get(row).getKodePaket();
        
            beliCreditForm.getJTextFieldNoKtp().setText(beliCreditArrayList.get(row).getNoKtp());
            beliCreditForm.getJTextFieldNama().setText(beliCreditArrayList.get(row).getNama());
            beliCreditForm.getCbJenisKelamin().setSelectedItem(beliCreditArrayList.get(row).getJenisKelamin());
            beliCreditForm.getJTextFieldAlamat().setText(beliCreditArrayList.get(row).getAlamat());
            beliCreditForm.getJTextFieldNoTelp().setText(beliCreditArrayList.get(row).getNoTelp());
            
            beliCreditForm.getJlabelKodePaket().setText(beliCreditArrayList.get(row).getKodePaket());
            beliCreditForm.getJlabelKodeMotor().setText(beliCreditArrayList.get(row).getKodeMotor());
            beliCreditForm.getJlabelNamaMotor().setText(beliCreditArrayList.get(row).getNamaMotor());
            beliCreditForm.getJlabelMerk().setText(beliCreditArrayList.get(row).getMerkMotor());
            beliCreditForm.getJlabelWarna().setText(beliCreditArrayList.get(row).getWarna());
            beliCreditForm.getJlabelJumlahCicilan().setText(String.valueOf(beliCreditArrayList.get(row).getJumlahCicilan()));
            beliCreditForm.getJlabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(beliCreditArrayList.get(row).getNilaiCicilan()));
            beliCreditForm.getJlabelBunga().setText(beliCreditArrayList.get(row).getBunga()+"%");
            beliCreditForm.getJLabelUangMuka().setText("Rp."+NumberFormat.getInstance().format(beliCreditArrayList.get(row).getUangMuka()));
            beliCreditForm.getJlabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(beliCreditArrayList.get(row).getHarga()));
            
        }
        
        else if(beliCreditForm.getRbpaket().isSelected())
        {
            idPaket=String.valueOf(paketArrayList.get(row).getIdPaket());
            kodePaket=paketArrayList.get(row).getKodePaket();
            beliCreditForm.getJlabelKodePaket().setText(paketArrayList.get(row).getKodePaket());
            beliCreditForm.getJlabelKodeMotor().setText(paketArrayList.get(row).getKodeMotor());
            beliCreditForm.getJlabelNamaMotor().setText(paketArrayList.get(row).getNamaMotor());
            beliCreditForm.getJlabelMerk().setText(paketArrayList.get(row).getMerkMotor());
            beliCreditForm.getJlabelWarna().setText(paketArrayList.get(row).getWarnaMotor());
            beliCreditForm.getJlabelJumlahCicilan().setText(String.valueOf(paketArrayList.get(row).getJumlahCicilan()));
            beliCreditForm.getJlabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getNilaiCicilan()));
            beliCreditForm.getJlabelBunga().setText(paketArrayList.get(row).getBunga()+"%");
            beliCreditForm.getJlabelStok().setText(String.valueOf(paketArrayList.get(row).getStok()));
            beliCreditForm.getJLabelUangMuka().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getUangMuka()));
            beliCreditForm.getJlabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getHargaTotal()));
        }
        
     
       

        
    }
    
    
    public void cari()
    {
        int indexBerdasarkan=beliCreditForm.getCbBerdasarkan().getSelectedIndex();
        
        String cari=beliCreditForm.getTxtCari().getText().trim();

        if(beliCreditForm.getCbKategori().getSelectedIndex()==0)
        {
            beliCreditForm.getRbPembeli().setSelected(true);
            
            beliCreditArrayList=new ArrayList<>();
            
            
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
                modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
                beliCreditForm.getTblKredit().setModel(modelDataBeliCredit);
            }
        }
        
        else if(beliCreditForm.getCbKategori().getSelectedIndex()==1)
        {
            paketArrayList.clear();
            
            paketArrayList=new ArrayList<>();
                        
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
                modelDataPaket=new TableModelDataPaket(paketArrayList);
                beliCreditForm.getTblKredit().setModel(modelDataPaket);
            }
        }
    }
    
    
    public void cetakStrukBeliCredit()
    {
        try
        {
           if(idBeli.equals(""))
           {
               JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Credit Yang Mau Di Cetak");
           }
           
           else
           {
              int row=beliCreditForm.getTblKredit().getSelectedRow();
            File reportFile=new File("src/report/NotaCredit.jrxml");
            JasperDesign jDesign=JRXmlLoader.load(reportFile);
            Map formValues=new HashMap();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date tglBeli=sdf.parse(beliCreditArrayList.get(row).getTanggal());
            sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

            formValues.put("kodeBeli", beliCreditArrayList.get(row).getNoBeli());
            formValues.put("kodeMotor", beliCreditArrayList.get(row).getKodeMotor());
            formValues.put("namaMotor", beliCreditArrayList.get(row).getNamaMotor());
            formValues.put("merkMotor", beliCreditArrayList.get(row).getMerkMotor());
            formValues.put("warnaMotor", beliCreditArrayList.get(row).getWarna());
            formValues.put("kodePaket", beliCreditArrayList.get(row).getKodePaket());
            formValues.put("jumlahCicilan", beliCreditArrayList.get(row).getJumlahCicilan());
            formValues.put("nilaiCicilan", beliCreditArrayList.get(row).getNilaiCicilan());
            formValues.put("harga", beliCreditArrayList.get(row).getHarga());
            formValues.put("tglBeli", String.valueOf(sdf.format(tglBeli)));
            formValues.put("bunga", beliCreditArrayList.get(row).getBunga()+"%");
            formValues.put("uangMuka", beliCreditArrayList.get(row).getUangMuka());
            formValues.put("hargaTotal", beliCreditArrayList.get(row).getHarga());
            formValues.put("pembeli", beliCreditArrayList.get(row).getNama());

            JasperReport jr=JasperCompileManager.compileReport(jDesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
            JasperViewer.viewReport(jp,false); 

            clearPembeli();
           }
           
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
           
    }
    
    public void clearIdPaket()
    {
        idMotor="";
        idPaket="";
        kodePaket="";
    }
    
    public void clearIdBeli()
    {
       idBeli="";
    }
    
    public void clearPaket()
    {
       
        beliCreditForm.getJlabelKodePaket().setText("...");
        beliCreditForm.getJlabelKodeMotor().setText("...");
        beliCreditForm.getJlabelNamaMotor().setText("...");
        beliCreditForm.getJlabelMerk().setText("...");
        beliCreditForm.getJlabelWarna().setText("...");
        beliCreditForm.getJlabelJumlahCicilan().setText("0");
        beliCreditForm.getJlabelNilaiCicilan().setText("0");
        beliCreditForm.getJlabelBunga().setText("0");
        beliCreditForm.getJLabelUangMuka().setText("0");
        beliCreditForm.getJlabelHargaTotal().setText("0");
        beliCreditForm.getJLabelTotalBunga().setText("0");
        beliCreditForm.getJlabelStok().setText("0");

    }
    
    public void clearPembeli()
    {
        
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
        beliCreditForm.getJlabelJumlahCicilan().setText("0");
        beliCreditForm.getJlabelNilaiCicilan().setText("0");
        beliCreditForm.getJlabelBunga().setText("0");
        beliCreditForm.getJLabelUangMuka().setText("0");
        beliCreditForm.getJlabelHargaTotal().setText("0");
        beliCreditForm.getJLabelTotalBunga().setText("0");
        beliCreditForm.getJlabelStok().setText("0");

    }
    
    
}
