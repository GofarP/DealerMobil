/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.InterfaceMobil;
import Dao.MobilDao;
import Form.DataMobilForm;
import Model.Mobil;
import Table.TableModelDataMobil;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class MobilController {
    
    DataMobilForm dataMobilForm;
    InterfaceMobil interfaceMobil;
    boolean kosong=false;
    ArrayList<Mobil>mobilArrayList=new ArrayList<>();
    String id="";
    
    
    public MobilController(DataMobilForm dataMobilForm)
    {
        this.dataMobilForm=dataMobilForm;
        interfaceMobil=new MobilDao();
        mobilArrayList=interfaceMobil.showDataMobil();
    }
    
    public String getId()
    {
        return id;
    }
    
    
    public void getProperty()
    {
        Mobil mobil=new Mobil();
        mobil.setKodeMobil(dataMobilForm.getLblKodeMobil().getText().trim());
        mobil.setNama(dataMobilForm.getTxtNamaMobil().getText().trim());
        mobil.setMerk(dataMobilForm.getTxtMerkMobil().getText().trim());
        mobil.setWarna(dataMobilForm.getTxtWarnaMobil().getText().trim());
        mobil.setStok(Integer.parseInt(dataMobilForm.getTxtStockMobil().getText().trim()));
        mobil.setHarga(Integer.parseInt(dataMobilForm.getTxtHargaMobil().getText().trim()));
    }
    
    public void clear()
    {
        String noMobil=interfaceMobil.autoNumber();
        id="";
        dataMobilForm.getLblKodeMobil().setText(noMobil);
        dataMobilForm.getTxtNamaMobil().setText("");
        dataMobilForm.getTxtMerkMobil().setText("");
        dataMobilForm.getTxtWarnaMobil().setText("");
        dataMobilForm.getTxtStockMobil().setText("");
        dataMobilForm.getTxtHargaMobil().setText("");
    }
    
    public String autoNumber()
    {
        return interfaceMobil.autoNumber();
    }
    
    
    public boolean validasi()
    {
        JTextField[] jtfMobil={dataMobilForm.getTxtNamaMobil(),dataMobilForm.getTxtMerkMobil(),
            dataMobilForm.getTxtWarnaMobil(), dataMobilForm.getTxtStockMobil(), dataMobilForm.getTxtHargaMobil()};
        
        for(JTextField jtf:jtfMobil)
        {
            if(jtf.getText().toString().trim().equals(""))
            {
                kosong=true;
            }
        }
        
        return kosong;
    
    }
    
    
    public void showDataMobil()
    {
        mobilArrayList=interfaceMobil.showDataMobil();
        TableModelDataMobil tableModelDataMobil=new TableModelDataMobil(mobilArrayList);
        dataMobilForm.getTable().setModel(tableModelDataMobil);
    }
    
    public void tambahMobil()
    {
       
        Mobil mobil=new Mobil();
        
        mobil.setKodeMobil(dataMobilForm.getLblKodeMobil().getText().trim());
        mobil.setNama(dataMobilForm.getTxtNamaMobil().getText().trim());
        mobil.setMerk(dataMobilForm.getTxtMerkMobil().getText().trim());
        mobil.setWarna(dataMobilForm.getTxtWarnaMobil().getText().trim());
        mobil.setStok(Integer.parseInt(dataMobilForm.getTxtStockMobil().getText().trim()));
        mobil.setHarga(Integer.parseInt(dataMobilForm.getTxtHargaMobil().getText().trim()));
      
        interfaceMobil.saveDataMobil(mobil);
        
        
    }   
 
    
    public void updateMobil()
    {
        
        Mobil mobil=new Mobil();
        mobil.setKodeMobil(dataMobilForm.getLblKodeMobil().getText().trim());
        mobil.setNama(dataMobilForm.getTxtNamaMobil().getText().trim());
        mobil.setMerk(dataMobilForm.getTxtMerkMobil().getText().trim());
        mobil.setWarna(dataMobilForm.getTxtWarnaMobil().getText().trim());
        mobil.setStok(Integer.parseInt(dataMobilForm.getTxtStockMobil().getText().trim()));
        mobil.setHarga(Integer.parseInt(dataMobilForm.getTxtHargaMobil().getText().trim()));
        mobil.setId(Integer.parseInt(id));
        
        if(validasi())
        {
            JOptionPane.showMessageDialog(null, "Silahkan isi bidang yang kosong");
        }
        
        else
        {
            interfaceMobil.updateDataMobil(mobil);
        }
    }
    
    
    
    public void deleteMobil()
    {
         
        int opsi=JOptionPane.showConfirmDialog(null, "Hapus data mobil ini ?","Hapus Mobil",JOptionPane.YES_NO_OPTION);
        if(opsi==JOptionPane.YES_OPTION)interfaceMobil.deleteDataMobil(Integer.parseInt(id));
    }
    
    
    public void cariNamaMobil()
    {
        mobilArrayList=interfaceMobil.searchNamaMobil(dataMobilForm.getTxtCari().getText().trim());
        if(mobilArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Nama Mobil Tidak Ditemukan");
            mobilArrayList=interfaceMobil.showDataMobil();
            TableModelDataMobil tableModelDataMhs=new TableModelDataMobil(mobilArrayList);
            dataMobilForm.getTable().setModel(tableModelDataMhs);
        }
        
        else
        {
            TableModelDataMobil tableModelDataMhs=new TableModelDataMobil(mobilArrayList);
            dataMobilForm.getTable().setModel(tableModelDataMhs);
        }
        
    }
    
    public void cariMerkMobil()
    {
        mobilArrayList=interfaceMobil.searchMerkMobil(dataMobilForm.getTxtCari().getText().trim());
        if(mobilArrayList.size()==0)
        {
            JOptionPane.showMessageDialog(null, "Merk mobil tidak ditemukan");
            mobilArrayList=interfaceMobil.showDataMobil();
            TableModelDataMobil tableModelDataMhs=new TableModelDataMobil(mobilArrayList);
            dataMobilForm.getTable().setModel(tableModelDataMhs);
        }
        
        else
        {
            TableModelDataMobil tableModelDataMhs=new TableModelDataMobil(mobilArrayList);
            dataMobilForm.getTable().setModel(tableModelDataMhs);
        }
        
    }
    
    public void getRowData()
    {
         int row=dataMobilForm.getTable().getSelectedRow();
         
         id=String.valueOf(mobilArrayList.get(row).getId());
         dataMobilForm.getLblKodeMobil().setText(mobilArrayList.get(row).getKodeMobil());
         dataMobilForm.getTxtNamaMobil().setText(mobilArrayList.get(row).getNama());
         dataMobilForm.getTxtMerkMobil().setText(mobilArrayList.get(row).getMerk());
         dataMobilForm.getTxtWarnaMobil().setText(mobilArrayList.get(row).getWarna());
         dataMobilForm.getTxtStockMobil().setText(String.valueOf(mobilArrayList.get(row).getStok()));
         dataMobilForm.getTxtHargaMobil().setText(String.valueOf(mobilArrayList.get(row).getHarga()));
     
    }
    
}
