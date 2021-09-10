/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Mobil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class MobilDao implements InterfaceMobil{
    
    Connection conn;
    String sql="",kodeMobil="";
    PreparedStatement pst;
    ResultSet rs;
    
    Mobil mobil;
    
    ArrayList<Mobil>mobilArrayList;

    @Override
    public ArrayList<Mobil> showDataMobil() {
        try 
        {
            mobil=new Mobil();
            mobilArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from mobil";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                mobil=new Mobil();
                                
                mobil.setId(rs.getInt("id"));
                mobil.setKodeMobil(rs.getString("kode_mobil"));
                mobil.setNama(rs.getString("nama"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setWarna(rs.getString("warna"));
                mobil.setStok(rs.getInt("stok"));
                mobil.setHarga(rs.getInt("harga"));
                
                mobilArrayList.add(mobil);
            }
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return mobilArrayList;
    }

    @Override
    public ArrayList<Mobil> searchNamaMobil(String nama) {
        try 
        {
            mobil=new Mobil();
            mobilArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from mobil where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                mobil=new Mobil();
                                
                mobil.setId(rs.getInt("id"));
                mobil.setKodeMobil(rs.getString("kode_mobil"));
                mobil.setNama(rs.getString("nama"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setWarna(rs.getString("warna"));
                mobil.setStok(rs.getInt("stok"));
                mobil.setHarga(rs.getInt("harga"));
                
                mobilArrayList.add(mobil);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return mobilArrayList;
    }
    
    @Override
    public ArrayList<Mobil> searchMerkMobil(String merk)
    {
        try 
        {
            mobil=new Mobil();
            mobilArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from mobil where merk=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, merk);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                mobil=new Mobil();
                                
                mobil.setId(rs.getInt("id"));
                mobil.setKodeMobil(rs.getString("kode_mobil"));
                mobil.setNama(rs.getString("nama"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setWarna(rs.getString("warna"));
                mobil.setStok(rs.getInt("stok"));
                mobil.setHarga(rs.getInt("harga"));
                
                mobilArrayList.add(mobil);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return mobilArrayList;
    }

    @Override
    public void saveDataMobil(Mobil mobil) {
        try 
        {
           conn=(Connection)koneksi.configDB();
           sql="insert into mobil(kode_mobil,nama,merk,warna,stok,harga) values(?,?,?,?,?,?)";
           pst=conn.prepareStatement(sql);
           pst.setString(1, mobil.getKodeMobil());
           pst.setString(2, mobil.getNama());
           pst.setString(3, mobil.getMerk());
           pst.setString(4, mobil.getWarna());
           pst.setInt(5, mobil.getStok());
           pst.setInt(6, mobil.getHarga());
           
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Sukses Menambah Data Mobil Baru");
           
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void updateDataMobil(Mobil mobil) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="update mobil set nama=?, merk=?, warna=?, stok=?, harga=? where id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, mobil.getNama());
            pst.setString(2, mobil.getMerk());
            pst.setString(3, mobil.getWarna());
            pst.setInt(4, mobil.getStok());
            pst.setInt(5, mobil.getHarga());
            pst.setInt(6, mobil.getId());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data");
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void deleteDataMobil(int id) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="delete from mobil where id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Data");
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public String autoNumber() {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from mobil order by kode_mobil desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                String idmobil=rs.getString("kode_mobil").substring(1);
                String addnum = "" + (Integer.parseInt(idmobil) + 1);
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
                
                kodeMobil="M"+nol+addnum;
            }
            
            else 
            {
                kodeMobil="M0001";
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return kodeMobil;
    }
    
}
