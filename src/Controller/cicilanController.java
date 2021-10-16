/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCreditDao;
import Dao.CicilanDao;
import Dao.InterfaceBeliCredit;
import Dao.InterfaceCicilan;
import Form.BayarCicilanForm;
import Model.BeliCredit;
import Model.Cicilan;
import Table.TableModelDataBeliCredit;
import Table.TableModelDataCicilan;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
public class cicilanController {
    
    
    BayarCicilanForm bayarCicilanForm;
    ArrayList<BeliCredit> beliCreditArrayList;
    ArrayList<Cicilan> cicilanArrayList;
    ArrayList<Cicilan>strukCicilanArrayList;
    InterfaceBeliCredit interfaceBeliCredit;
    InterfaceCicilan interfaceCicilan;
    
    Cicilan cicilan=new Cicilan();
    
    String idBeli="", idCicilan="";
    
    public cicilanController(BayarCicilanForm bayarCicilanForm)
    {
        this.bayarCicilanForm=bayarCicilanForm;
        
        interfaceBeliCredit=new BeliCreditDao();
        interfaceCicilan=new CicilanDao();
        
        beliCreditArrayList=new ArrayList<>();
        cicilanArrayList=new ArrayList<>();
        
        beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
        cicilanArrayList=interfaceCicilan.showDataCicilan();
    }
    
    
    public void showBeliCredit()
    {
        bayarCicilanForm.getJButtonTambah().setEnabled(true);
        bayarCicilanForm.getJButtonHapus().setEnabled(false);
        bayarCicilanForm.getJButtonCetak().setEnabled(false);
        
        beliCreditArrayList.clear();
        
        beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
        TableModelDataBeliCredit modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
        bayarCicilanForm.getTblCicilan().setModel(modelDataBeliCredit);
    }
    
    public void showDataCicilan()
    {
        bayarCicilanForm.getJButtonTambah().setEnabled(false);
        bayarCicilanForm.getJButtonHapus().setEnabled(true);
        bayarCicilanForm.getJButtonCetak().setEnabled(true);
        
        cicilanArrayList.clear();
        
        cicilanArrayList=interfaceCicilan.showDataCicilan();
        TableModelDataCicilan modelDataCicilan=new TableModelDataCicilan(cicilanArrayList);
        bayarCicilanForm.getTblCicilan().setModel(modelDataCicilan);
        
    }
    
    public void resetTable()
    {
        if(bayarCicilanForm.getRbDataCicilan().isSelected())
        {
            bayarCicilanForm.getJButtonTambah().setEnabled(false);
            bayarCicilanForm.getJButtonHapus().setEnabled(true);
            bayarCicilanForm.getJButtonCetak().setEnabled(true);

            cicilanArrayList.clear();

            cicilanArrayList=interfaceCicilan.showDataCicilan();
            TableModelDataCicilan modelDataCicilan=new TableModelDataCicilan(cicilanArrayList);
            bayarCicilanForm.getTblCicilan().setModel(modelDataCicilan);
        }
        
        else if(bayarCicilanForm.getRbDataBeli().isSelected())
        {
            bayarCicilanForm.getJButtonTambah().setEnabled(true);
            bayarCicilanForm.getJButtonHapus().setEnabled(false);
            bayarCicilanForm.getJButtonCetak().setEnabled(false);

            beliCreditArrayList.clear();

            beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
            TableModelDataBeliCredit modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
            bayarCicilanForm.getTblCicilan().setModel(modelDataBeliCredit);
        }
    }
    
    public void bayarCicilan()
    {
        if(idBeli.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Pilih bayar cicilan yang mau dibayar");
        }
        
        else if(interfaceCicilan.cekCicilan(Integer.parseInt(idBeli)))
        {
            JOptionPane.showMessageDialog(null, "Pembayaran Sudah Lunas Untuk Cicilan Ini");
        }
        
        else
        {
            try 
            {
                Calendar tglSkrg=Calendar.getInstance();
                Calendar tglCicilTerakhir=Calendar.getInstance();
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                int row=bayarCicilanForm.getTblCicilan().getSelectedRow();
                
                String kodeCicilan=interfaceCicilan.autoNumber();
                int idBeli=beliCreditArrayList.get(row).getIdBeli();
                int idPaket=beliCreditArrayList.get(row).getIdPaket();
                int jumlahBayar=beliCreditArrayList.get(row).getNilaiCicilan();
                String noBeli=beliCreditArrayList.get(row).getNoBeli();
                String status="";
                int cicilanKe=1;
                int denda=2000;
                int totalDenda=0;
                
                strukCicilanArrayList=interfaceCicilan.cariDataById(String.valueOf(idBeli));
                
                if(strukCicilanArrayList.size()>0)
                {
                    
                    cicilanKe=strukCicilanArrayList.get(0).getCicilanKe()+1;
                    tglCicilTerakhir.setTime(sdf.parse(strukCicilanArrayList.get(0).getTglCicil()));
                    
                    long bedaHari=Duration.between(tglCicilTerakhir.toInstant(), tglSkrg.toInstant()).toDays();
                    
                    if(bedaHari>30)
                    {
                        status="telat";
                        totalDenda=(int) (denda*bedaHari);
                        jumlahBayar=jumlahBayar+totalDenda;
                    }
                    
                    else
                    {
                        status="tepat";
                    }
                    
                }
                
                else
                {
                    status="tepat";
                }

                cicilan=new Cicilan();

                cicilan.setKodeCicilan(kodeCicilan);
                cicilan.setIdBeli(idBeli);
                cicilan.setIdPaket(idPaket);
                cicilan.setJumlahBayar(jumlahBayar);
                cicilan.setCicilanKe(cicilanKe);
                cicilan.setStatus(status);
                cicilan.setTglCicil(sdf.format(tglSkrg.getTime()));

                interfaceCicilan.bayarCicilan(cicilan);
                
                
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                File reportFile=new File("src/report/StrukCicilan.jrxml");
                JasperDesign jDesign=JRXmlLoader.load(reportFile);
                Map formValues=new HashMap();

                formValues.put("noBeli", noBeli);
                formValues.put("noCicilan", kodeCicilan);
                formValues.put("kodeMotor", beliCreditArrayList.get(row).getKodeMotor());
                formValues.put("namaMotor", beliCreditArrayList.get(row).getNamaMotor());
                formValues.put("merkMotor", beliCreditArrayList.get(row).getMerkMotor());
                formValues.put("warna", beliCreditArrayList.get(row).getWarna());
                formValues.put("jmlBayar", jumlahBayar);
                formValues.put("status", status);
                formValues.put("cicilanKe", cicilanKe);
                formValues.put("tglCicil", sdf.format(tglSkrg.getTime()));
                formValues.put("pembeli", bayarCicilanForm.getJLabelNama().getText());
                formValues.put("denda", totalDenda);

                JasperReport jr=JasperCompileManager.compileReport(jDesign);
                JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
                JasperViewer.viewReport(jp,false);


                clear();
            } 
            
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
        }
    }
    
    public void hapusCicilan()
    {
        if(idCicilan.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan pilih cicilan yang mau dihapus");
        }
        
        else
        {
            int opsi=JOptionPane.showConfirmDialog(null, "Hapus data cicilan ini ?","Hapus Data Cicilan",JOptionPane.YES_NO_OPTION);
            
            if(opsi==JOptionPane.YES_OPTION)
            {
                interfaceCicilan.hapusCicilan(Integer.parseInt(idCicilan));
                interfaceCicilan.updateStatus(idBeli);
            }
        }
    }
    
    public void cetakStruk()
    {
        if(idCicilan.equals(""))
        {
            JOptionPane.showMessageDialog(null, "silahkan pilih cicilan yang mau dicetak");
        }
        
        else
        {
            try 
            {
                int row=bayarCicilanForm.getTblCicilan().getSelectedRow();
                File reportFile=new File("src/report/StrukCicilan.jrxml");
                JasperDesign jDesign=JRXmlLoader.load(reportFile);
                Map formValues=new HashMap();
                
                formValues.put("noBeli", cicilanArrayList.get(row).getNoBeli());
                formValues.put("noCicilan", cicilanArrayList.get(row).getKodeCicilan());
                formValues.put("kodeMotor", cicilanArrayList.get(row).getKodeMotor());
                formValues.put("namaMotor", cicilanArrayList.get(row).getNamaMotor());
                formValues.put("merkMotor", cicilanArrayList.get(row).getMerkMotor());
                formValues.put("warna", cicilanArrayList.get(row).getWarnaMotor());
                formValues.put("jmlBayar", cicilanArrayList.get(row).getJumlahBayar());
                formValues.put("status", cicilanArrayList.get(row).getStatus());
                formValues.put("cicilanKe", String.valueOf(cicilanArrayList.get(row).getCicilanKe()));
                formValues.put("tglCicil", cicilanArrayList.get(row).getTglCicil());
                formValues.put("pembeli", cicilanArrayList.get(row).getNama());
                
                JasperReport jr=JasperCompileManager.compileReport(jDesign);
                JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
                JasperViewer.viewReport(jp,false);
                    
                idBeli="";
                
            } 
            
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
        }
    }
    
    
    public void getValueAt()
    {
        int row=bayarCicilanForm.getTblCicilan().getSelectedRow();
        
        if(bayarCicilanForm.getRbDataBeli().isSelected())
        {
            idBeli=String.valueOf(beliCreditArrayList.get(row).getIdBeli());
            
            bayarCicilanForm.getJLabelNoKtp().setText(beliCreditArrayList.get(row).getNoKtp());
            bayarCicilanForm.getJLabelNama().setText(beliCreditArrayList.get(row).getNama());
            bayarCicilanForm.getJLabelJenisKelamin().setText(beliCreditArrayList.get(row).getJenisKelamin());
            bayarCicilanForm.getJLabelAlamat().setText(beliCreditArrayList.get(row).getAlamat());
            bayarCicilanForm.getJLabelNoTelp().setText(beliCreditArrayList.get(row).getNoTelp());
            
            bayarCicilanForm.getJLabelNoKtp().setText(beliCreditArrayList.get(row).getNoKtp());
            bayarCicilanForm.getJLabelNama().setText(beliCreditArrayList.get(row).getNama());
            bayarCicilanForm.getJLabelJenisKelamin().setText(beliCreditArrayList.get(row).getJenisKelamin());
            bayarCicilanForm.getJLabelAlamat().setText(beliCreditArrayList.get(row).getAlamat());
            bayarCicilanForm.getJLabelNoTelp().setText(beliCreditArrayList.get(row).getNoTelp());
            
            bayarCicilanForm.getJLabelKodeMotor().setText(beliCreditArrayList.get(row).getKodeMotor());
            bayarCicilanForm.getJLabelNamaMotor().setText(beliCreditArrayList.get(row).getNamaMotor());
            bayarCicilanForm.getJLabelMerk().setText(beliCreditArrayList.get(row).getMerkMotor());
            bayarCicilanForm.getJLabelWarna().setText(beliCreditArrayList.get(row).getWarna());
            
        }
        
        else if(bayarCicilanForm.getRbDataCicilan().isSelected())
        {
            idCicilan=String.valueOf(cicilanArrayList.get(row).getIdCicilan());
            
            bayarCicilanForm.getJLabelNoKtp().setText(cicilanArrayList.get(row).getNoKtp());
            bayarCicilanForm.getJLabelNama().setText(cicilanArrayList.get(row).getNama());
            bayarCicilanForm.getJLabelJenisKelamin().setText(cicilanArrayList.get(row).getJenisKelamin());
            bayarCicilanForm.getJLabelAlamat().setText(cicilanArrayList.get(row).getAlamat());
            bayarCicilanForm.getJLabelNoTelp().setText(cicilanArrayList.get(row).getNoTelp());
            
            bayarCicilanForm.getJLabelCicilanKe().setText(String.valueOf(cicilanArrayList.get(row).getCicilanKe()));
            bayarCicilanForm.getJLabelKodeCicilan().setText(cicilanArrayList.get(row).getKodeCicilan());
            bayarCicilanForm.getJLabelKodeMotor().setText(cicilanArrayList.get(row).getKodeMotor());
            bayarCicilanForm.getJLabelNamaMotor().setText(cicilanArrayList.get(row).getNamaMotor());
            bayarCicilanForm.getJLabelMerk().setText(cicilanArrayList.get(row).getMerkMotor());
            bayarCicilanForm.getJLabelWarna().setText(cicilanArrayList.get(row).getWarnaMotor());
            bayarCicilanForm.getJLabelKodePaket().setText(cicilanArrayList.get(row).getKodePaket());
            bayarCicilanForm.getJLabelJmlCicilan().setText(String.valueOf(cicilanArrayList.get(row).getJumlahCicilan()));
            bayarCicilanForm.getJLabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(cicilanArrayList.get(row).getNilaiCicilan()));
            bayarCicilanForm.getJLabelBunga().setText(cicilanArrayList.get(row).getBunga()+" %");
            bayarCicilanForm.getJLabelUangMuka().setText("Rp."+NumberFormat.getInstance().format(cicilanArrayList.get(row).getUangMuka()));
            bayarCicilanForm.getJLabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(cicilanArrayList.get(row).getHargaTotal()));
        
        }
        
            
    }
    
    public void cariData()
    {
        int kategori=bayarCicilanForm.cbKategori().getSelectedIndex();
        int berdasarkan=bayarCicilanForm.cbBerdasarkan().getSelectedIndex();
        
        String cari=bayarCicilanForm.getJTextFieldCari().getText().trim();
        TableModelDataCicilan tableModelDataCicilan;
        TableModelDataBeliCredit tableModelDataBeliCredit;
        
        if(kategori==0)
        {
            bayarCicilanForm.getRbDataCicilan().setSelected(true);
            
            
            switch(berdasarkan)
            {
                case 0:
                    cicilanArrayList.clear();
                    cicilanArrayList=interfaceCicilan.cariDatByNama(cari);
                    break;
                    
                case 1:
                    cicilanArrayList.clear();
                    cicilanArrayList=interfaceCicilan.cariDataByKode(cari);
                    break;
            }
            
            if(cicilanArrayList.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
            
            else
            {
                bayarCicilanForm.getTblCicilan().remove(0);
                tableModelDataCicilan=new TableModelDataCicilan(cicilanArrayList);
                bayarCicilanForm.getTblCicilan().setModel(tableModelDataCicilan);
            }
        }
        
        else if(kategori==1)
        {
            bayarCicilanForm.getRbDataBeli().setSelected(true);
            
            switch(berdasarkan)
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
                JOptionPane.showMessageDialog(null, "data tidak ditemukan");
            }
            
            else
            {
                bayarCicilanForm.getTblCicilan().remove(0);
                tableModelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
                bayarCicilanForm.getTblCicilan().setModel(tableModelDataBeliCredit);
            }
        }
    }
    
    
    public void clear()
    {
            idCicilan="";
            idBeli="";

            bayarCicilanForm.getJLabelNoKtp().setText("");
            bayarCicilanForm.getJLabelNama().setText("");
            bayarCicilanForm.getJLabelJenisKelamin().setText("");
            bayarCicilanForm.getJLabelAlamat().setText("");
            bayarCicilanForm.getJLabelNoTelp().setText("");

            bayarCicilanForm.getJLabelNoKtp().setText("...");
            bayarCicilanForm.getJLabelNama().setText("...");
            bayarCicilanForm.getJLabelJenisKelamin().setText("...");
            bayarCicilanForm.getJLabelAlamat().setText("...");
            bayarCicilanForm.getJLabelNoTelp().setText("...");
            
            bayarCicilanForm.getJLabelCicilanKe().setText("...");
            bayarCicilanForm.getJLabelKodeCicilan().setText("...");
            bayarCicilanForm.getJLabelKodeMotor().setText("...");
            bayarCicilanForm.getJLabelNamaMotor().setText("...");
            bayarCicilanForm.getJLabelMerk().setText("...");
            bayarCicilanForm.getJLabelWarna().setText("...");
            bayarCicilanForm.getJLabelKodePaket().setText("...");
            bayarCicilanForm.getJLabelJmlCicilan().setText("...");
            bayarCicilanForm.getJLabelNilaiCicilan().setText("...");
            bayarCicilanForm.getJLabelBunga().setText("...");
            bayarCicilanForm.getJLabelUangMuka().setText("...");
            bayarCicilanForm.getJLabelHargaTotal().setText("...");
        
    }
    
}
