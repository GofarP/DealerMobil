/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.InterfacePaket;
import Dao.MotorDao;
import Dao.PaketDao;
import Form.PaketCreditForm;
import Model.Motor;
import Model.Paket;
import Table.TableModelDataMotor;
import Table.TableModelDataPaket;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Dao.InterfaceMotor;

/**
 *
 * @author LENOVO
 */
public class PaketController {
    
    PaketCreditForm paketCreditForm;
    InterfacePaket interfacePaket;
    InterfaceMotor interfaceMotor;
    ArrayList<Paket>paketArrayList;
    ArrayList<Motor>motorArrayList;
    String idMotor="", idPaket="";
    
    public PaketController(PaketCreditForm paketCreditForm)
    {
        this.paketCreditForm=paketCreditForm;
        interfacePaket=new PaketDao();
        interfaceMotor=new MotorDao();
        
        motorArrayList=interfaceMotor.showDataMotor();
        paketArrayList=interfacePaket.showDataPaket();
        paketCreditForm.getJlabelKodePaket().setText(interfacePaket.autoNumber());
        
    }
    

    public void showDataPaket()
    {
        idMotor="";
        TableModelDataPaket tabelModelDataPaket=new TableModelDataPaket(paketArrayList);
        paketCreditForm.getTblPaket().setModel(tabelModelDataPaket);
    }
    
    
    public void showDataMotor()
    {
        idMotor="";
        TableModelDataMotor tableModelDataMotor=new TableModelDataMotor(motorArrayList);
        paketCreditForm.getTblPaket().setModel(tableModelDataMotor);
    }
    
    
 
    public void clear()
    {
            
            idMotor="";
            idPaket="";
            
            paketCreditForm.getCbCicilan().setSelectedIndex(0);
            paketCreditForm.getTxtBunga().setText("");
            paketCreditForm.getTxtUangMuka().setText("");
            paketCreditForm.getJlabelNilaiCicilan().setText("...");
            paketCreditForm.getJlabelHargaTotal().setText("...");
          
            paketCreditForm.getJlabelKodeMotor().setText("...");
            paketCreditForm.getJlabelNamaMotor().setText("...");
            paketCreditForm.getJlabelMerk().setText("...");
            paketCreditForm.getJlabelWarna().setText("...");
            paketCreditForm.getJlabelStok().setText("...");
            paketCreditForm.getJlabelHarga().setText("...");

    }
  
    public void hitungPaket()
    {
       
        
        if(idMotor.equals("") || !paketCreditForm.getRbMotor().isSelected())
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Model Yang Mau Dipaketkan");
        }
        
        else
        {
            
            String getBungaPerTahun=paketCreditForm.getTxtBunga().getText().trim();
            String getHargaMotor=paketCreditForm.getJlabelHarga().getText().toString().replaceAll("[Rp.,]", "");
            String getUangMuka=paketCreditForm.getTxtUangMuka().getText().toString();
            int getJumlahCicilan=Integer.parseInt(paketCreditForm.getCbCicilan().getSelectedItem().toString());

            int validasiUangMuka=Integer.parseInt(getHargaMotor)*20/100;
        
            if(getBungaPerTahun.equals("") || getUangMuka.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Silahkan isi bunga dan uang muka");
            }

            else if(Integer.parseInt(getUangMuka) < validasiUangMuka)
            {
                JOptionPane.showMessageDialog(null, "Uang muka tidak boleh kurang dari 20% harga motor minimal Rp."+NumberFormat.getInstance().format(validasiUangMuka));
            }

            else
            {

                int hutangPokok=Integer.parseInt(getHargaMotor)- Integer.parseInt(getUangMuka);
                int totalBunga=hutangPokok*Integer.parseInt(getBungaPerTahun)/100*getJumlahCicilan/12;
                int hargaTotal=hutangPokok+totalBunga;
                int cicilanPerBulan=hargaTotal/getJumlahCicilan;
                
               

                paketCreditForm.getJlabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(cicilanPerBulan));
                paketCreditForm.getJlabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(hargaTotal));
                paketCreditForm.getJlabelHutangPokok().setText("Rp."+NumberFormat.getInstance().format(hutangPokok));
                paketCreditForm.getJlabelTotalBunga().setText("Rp."+NumberFormat.getInstance().format(totalBunga));

            }
        }
        
        
            
    }
    
    public void tambahPaket()
    {
        Paket paket=new Paket();
        
        paket.setKodePaket(paketCreditForm.getJlabelKodePaket().getText());
        paket.setIdMotor(Integer.parseInt(idMotor));
        paket.setJumlahCicilan(Integer.parseInt(paketCreditForm.getCbCicilan().getSelectedItem().toString()));
        paket.setNilaiCicilan(Integer.parseInt(paketCreditForm.getJlabelNilaiCicilan().getText().toString().replaceAll("[Rp.,]", "")));
        paket.setBunga(Integer.parseInt(paketCreditForm.getTxtBunga().getText().toString().replaceAll("[Rp.,]", "")));
        paket.setUangMuka(Integer.parseInt(paketCreditForm.getTxtUangMuka().getText().toString().replaceAll("[Rp.,]", "")));
        paket.setHargaTotal(Integer.parseInt(paketCreditForm.getJlabelHargaTotal().getText().toString().replaceAll("[Rp.,]", "")));
        
        interfacePaket.tambahPaket(paket);
    }
    
    
    public void editPaket()
    {
        if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Diubah");
        }
        
      
    }
    
    
    public void hapusPaket()
    {
        if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Dihapus");
        }
        
                
        else
        {
             int opsi=JOptionPane.showConfirmDialog(null, "Hapus data mobil ini ?","Hapus Mobil",JOptionPane.YES_NO_OPTION);
             if(opsi==JOptionPane.YES_OPTION)interfacePaket.deletePacket(Integer.parseInt(idPaket));
        }
    }
    
    
    public void getRowData()
    {
        int row=paketCreditForm.getTblPaket().getSelectedRow();
        
        if(paketCreditForm.getRbpaket().isSelected())
        {
            idPaket=String.valueOf(paketArrayList.get(row).getIdPaket());

            paketCreditForm.getCbCicilan().setSelectedItem(paketArrayList.get(row).getJumlahCicilan());
            paketCreditForm.getTxtBunga().setText(String.valueOf(paketArrayList.get(row).getBunga()));
            paketCreditForm.getTxtUangMuka().setText(String.valueOf(paketArrayList.get(row).getUangMuka()));
            paketCreditForm.getJlabelNilaiCicilan().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getNilaiCicilan()));
            paketCreditForm.getJlabelHargaTotal().setText("Rp."+NumberFormat.getInstance().format(paketArrayList.get(row).getHargaTotal()));
        }
        
            idMotor=String.valueOf(motorArrayList.get(row).getId());

            paketCreditForm.getJlabelKodeMotor().setText(motorArrayList.get(row).getKodeMotor());
            paketCreditForm.getJlabelNamaMotor().setText(motorArrayList.get(row).getNama());
            paketCreditForm.getJlabelMerk().setText(motorArrayList.get(row).getMerk());
            paketCreditForm.getJlabelWarna().setText(motorArrayList.get(row).getWarna());
            paketCreditForm.getJlabelStok().setText(String.valueOf(motorArrayList.get(row).getStok()));
            paketCreditForm.getJlabelHarga().setText("Rp."+NumberFormat.getInstance().format(motorArrayList.get(row).getHarga()));
    }
    
    public void searchData()
    {
        String cari=paketCreditForm.getTxtCari().getText().trim();
        int index=paketCreditForm.getCbBerdasarkan().getSelectedIndex();
        TableModelDataPaket tableModelDataPaket;
        TableModelDataMotor tableModelDataMotor;
                
        if(paketCreditForm.getCbKategori().getSelectedIndex()==0)
        {
                paketCreditForm.getRbpaket().setSelected(true);
                
                switch(index)
                {
                    case 0:
                        paketArrayList=interfacePaket.searchDataPaketByKode(cari);
                        tableModelDataPaket=new TableModelDataPaket(paketArrayList);
                        paketCreditForm.getTblPaket().setModel(tableModelDataPaket);
                        
                        break;
                        
                    case 1:
                        paketArrayList=interfacePaket.searchDataPaketByMotor(cari);
                        tableModelDataPaket=new TableModelDataPaket(paketArrayList);
                        paketCreditForm.getTblPaket().setModel(tableModelDataPaket);
                        break;
                }
        }
        
        else if(paketCreditForm.getCbKategori().getSelectedIndex()==1)
        {
            paketCreditForm.getRbMotor().setSelected(true);
            
            switch(index)
            {
                case 0:
                    motorArrayList=interfaceMotor.searchKodeMotor(cari);
                    tableModelDataMotor=new TableModelDataMotor(motorArrayList);
                    paketCreditForm.getTblPaket().setModel(tableModelDataMotor);
                    break;
                    
                case 1:
                    motorArrayList=interfaceMotor.searchNamaMotor(cari);
                    tableModelDataMotor=new TableModelDataMotor(motorArrayList);
                    paketCreditForm.getTblPaket().setModel(tableModelDataMotor);
                    break;
            }
        }
    }
    
    
    public void resetTable()
    {
        if(paketCreditForm.getRbpaket().isSelected())
        {
             paketArrayList=interfacePaket.showDataPaket();
             TableModelDataPaket tabelModelDataPaket=new TableModelDataPaket(paketArrayList);
             paketCreditForm.getTblPaket().setModel(tabelModelDataPaket);
        }
        
        else if(paketCreditForm.getRbMotor().isSelected())
        {
             motorArrayList=interfaceMotor.showDataMotor();
             TableModelDataMotor tabelModelDataMotor=new TableModelDataMotor(motorArrayList);
             paketCreditForm.getTblPaket().setModel(tabelModelDataMotor);
        }
    }
        
    
}
