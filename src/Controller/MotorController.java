/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MotorDao;
import Form.DataMotorForm;
import Model.Motor;
import Table.TableModelDataMotor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Dao.InterfaceMotor;

/**
 *
 * @author LENOVO
 */
public class MotorController {
    
    DataMotorForm dataMotorForm;
    InterfaceMotor interfaceMotor;
    boolean kosong=false;
    ArrayList<Motor>motorArrayList=new ArrayList<>();
    String id="";
    
    
    public MotorController(DataMotorForm dataMobilForm)
    {
        this.dataMotorForm=dataMobilForm;
        interfaceMotor=new MotorDao();
        motorArrayList=interfaceMotor.showDataMotor();
        dataMobilForm.getLblKodeMobil().setText(interfaceMotor.autoNumber());
    }
    
    public String getId()
    {
        return id;
    }
    
    
    
    
    public void clear()
    {
        String noMobil=interfaceMotor.autoNumber();
        id="";
        dataMotorForm.getLblKodeMobil().setText(noMobil);
        dataMotorForm.getTxtNamaMobil().setText("");
        dataMotorForm.getTxtMerkMobil().setText("");
        dataMotorForm.getTxtWarnaMobil().setText("");
        dataMotorForm.getTxtStockMobil().setText("");
        dataMotorForm.getTxtHargaMobil().setText("");
    }
    
    public String autoNumber()
    {
        return interfaceMotor.autoNumber();
    }
    
    
    public boolean validasi()
    {
        JTextField[] jtfMobil={dataMotorForm.getTxtNamaMobil(),dataMotorForm.getTxtMerkMobil(),
            dataMotorForm.getTxtWarnaMobil(), dataMotorForm.getTxtStockMobil(), dataMotorForm.getTxtHargaMobil()};
        
        for(JTextField jtf:jtfMobil)
        {
            if(jtf.getText().trim().equals(""))
            {
                kosong=true;
            }
        }
        
        return kosong;
    
    }
    
    
    public void showDataMotor()
    {
        motorArrayList=interfaceMotor.showDataMotor();
        TableModelDataMotor tableModelDataMobil=new TableModelDataMotor(motorArrayList);
        dataMotorForm.getTable().setModel(tableModelDataMobil);
    }
    
    public void tambahMotor()
    {
       
        Motor mobil=new Motor();
        
        mobil.setKodeMotor(dataMotorForm.getLblKodeMobil().getText().trim());
        mobil.setNama(dataMotorForm.getTxtNamaMobil().getText().trim());
        mobil.setMerk(dataMotorForm.getTxtMerkMobil().getText().trim());
        mobil.setWarna(dataMotorForm.getTxtWarnaMobil().getText().trim());
        mobil.setStok(Integer.parseInt(dataMotorForm.getTxtStockMobil().getText().trim()));
        mobil.setHarga(Integer.parseInt(dataMotorForm.getTxtHargaMobil().getText().trim()));
      
        interfaceMotor.saveDataMotor(mobil);
        
        
    }   
 
    
    public void updateMotor()
    {
        
        Motor mobil=new Motor();
        
        mobil.setKodeMotor(dataMotorForm.getLblKodeMobil().getText().trim());
        mobil.setNama(dataMotorForm.getTxtNamaMobil().getText().trim());
        mobil.setMerk(dataMotorForm.getTxtMerkMobil().getText().trim());
        mobil.setWarna(dataMotorForm.getTxtWarnaMobil().getText().trim());
        mobil.setStok(Integer.parseInt(dataMotorForm.getTxtStockMobil().getText().trim()));
        mobil.setHarga(Integer.parseInt(dataMotorForm.getTxtHargaMobil().getText().trim()));
        mobil.setId(Integer.parseInt(id));
        
        if(validasi())
        {
            JOptionPane.showMessageDialog(null, "Silahkan isi bidang yang kosong");
        }
        
        else if(id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Pilih Motor yang Mau Diubah");
        }
        
        else
        {
            interfaceMotor.updateDataMotor(mobil);
        }
    }
    
    
    
    public void deleteMotor()
    {
        
        if(id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Motor Yang Mau Dihapus");
        }
        
        else
        {
            int opsi=JOptionPane.showConfirmDialog(null, "Hapus data mobil ini ?","Hapus Mobil",JOptionPane.YES_NO_OPTION);
            if(opsi==JOptionPane.YES_OPTION)interfaceMotor.deleteDataMotor(Integer.parseInt(id));
        }
         
        
    }
    
    
    public void cariNamaMobil()
    {
        motorArrayList=interfaceMotor.searchNamaMotor(dataMotorForm.getTxtCari().getText().trim());
        if(motorArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Nama Mobil Tidak Ditemukan");
            motorArrayList=interfaceMotor.showDataMotor();
            TableModelDataMotor tableModelDataMhs=new TableModelDataMotor(motorArrayList);
            dataMotorForm.getTable().setModel(tableModelDataMhs);
        }
        
        else
        {
            TableModelDataMotor tableModelDataMhs=new TableModelDataMotor(motorArrayList);
            dataMotorForm.getTable().setModel(tableModelDataMhs);
        }
        
    }
    
    public void cariMerkMobil()
    {
        motorArrayList=interfaceMotor.searchMerkMotor(dataMotorForm.getTxtCari().getText().trim());
        if(motorArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Merk mobil tidak ditemukan");
            motorArrayList=interfaceMotor.showDataMotor();
            TableModelDataMotor tableModelDataMhs=new TableModelDataMotor(motorArrayList);
            dataMotorForm.getTable().setModel(tableModelDataMhs);
        }
        
        else
        {
            TableModelDataMotor tableModelDataMhs=new TableModelDataMotor(motorArrayList);
            dataMotorForm.getTable().setModel(tableModelDataMhs);
        }
        
    }
    
    public void getRowData()
    {
         int row=dataMotorForm.getTable().getSelectedRow();
         
         id=String.valueOf(motorArrayList.get(row).getId());
         dataMotorForm.getLblKodeMobil().setText(motorArrayList.get(row).getKodeMotor());
         dataMotorForm.getTxtNamaMobil().setText(motorArrayList.get(row).getNama());
         dataMotorForm.getTxtMerkMobil().setText(motorArrayList.get(row).getMerk());
         dataMotorForm.getTxtWarnaMobil().setText(motorArrayList.get(row).getWarna());
         dataMotorForm.getTxtStockMobil().setText(String.valueOf(motorArrayList.get(row).getStok()));
         dataMotorForm.getTxtHargaMobil().setText(String.valueOf(motorArrayList.get(row).getHarga()));
     
    }
    
}
