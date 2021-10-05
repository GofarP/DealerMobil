/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Paket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PaketDao implements InterfacePaket{

    ArrayList<Paket>arrayListPaket=new ArrayList<>();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Paket paket;
    
    
    @Override
    public String autoNumber()
    {
        String newKodePaket="";
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from paket order by kode_paket desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                String kodePaket=rs.getString("kode_paket").substring(2);
                String addnum = "" + (Integer.parseInt(kodePaket) + 1);
                String nol="";
                
                if(addnum.length()==1)
                {
                     nol = "000";
                }
                else if(addnum.length()==2)
                {
                    nol = "00";
                }
                else if(addnum.length()==3)
                {
                    nol = "0";
                }
                else if(addnum.length()==4)
                {
                    nol = "";
                }
                
                newKodePaket="P-"+nol+addnum;
            }
            
            else
            {
                newKodePaket="P-0001";
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return newKodePaket;
    }
    
    @Override
    public ArrayList<Paket> showDataPaket() {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama`, motor.`merk`, motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                
                arrayListPaket.add(paket);
                
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListPaket;
    }

    @Override
    public ArrayList<Paket> searchDataPaketByKode(String kode) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama`, motor.`merk`, motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id` where kode_paket=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                
                arrayListPaket.add(paket);
                
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListPaket;
    }

    @Override
    public ArrayList<Paket> searchDataPaketByMotor(String nama) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama`, motor.`merk`, motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id`where motor.`nama`=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                
                arrayListPaket.add(paket);
                
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListPaket;
    }

    @Override
    public void tambahPaket(Paket paket) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="insert into paket(kode_paket, id_motor, jumlah_cicilan, nilai_cicilan, bunga, uang_muka, harga_total) values(?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, paket.getKodePaket());
            pst.setInt(2, paket.getIdMotor());
            pst.setInt(3, paket.getJumlahCicilan());
            pst.setInt(4, paket.getNilaiCicilan());
            pst.setInt(5, paket.getBunga());
            pst.setInt(6, paket.getUangMuka());
            pst.setInt(7, paket.getHargaTotal());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses menambah paket");
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void editPaket(int idpaket) {
        try
        {
            conn=(Connection)koneksi.configDB();
            sql="update paket set id_motor=?, jumlah_cicilan=?, nilai_cicilan=?, bunga=?, uang_muka=?, harga_total";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            pst.setInt(1, paket.getIdMotor());
            pst.setInt(2, paket.getJumlahCicilan());
            pst.setInt(3, paket.getNilaiCicilan());
            pst.setInt(4, paket.getBunga());
            pst.setInt(5, paket.getUangMuka());
            pst.setInt(5, paket.getHargaTotal());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Mengubah Data Paket");
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void deletePacket(int idpaket) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="delete from paket where id_paket=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, idpaket);
           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "paket berhasil dihapus");
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public boolean cekPaket(int idpaket) {
        
        boolean ada=false;
        
        try 
        {   
            conn=(Connection)koneksi.configDB();
            sql="SELECT cicilan.`id_beli`, beli_credit.`status`, cicilan.`id_paket` FROM cicilan "
            + "INNER JOIN beli_credit ON cicilan.`id_beli`=beli_credit.`id_beli` WHERE  cicilan.`id_paket`=? AND beli_credit.status='belum";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, idpaket);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                ada=true;
            }
            
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return ada;
    }
    
}
