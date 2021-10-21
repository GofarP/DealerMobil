/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.BeliCash;
import Model.Motor;
import Model.Pelanggan;
import Model.Pembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    Date date=new Date();
    
    ArrayList<BeliCash> beliCashArrayList;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    @Override
    public String autoNumber() {
        try 
        {
            
            conn=(Connection)koneksi.configDB();
            sql="select * from beli_cash order by no_beli desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                String idbeli=rs.getString("no_beli").substring(3);
                String addnum = "" + (Integer.parseInt(idbeli) + 1);
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
                
                kodeBeli="TX-"+nol+addnum;
                
            }
            
            else
            {
                kodeBeli="TX-0001";
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
          beliCashArrayList=new ArrayList<>();
          
          conn=(Connection)koneksi.configDB();
          sql="SELECT beli_cash.*, motor.`id`, motor.`kode_motor`,motor.`nama`, motor.`merk`, motor.`warna`, motor.`harga` FROM  beli_cash INNER JOIN motor ON motor.`id`=beli_cash.`id_motor`";
          pst=conn.prepareStatement(sql);
          rs=pst.executeQuery();
          
          while(rs.next())
          {
              beliCash=new BeliCash();
              
              date=sdf.parse(rs.getString("tgl_beli")); 
              sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
              String formattedDate=sdf.format(date);
              
              beliCash.setIdBeli(rs.getInt("id_beli"));
              beliCash.setNoKtp(rs.getString("no_ktp"));
              beliCash.setNoBeli(rs.getString("no_beli"));
              beliCash.setNama(rs.getString("nama"));
              beliCash.setJeniKelamin(rs.getString("jenis_kelamin"));
              beliCash.setAlamat(rs.getString("alamat"));
              beliCash.setNoTelp(rs.getString("notelp"));
              beliCash.setIdMotor(rs.getInt("id_motor"));
              beliCash.setKodeMotor(rs.getString("kode_motor"));
              beliCash.setNamaMotor(rs.getString("motor.nama"));
              beliCash.setMerkMotor(rs.getString("merk"));
              beliCash.setWarnaMotor(rs.getString("warna"));
              beliCash.setHargaMotor(rs.getInt("harga"));
              beliCash.setTglBeli(formattedDate);
              
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
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
            
            sql="insert into beli_cash(no_beli,no_ktp, nama, jenis_kelamin, alamat,notelp,id_motor,tgl_beli) values(?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, beliCash.getNoBeli());
            pst.setString(2, beliCash.getNoKtp());
            pst.setString(3, beliCash.getNama());
            pst.setString(4, beliCash.getJeniKelamin());
            pst.setString(5, beliCash.getAlamat());
            pst.setString(6, beliCash.getNoTelp());
            pst.setInt(7, beliCash.getIdMotor());
            pst.setString(8, beliCash.getTglBeli());
            
            pst.executeUpdate();
            
            sql="update motor set stok=stok-1 where id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, beliCash.getIdMotor());
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
    public void editPembelian(BeliCash beliCash)
    {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="";
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @Override
    public void deletePembelian(String idBeli, String idmotor) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
            
            sql="delete from beli_cash where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, idBeli);
            pst.executeUpdate();
            
            sql="update motor set stok=stok+1 where id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, idmotor);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Data");
            
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
    public ArrayList<BeliCash> searchByKode(String kode) {
        try 
        {
            beliCashArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="SELECT beli_cash.*, motor.`id`, motor.`kode_motor`,motor.`nama`, motor.`merk`, motor.`warna`, motor.`harga` "
                    + "FROM  beli_cash INNER JOIN motor ON motor.`id`=beli_cash.`id_motor` where beli_cash.`no_beli`=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCash=new BeliCash();
                
                date=sdf.parse(rs.getString("tgl_beli")); 
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String formattedDate=sdf.format(date);
                
                beliCash.setIdBeli(rs.getInt("id_beli"));
                beliCash.setNoKtp(rs.getString("no_ktp"));
                beliCash.setNoBeli(rs.getString("no_beli"));
                beliCash.setNama(rs.getString("nama"));
                beliCash.setJeniKelamin(rs.getString("jenis_kelamin"));
                beliCash.setAlamat(rs.getString("alamat"));
                beliCash.setNoTelp(rs.getString("notelp"));
                beliCash.setIdMotor(rs.getInt("id_motor"));
                beliCash.setKodeMotor(rs.getString("kode_motor"));
                beliCash.setNamaMotor(rs.getString("motor.nama"));
                beliCash.setMerkMotor(rs.getString("merk"));
                beliCash.setWarnaMotor(rs.getString("warna"));
                beliCash.setHargaMotor(rs.getInt("harga"));
                beliCash.setTglBeli(formattedDate);

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
    public ArrayList<BeliCash> searchByName(String nama) {
        
        try 
        {
            beliCashArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="SELECT beli_cash.*, motor.`id`,motor.`kode_motor`, motor.`nama`, motor.`merk`, motor.`warna`, motor.`harga` "
                    + "FROM  beli_cash INNER JOIN motor ON motor.`id`=beli_cash.`id_motor` where beli_cash.`nama`=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCash=new BeliCash();
                date=sdf.parse(rs.getString("tgl_beli")); 
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String formattedDate=sdf.format(date);
                
                beliCash.setIdBeli(rs.getInt("id_beli"));
                beliCash.setNoKtp(rs.getString("no_ktp"));
                beliCash.setNoBeli(rs.getString("no_beli"));
                beliCash.setNama(rs.getString("nama"));
                beliCash.setKodeMotor(rs.getString("kode_motor"));
                beliCash.setJeniKelamin(rs.getString("jenis_kelamin"));
                beliCash.setAlamat(rs.getString("alamat"));
                beliCash.setNoTelp(rs.getString("notelp"));
                beliCash.setIdMotor(rs.getInt("id_motor"));
                beliCash.setNamaMotor(rs.getString("motor.nama"));
                beliCash.setMerkMotor(rs.getString("merk"));
                beliCash.setWarnaMotor(rs.getString("warna"));
                beliCash.setHargaMotor(rs.getInt("harga"));
                beliCash.setTglBeli(formattedDate);
                
                beliCashArrayList.add(beliCash);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beliCashArrayList;

    }

   
    
    
    
}
