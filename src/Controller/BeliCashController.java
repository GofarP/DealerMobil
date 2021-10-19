/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCashDao;
import Dao.InterfaceBeliCash;
import Dao.MotorDao;
import Form.BeliCashForm;
import Model.BeliCash;
import Model.Motor;
import Table.TableModelDataMotor;
import Table.TableModelDataBeliCash;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Dao.InterfaceMotor;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
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
public class BeliCashController {
    
    BeliCashForm beliCashForm;
    InterfaceBeliCash interfaceBeliCash;
    InterfaceMotor interfaceMotor;
    ArrayList<BeliCash> beliCashArrayList=new ArrayList<>();
    ArrayList<Motor>motorArrayList=new ArrayList<>();
    
    String idMotor="",idBeli="",noBeli="";
    Integer stok;
    
    
    public BeliCashController(BeliCashForm beliCashForm)
    {
        this.beliCashForm=beliCashForm;
        interfaceBeliCash=new BeliCashDao();
        interfaceMotor=new MotorDao();
        beliCashArrayList=interfaceBeliCash.showDataBeli();
        motorArrayList=interfaceMotor.showDataMotor();
    }
    
    public boolean validasiPembeli()
    {        
        boolean kosong=false;
        
        JTextField jtf[]={beliCashForm.getTxtNoKtp(), beliCashForm.getTxtNamaPembeli(),beliCashForm.getTxtalamat(),beliCashForm.getTxtnoTelp()};
        
        for(JTextField jTextField:jtf)
        {
            if(jTextField.getText().trim().equals(""))
            {
                kosong=true;
            }
        }
        
        return kosong;
    }
    
   
    
    public void clearPembeli()
    {
       JTextField jtf[]={beliCashForm.getTxtNoKtp(), beliCashForm.getTxtNamaPembeli(),beliCashForm.getTxtalamat(),beliCashForm.getTxtnoTelp()};
       
       for(JTextField jTextField:jtf)
       {
           jTextField.setText("");
       }
       
       idBeli="";
       
       beliCashForm.getCbJenisKelamin().setSelectedIndex(0);
       beliCashForm.getLblTglBeli().setText("...");
    }
    
    public void clearMotor()
    {
        idMotor="";
        
        
        JLabel jLabel[]={beliCashForm.getLblkodemotor(),beliCashForm.getLblnamamotor(), beliCashForm.getLblmerkmotor(),
            beliCashForm.getLblwarnamotor(),beliCashForm.getLblhargamotor(), beliCashForm.getLblStok()};
        
        for(JLabel jl:jLabel)
        {
            jl.setText("...");
        }
        
       
    }
    
    public void showMotor()
    {
        interfaceMotor=new MotorDao();
        motorArrayList=interfaceMotor.showDataMotor();
        TableModelDataMotor modelDataMotor=new TableModelDataMotor(motorArrayList);
        beliCashForm.getTblBeliCash().setModel(modelDataMotor);
        
        
    }
    
    public void showDataBeli()
    {
        interfaceBeliCash=new BeliCashDao();
        beliCashArrayList=interfaceBeliCash.showDataBeli();
        TableModelDataBeliCash modelDataCash=new TableModelDataBeliCash(beliCashArrayList);
        beliCashForm.getTblBeliCash().setModel(modelDataCash);
        
    }
    
    
    public void cariData()
    {
        
        interfaceBeliCash=new BeliCashDao();
        interfaceMotor=new MotorDao();
        
        String cari=beliCashForm.getTxtCari().getText().trim();
        int index=beliCashForm.getCbberdasarkan().getSelectedIndex();
        TableModelDataBeliCash modelDataCash;
        TableModelDataMotor modelDataMotor;
        
        if(beliCashForm.getCbKategori().getSelectedIndex()==0)
        {
            beliCashForm.getRbDataBeli().setSelected(true);
            
            switch(index)
            {
                case 0:
                  beliCashArrayList=interfaceBeliCash.searchByKode(cari);
                  modelDataCash=new TableModelDataBeliCash(beliCashArrayList);
                  beliCashForm.getTblBeliCash().setModel(modelDataCash);
                  break;
                
                case 1:
                    beliCashArrayList=interfaceBeliCash.searchByName(cari);
                    modelDataCash=new TableModelDataBeliCash(beliCashArrayList);
                    beliCashForm.getTblBeliCash().setModel(modelDataCash);
                    break;
                    
            }
        }
        
        else if(beliCashForm.getCbKategori().getSelectedIndex()==1)
        {
            
            beliCashForm.getRbDataMotor().setSelected(true);
            
            switch(index)
            {
                case 0:
                    motorArrayList=interfaceMotor.searchKodeMotor(cari);
                    modelDataMotor=new TableModelDataMotor(motorArrayList);
                    beliCashForm.getTblBeliCash().setModel(modelDataMotor);
                    break;
                    
                case 1:
                    motorArrayList=interfaceMotor.searchNamaMotor(cari);
                    modelDataMotor=new TableModelDataMotor(motorArrayList);
                    beliCashForm.getTblBeliCash().setModel(modelDataMotor);
                    break;
            }
        }
    }
    
    public void resetTable()
    {
        try 
        {
            if(beliCashForm.getRbDataBeli().isSelected())
            {
                beliCashArrayList=interfaceBeliCash.showDataBeli();
                TableModelDataBeliCash modelDataBeliCash=new TableModelDataBeliCash(beliCashArrayList);
                beliCashForm.getTblBeliCash().setModel(modelDataBeliCash);
            }
            
            else if(beliCashForm.getRbDataMotor().isSelected())
            {
                motorArrayList=interfaceMotor.showDataMotor();
                TableModelDataMotor modelDataMotor=new TableModelDataMotor(motorArrayList);
                beliCashForm.getTblBeliCash().setModel(modelDataMotor);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
  
    
    public void tambahDataBeli()
    {
        try
        {
            stok=Integer.parseInt(beliCashForm.getLblStok().getText());
            
            if(validasiPembeli())
            {
                JOptionPane.showMessageDialog(null, "Silahkan Isi Lengkapi data Pembeli");
            }
            
            else if(idMotor.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Motor Yang Mau Dibeli");
            }
            
            else if(stok==0)
            {
                JOptionPane.showMessageDialog(null, "Stok Motor Sudah Habis");
            }
            
            else
            {
                BeliCash beliCash=new BeliCash();
                Date date=new Date();

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                beliCash.setNoBeli(interfaceBeliCash.autoNumber());
                beliCash.setNoKtp(beliCashForm.getTxtNoKtp().getText().toString());
                beliCash.setNama(beliCashForm.getTxtNamaPembeli().getText().trim());
                beliCash.setJeniKelamin(beliCashForm.getCbJenisKelamin().getSelectedItem().toString());
                beliCash.setAlamat(beliCashForm.getTxtalamat().getText().trim());
                beliCash.setNoTelp(beliCashForm.getTxtnoTelp().getText().trim());
                beliCash.setIdMotor(Integer.parseInt(idMotor));
                beliCash.setStatus("Cash");
                beliCash.setTglBeli(String.valueOf(sdf.format(date)));

                interfaceBeliCash.tambahPembelian(beliCash);
                            
            }
            
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }
    
    
    public void deleteDataBeli()
    {
        if(idBeli.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Beli Yang Mau Dihapus");
        }
        
        else
        {
            int opsi=JOptionPane.showConfirmDialog(null, "Hapus data pembelian ini ?","Hapus Data Pembelian",JOptionPane.YES_NO_OPTION);
        
            if(opsi==JOptionPane.YES_OPTION)interfaceBeliCash.deletePembelian(idBeli,idMotor);
        }
        
    }
    
    
    public void cetakNota()
    {
        try 
        {
            if(idBeli.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Beli Yang Mau DIcetak Notanya");
            }

            else
            {   
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

                    File reportFile=new File("src/report/NotaCash.jrxml");
                    JasperDesign jDesign=JRXmlLoader.load(reportFile);

                    Map formValues=new HashMap();
                    formValues.put("pembeli", beliCashForm.getTxtNamaPembeli().getText().trim());
                    formValues.put("kodeMotor", beliCashForm.getLblkodemotor().getText());
                    formValues.put("merkMotor", beliCashForm.getLblmerkmotor().getText());
                    formValues.put("namaMotor", beliCashForm.getLblnamamotor().getText());
                    formValues.put("merk", beliCashForm.getLblmerkmotor().getText());
                    formValues.put("warna", beliCashForm.getLblwarnamotor().getText());
                    formValues.put("harga", beliCashForm.getLblhargamotor().getText());
                    formValues.put("tglBeli", sdf.format(date));


                    JasperReport jr=JasperCompileManager.compileReport(jDesign);
                    JasperPrint jp = JasperFillManager.fillReport(jr, formValues,new JREmptyDataSource());
                    JasperViewer.viewReport(jp,false);
                    
                    idBeli="";
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    
    
//    public void getRowDataBeli()
//    {
//      
//        int row=beliCashForm.getTblBeliCash().getSelectedRow();
//        idMotor=String.valueOf(beliCashArrayList.get(row).getIdMotor());
//        idBeli=String.valueOf(beliCashArrayList.get(row).getIdBeli());
//        
//        beliCashForm.getLblkodemotor().setText(beliCashArrayList.get(row).getKodeMotor());
//        beliCashForm.getTxtNoKtp().setText(beliCashArrayList.get(row).getNoKtp());
//        beliCashForm.getTxtNamaPembeli().setText(beliCashArrayList.get(row).getNama());
//        beliCashForm.getCbJenisKelamin().setSelectedItem(beliCashArrayList.get(row).getJeniKelamin());
//        beliCashForm.getTxtalamat().setText(beliCashArrayList.get(row).getAlamat());
//        beliCashForm.getTxtNamaPembeli().setText(beliCashArrayList.get(row).getNama());
//        beliCashForm.getTxtnoTelp().setText(beliCashArrayList.get(row).getNoTelp());
//        
//        beliCashForm.getLblkodemotor().setText(beliCashArrayList.get(row).getKodeMotor());
//        beliCashForm.getLblnamamotor().setText(beliCashArrayList.get(row).getNamaMotor());
//        beliCashForm.getLblmerkmotor().setText(beliCashArrayList.get(row).getMerkMotor());
//        beliCashForm.getLblwarnamotor().setText(beliCashArrayList.get(row).getWarnaMotor());        
//        beliCashForm.getLblhargamotor().setText("Rp."+NumberFormat.getInstance().format(beliCashArrayList.get(row).getHargaMotor()));
//        
//        
//    }
    
    
    public void getValueAt()
    {
        int row=beliCashForm.getTblBeliCash().getSelectedRow();
        
        if(beliCashForm.getRbDataMotor().isSelected())
        {
            idMotor=String.valueOf(motorArrayList.get(row).getId());
            beliCashForm.getLblkodemotor().setText(motorArrayList.get(row).getKodeMotor());
            beliCashForm.getLblnamamotor().setText(motorArrayList.get(row).getNama());
            beliCashForm.getLblmerkmotor().setText(motorArrayList.get(row).getMerk());
            beliCashForm.getLblwarnamotor().setText(motorArrayList.get(row).getWarna());        
            beliCashForm.getLblhargamotor().setText("Rp."+NumberFormat.getInstance().format(motorArrayList.get(row).getHarga()));
            beliCashForm.getLblStok().setText(String.valueOf(motorArrayList.get(row).getStok()));
        
        }
        
        else if(beliCashForm.getRbDataBeli().isSelected())
        {
            idBeli=String.valueOf(beliCashArrayList.get(row).getIdBeli());
            idMotor=String.valueOf(beliCashArrayList.get(row).getIdMotor());
            beliCashForm.getLblkodemotor().setText(beliCashArrayList.get(row).getKodeMotor());
            beliCashForm.getLblnamamotor().setText(beliCashArrayList.get(row).getNamaMotor());
            beliCashForm.getLblmerkmotor().setText(beliCashArrayList.get(row).getMerkMotor());
            beliCashForm.getLblwarnamotor().setText(beliCashArrayList.get(row).getWarnaMotor());        
            beliCashForm.getLblhargamotor().setText("Rp."+NumberFormat.getInstance().format(beliCashArrayList.get(row).getHargaMotor()));
            beliCashForm.getLblTglBeli().setText(beliCashArrayList.get(row).getTglBeli());
        }
        
        //stok=motorArrayList.get(row).getStok();
        
    }
    
}


