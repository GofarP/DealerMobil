/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCashDao;
import Dao.InterfaceBeliCash;
import Dao.InterfaceMobil;
import Dao.MobilDao;
import Form.BeliCashForm;
import Model.BeliCash;
import Model.Mobil;
import Table.TableModelDataMobil;
import Table.TableModelDataBeliCash;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class BeliCashController {
    
    BeliCashForm beliCashForm;
    InterfaceBeliCash interfaceBeliCash;
    InterfaceMobil interfaceMobil;
    boolean kosong=false;
    ArrayList<BeliCash> beliCashArrayList;
    ArrayList<Mobil>mobilArrayList;
    
    String idMobil="",idBeli="",noBeli="";
    
   
   
    
    public BeliCashController(BeliCashForm beliCashForm)
    {
        this.beliCashForm=beliCashForm;
        interfaceBeliCash=new BeliCashDao();
        beliCashArrayList=interfaceBeliCash.showDataBeli();
    }
    
    public boolean validasiPembeli()
    {
        boolean kosong=false;
        
        JTextField jtf[]={beliCashForm.getTxtNoKtp(), beliCashForm.getTxtNamaPembeli(),beliCashForm.getTxtalamat(),beliCashForm.getTxtnoTelp()};
        
        for(JTextField jTextField:jtf)
        {
            if(jTextField.getText().trim().toString().equals("")) kosong=true;
        }
        
        return kosong;
    }
    
    public boolean validasiBeliMobil()
    {
        boolean kosong=false;
        
        if(idMobil.equals("")) kosong=true;
        
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
    }
    
    public void clearMobil()
    {
        JLabel jLabel[]={beliCashForm.getLblkodemobil(),beliCashForm.getLblnamamobil(), beliCashForm.getLblmerkmobil(),beliCashForm.getLblwarnamobil(),beliCashForm.getLblhargamobil()};
        
        for(JLabel jl:jLabel)
        {
            jl.setText("...");
        }
    }
    
    public void showMobil()
    {
        interfaceMobil=new MobilDao();
        mobilArrayList=interfaceMobil.showDataMobil();
        TableModelDataMobil modelDataMobil=new TableModelDataMobil(mobilArrayList);
        beliCashForm.getTblBeliCash().setModel(modelDataMobil);
        
    }
    
    public void showDataBeli()
    {
        interfaceBeliCash=new BeliCashDao();
        beliCashArrayList=interfaceBeliCash.showDataBeli();
        TableModelDataBeliCash modelDataCash=new TableModelDataBeliCash(beliCashArrayList);
        beliCashForm.getTblBeliCash().setModel(modelDataCash);
    }
    
    
    
    public void tambahDataBeli()
    {
        try
        {
            if(validasiPembeli())
            {
                JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Data Pelanggan");
            }
            else if(validasiBeliMobil())
            {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Mobil Yang Mau Dibeli");
            }
            
            else
            {
                BeliCash beliCash=new BeliCash();
                Date date=new Date();

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate=sdf.format(date);

                beliCash.setNoBeli(interfaceBeliCash.autoNumber());
                beliCash.setNoKtp(beliCashForm.getTxtNoKtp().getText().trim());
                beliCash.setNama(beliCashForm.getTxtNamaPembeli().getText().trim());
                beliCash.setJeniKelamin(beliCashForm.getCbJenisKelamin().getSelectedItem().toString());
                beliCash.setAlamat(beliCashForm.getTxtalamat().getText().trim());
                beliCash.setNoTelp(beliCashForm.getTxtnoTelp().getText().trim());
                beliCash.setIdMobil(Integer.parseInt(idMobil));
                beliCash.setStatus("Cash");
                beliCash.setTglbayar(sdf.parse(formattedDate));

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
        
            if(opsi==JOptionPane.YES_OPTION)interfaceBeliCash.deletePembelian(idMobil);
        }
        
    }
    
    
    public void getRowDataBeli()
    {
        int row=beliCashForm.getTblBeliCash().getSelectedRow();
        idMobil=String.valueOf(beliCashArrayList.get(row).getIdMobil());
        idBeli=String.valueOf(beliCashArrayList.get(row).getIdBeli());
        beliCashForm.getTxtNoKtp().setText(beliCashArrayList.get(row).getNoKtp());
        beliCashForm.getTxtNamaPembeli().setText(beliCashArrayList.get(row).getNama());
        beliCashForm.getCbJenisKelamin().setSelectedItem(beliCashArrayList.get(row).getJeniKelamin());
        beliCashForm.getTxtalamat().setText(beliCashArrayList.get(row).getAlamat());
        beliCashForm.getTxtNamaPembeli().setText(beliCashArrayList.get(row).getNama());
        beliCashForm.getTxtalamat().setText(beliCashArrayList.get(row).getAlamat());
        
        beliCashForm.getLblkodemobil().setText(beliCashArrayList.get(row).getKodeMobil());
        beliCashForm.getLblnamamobil().setText(beliCashArrayList.get(row).getNamaMobil());
        beliCashForm.getLblmerkmobil().setText(beliCashArrayList.get(row).getMerkMobil());
        beliCashForm.getLblwarnamobil().setText(beliCashArrayList.get(row).getWarnaMobil());        
        beliCashForm.getLblhargamobil().setText(String.valueOf(beliCashArrayList.get(row).getHargaMobil()));
    }
    
    
    public void getRowDataMobil()
    {
        int row=beliCashForm.getTblBeliCash().getSelectedRow();
         
        beliCashForm.getLblkodemobil().setText(beliCashArrayList.get(row).getKodeMobil());
        beliCashForm.getLblnamamobil().setText(beliCashArrayList.get(row).getNamaMobil());
        beliCashForm.getLblmerkmobil().setText(beliCashArrayList.get(row).getMerkMobil());
        beliCashForm.getLblwarnamobil().setText(beliCashArrayList.get(row).getWarnaMobil());        
        beliCashForm.getLblhargamobil().setText(String.valueOf(beliCashArrayList.get(row).getHargaMobil()));
    }
    
}


