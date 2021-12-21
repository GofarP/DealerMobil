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
    ArrayList<Paket>paketArrayList=new ArrayList<>();
    ArrayList<Motor>motorArrayList=new ArrayList<>();
    String idMotor="", idPaket="";
    Paket paket=new Paket();
    
    public PaketController(PaketCreditForm paketCreditForm)
    {
        this.paketCreditForm=paketCreditForm;
        
        interfacePaket=new PaketDao();
        interfaceMotor=new MotorDao();
        
        paketArrayList=interfacePaket.showDataPaket();
        motorArrayList=interfaceMotor.showDataMotor();
        
        paketCreditForm.getJlabelKodePaket().setText(interfacePaket.autoNumber());
        
    }
    
    public void autoNumber()
    {
        paketCreditForm.getJlabelKodePaket().setText(interfacePaket.autoNumber());
    }

    public void showDataPaket()
    {
        idMotor="";
        paketArrayList.clear();
        paketArrayList=interfacePaket.showDataPaket();
        TableModelDataPaket tableModelDataPaket=new TableModelDataPaket(paketArrayList);
        paketCreditForm.getTblPaket().setModel(tableModelDataPaket);
        
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
            paketCreditForm.getJlabelHutangPokok().setText("...");
            paketCreditForm.getJlabelTotalBunga().setText("...");
          
            paketCreditForm.getJlabelKodeMotor().setText("...");
            paketCreditForm.getJlabelNamaMotor().setText("...");
            paketCreditForm.getJlabelMerk().setText("...");
            paketCreditForm.getJlabelWarna().setText("...");
            paketCreditForm.getJlabelStok().setText("...");
            paketCreditForm.getJlabelHarga().setText("...");

    }
  
    public void hitungPaket()
    {
       
       
        //|| !paketCreditForm.getRbMotor().isSelected()
        
        if(idMotor.equals("") )
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Model Yang Mau Dipaketkan");
        }
        
        
        else
        {
            
            String getBungaPerBulan=paketCreditForm.getTxtBunga().getText().trim();
            String getHargaMotor=paketCreditForm.getJlabelHarga().getText().replaceAll("[Rp.,]", "");
            String getUangMuka=paketCreditForm.getTxtUangMuka().getText();
            int getJumlahCicilan=Integer.parseInt(paketCreditForm.getCbCicilan().getSelectedItem().toString());

            int validasiUangMuka=Integer.parseInt(getHargaMotor)*20/100;
        
            if(getBungaPerBulan.equals("") || getUangMuka.equals(""))
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
                int totalBunga=hutangPokok*Integer.parseInt(getBungaPerBulan)/100*getJumlahCicilan/12;
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
        int row=paketCreditForm.getTblPaket().getSelectedRow();
        
        if(idMotor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Motor Yang Mau Di Paketkan");
        }
        
        else if(paketCreditForm.getTxtBunga().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Silahkan Masukkan Bunga Paket");
        }
        
        else if(paketCreditForm.getTxtUangMuka().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Masukkan Uang Muka");
        }
        
        else if(paketCreditForm.getJlabelHargaTotal().getText().equals("..."))
        {
            JOptionPane.showMessageDialog(null, "Silahkan hitung paket terlebih dahulu");
        }
        
        else if(motorArrayList.get(row).getHarga() >= Integer.parseInt(paketCreditForm.getJlabelHargaTotal().getText().replaceAll("[Rp.,]", "")))
        {
            JOptionPane.showMessageDialog(null, "Harga Total Kredit Tidak Boleh Rendah DariPada Harga Motors");
        }
        
        else
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
            
    }
    
    
    public void editPaket()
    {
        int row=paketCreditForm.getTblPaket().getSelectedRow();
        
        if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Diubah");
        }
        
        else if(paketCreditForm.getTxtBunga().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Silahkan Masukkan Bunga Paket");
        }
        
        else if(interfacePaket.cekPaket(Integer.parseInt(idMotor)))
        {
            JOptionPane.showMessageDialog(null, "Paket Tidak Bisa Diubah Karena Masih Ada Pembayaran Yang Belum Lunas");
        }
        
        else if(paketCreditForm.getTxtUangMuka().getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Masukkan Uang Muka");
        }
        
        else if(paketCreditForm.getJlabelHutangPokok().getText().equals("..."))
        {
            JOptionPane.showMessageDialog(null, "Silahkan hitung paket terlebih dahulu");
        }
        
        else if(motorArrayList.get(row).getHarga() >= Integer.parseInt(paketCreditForm.getJlabelHargaTotal().getText().replaceAll("[Rp.,]", "")))
        {
            JOptionPane.showMessageDialog(null, "Harga Total Kredit Tidak Boleh Rendah DariPada Harga Motors");
        }
        
        else
        {
            paket=new Paket();
        
            paket.setKodePaket(paketCreditForm.getJlabelKodePaket().getText());
            paket.setIdMotor(Integer.parseInt(idMotor));
            paket.setJumlahCicilan(Integer.parseInt(paketCreditForm.getCbCicilan().getSelectedItem().toString()));
            paket.setNilaiCicilan(Integer.parseInt(paketCreditForm.getJlabelNilaiCicilan().getText().replaceAll("[Rp.,]", "")));
            paket.setBunga(Integer.parseInt(paketCreditForm.getTxtBunga().getText().replaceAll("[Rp.,]", "")));
            paket.setUangMuka(Integer.parseInt(paketCreditForm.getTxtUangMuka().getText().replaceAll("[Rp.,]", "")));
            paket.setHargaTotal(Integer.parseInt(paketCreditForm.getJlabelHargaTotal().getText().replaceAll("[Rp.,]", "")));
            paket.setIdPaket(Integer.parseInt(idPaket));
            
            interfacePaket.editPaket(paket);
            
            
        }
      
    }
    
    
    public void hapusPaket()
    {
        if(idPaket.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Paket Yang Mau Dihapus");
        }
        
        else if(interfacePaket.cekPaket(Integer.parseInt(idPaket)))
        {
            JOptionPane.showMessageDialog(null, "Paket Tidak Bisa Dihapus Karena Ada Pembayaran Yang Belum Lunas");
        }
                
        else
        {
             int opsi=JOptionPane.showConfirmDialog(null, "Hapus data paket ini ?","Hapus Paket",JOptionPane.YES_NO_OPTION);
             if(opsi==JOptionPane.YES_OPTION)interfacePaket.deletePacket(Integer.parseInt(idPaket));
        }
    }
    
    
    public void getRowData()
    {
        int row=paketCreditForm.getTblPaket().getSelectedRow();
        
        if(paketCreditForm.getRbpaket().isSelected())
        {
            idPaket=String.valueOf(paketArrayList.get(row).getIdPaket());
            
            paketCreditForm.getJlabelKodePaket().setText(paketArrayList.get(row).getKodePaket());
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
