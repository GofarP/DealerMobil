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
    Motor motor=new Motor();
    
    
    public MotorController(DataMotorForm dataMotorForm)
    {
        this.dataMotorForm=dataMotorForm;
        interfaceMotor=new MotorDao();
        motorArrayList=interfaceMotor.showDataMotor();
        dataMotorForm.getLblKodeMobil().setText(interfaceMotor.autoNumber());
    }
    
    public String getId()
    {
        return id;
    }
    
    public void showDataMotor()
    {
        motorArrayList=interfaceMotor.showDataMotor();
        TableModelDataMotor tableModelDataMobil=new TableModelDataMotor(motorArrayList);
        dataMotorForm.getTable().setModel(tableModelDataMobil);
    }
    
    public void tambahMotor()
    {
       
        
        motor.setKodeMotor(dataMotorForm.getLblKodeMobil().getText().trim());
        motor.setNama(dataMotorForm.getTxtNamaMobil().getText().trim());
        motor.setMerk(dataMotorForm.getTxtMerkMobil().getText().trim());
        motor.setWarna(dataMotorForm.getTxtWarnaMobil().getText().trim());
        motor.setStok(Integer.parseInt(dataMotorForm.getTxtStockMobil().getText().trim()));
        motor.setHarga(Integer.parseInt(dataMotorForm.getTxtHargaMobil().getText().trim()));
      
        interfaceMotor.saveDataMotor(motor);
        
        
    }   
 
    
    public void updateMotor()
    {
        
        
        motor.setKodeMotor(dataMotorForm.getLblKodeMobil().getText().trim());
        motor.setNama(dataMotorForm.getTxtNamaMobil().getText().trim());
        motor.setMerk(dataMotorForm.getTxtMerkMobil().getText().trim());
        motor.setWarna(dataMotorForm.getTxtWarnaMobil().getText().trim());
        motor.setStok(Integer.parseInt(dataMotorForm.getTxtStockMobil().getText().trim()));
        motor.setHarga(Integer.parseInt(dataMotorForm.getTxtHargaMobil().getText().trim()));
        motor.setId(Integer.parseInt(id));
        
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
            interfaceMotor.updateDataMotor(motor);
        }
    }
    
    
    
    public void deleteMotor()
    {
        
        if(id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Motor Yang Mau Dihapus");
        }
        
        else if(interfaceMotor.cekMotor(Integer.parseInt(id)))
        {
            JOptionPane.showMessageDialog(null, "Motor Tidak Bisa Dihapus, masih ada pembelian credit yang masih berjalan");
        }
        
        else
        {
            int opsi=JOptionPane.showConfirmDialog(null, "Hapus data motor ini ?","Hapus Motor",JOptionPane.YES_NO_OPTION);
            if(opsi==JOptionPane.YES_OPTION)interfaceMotor.deleteDataMotor(Integer.parseInt(id));
        }
         
        
    }
    
    
    public void cariNamaMotor()
    {
        motorArrayList=interfaceMotor.searchNamaMotor(dataMotorForm.getTxtCari().getText().trim());
        
        if(motorArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Nama Motor Tidak Ditemukan");
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
    
    public void cariMerkMotor()
    {
        motorArrayList=interfaceMotor.searchMerkMotor(dataMotorForm.getTxtCari().getText().trim());
        if(motorArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Merk motor tidak ditemukan");
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
            
            else 
            {
                kosong=false;
            }
        }
        
        
        return kosong;
    
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
