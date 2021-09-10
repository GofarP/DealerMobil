/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.BeliCash;
import Model.Mobil;
import Model.Pelanggan;
import Model.Pembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class BeliCashDao implements InterfaceBeliCash{
    
    String sql,kodeBeli;
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    BeliCash beliCash;
    Pembelian pembelian;
    
    ArrayList<BeliCash> beliCashArrayList;
    
    @Override
    public String autoNumber() {
        try 
        {
            String idBeli="";
            conn=(Connection)koneksi.configDB();
            sql="select * from pembelian order by no_beli desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                idBeli=rs.getString("no_beli").substring(3);
                String addnum = "" + (Integer.parseInt(idBeli) + 1);
                String nol="";
                
                if(addnum.length()==1)
                {
                    nol="000";
                }
                
                else if(addnum.length()==2)
                {
                    nol="00";
                }
                
                else if(addnum.length()==3)
                {
                    nol="0";
                }
                
                else if(addnum.length()==4)
                {
                    nol="";
                }
                
                kodeBeli="TX-"+nol+idBeli;
                
            }
            
            else
            {
                kodeBeli="TX-"+idBeli;
            }
            
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return kodeBeli;
    }
    
    @Override
    public ArrayList<BeliCash> showDataBeli() {
        try 
        {
          beliCash=new BeliCash();
          beliCashArrayList=new ArrayList<>();
          
          conn=(Connection)koneksi.configDB();
          sql="SELECT pembelian.*, mobil.`id`, mobil.`nama`, mobil.`merk`, mobil.`warna`, mobil.`harga` FROM  pembelian INNER JOIN mobil ON mobil.`id`=pembelian.`id_mobil`";
          pst=conn.prepareStatement(sql);
          rs=pst.executeQuery();
          
          while(rs.next())
          {
              beliCash.setIdBeli(rs.getString("id_beli"));
              beliCash.setNoKtp(rs.getString("no_ktp"));
              beliCash.setNoBeli(rs.getString("no_beli"));
              beliCash.setNama(rs.getString("nama"));
              beliCash.setJeniKelamin(rs.getString("jenis_kelamin"));
              beliCash.setAlamat(rs.getString("alamat"));
              beliCash.setNoTelp(rs.getString("notelp"));
              beliCash.setIdMobil(rs.getInt("id_mobil"));
              beliCash.setNamaMobil(rs.getString("nama_mobil"));
              beliCash.setMerkMobil(rs.getString("merk"));
              beliCash.setWarnaMobil(rs.getString("warna"));
              beliCash.setHargaMobil(rs.getInt("harga"));
              
              beliCashArrayList.add(beliCash);
          }
          
          
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beliCashArrayList;
    }

    @Override
    public void tambahPembelian(BeliCash beliCash) {
        
        try 
        {
            conn.setAutoCommit(false);
            
            conn=(Connection)koneksi.configDB();
            sql="insert into pembelian(no_beli,no_ktp, nama, jenis_kelamin, alamat,notelp,id_mobil,status,tgl_beli) values(?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, beliCash.getNoBeli());
            pst.setString(2, beliCash.getNoKtp());
            pst.setString(3, beliCash.getNama());
            pst.setString(4, beliCash.getJeniKelamin());
            pst.setString(5, beliCash.getAlamat());
            pst.setString(6, beliCash.getNoTelp());
            pst.setInt(7, beliCash.getIdMobil());
            pst.setString(8, beliCash.getStatus());
            pst.setString(9, String.valueOf(beliCash.getTglbayar()));
            
            pst.executeUpdate();
            
            String sqlKurangStock="update mobil set stok-=1 where id=?";
            pst=conn.prepareStatement(sqlKurangStock);
            pst.setInt(1, beliCash.getIdMobil());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Menambah Data Pembelian");
            
            conn.commit();
            
        } 
        
        catch (Exception e) 
        {
            try 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
                conn.rollback();
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(BeliCashDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void deletePembelian(String id) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="delete from pembelian where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Data");
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

   
    
    
    
}
