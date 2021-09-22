/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Motor;
import Model.Paket;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LaporanDao implements InterfaceLaporan{

    ArrayList<Motor>motorArrayList;
    ArrayList<Paket>paketArrayList=new ArrayList<>();
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    
    Motor motor;
    Paket paket;
    
    @Override
    public ArrayList<Motor> laporanMotor() {
        try 
        {
            motorArrayList=new ArrayList<>();
            
            conn=(Connection)koneksi.configDB();
            sql="select * from motor";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                motor=new Motor();
                motor.setId(rs.getInt("id"));
                motor.setKodeMotor(rs.getString("kode_motor"));
                motor.setNama(rs.getString("nama"));
                motor.setMerk(rs.getString("merk"));
                motor.setWarna(rs.getString("warna"));
                motor.setStok(rs.getInt("stok"));
                motor.setHarga(rs.getInt("harga"));
                
                motorArrayList.add(motor);
            }
           
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return motorArrayList;
    }

    @Override
    public ArrayList<Motor> laporanMotorByKode(String kode) {
        try 
        {
            motorArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from motor where kode_motor=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                motor=new Motor();
                motor.setId(rs.getInt("id"));
                motor.setKodeMotor(rs.getString("kode_motor"));
                motor.setNama(rs.getString("nama"));
                motor.setMerk(rs.getString("merk"));
                motor.setWarna(rs.getString("warna"));
                motor.setStok(rs.getInt("stok"));
                motor.setHarga(rs.getInt("harga"));
                
                motorArrayList.add(motor);
            }
           
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return motorArrayList;
    }

    @Override
    public ArrayList<Motor> laporanMotorByMerk(String merk) {
        try 
        {
            motorArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from motor where merk=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,merk);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                motor=new Motor();
                motor.setId(rs.getInt("id"));
                motor.setKodeMotor(rs.getString("kode_motor"));
                motor.setNama(rs.getString("nama"));
                motor.setMerk(rs.getString("merk"));
                motor.setWarna(rs.getString("warna"));
                motor.setStok(rs.getInt("stok"));
                motor.setHarga(rs.getInt("harga"));
                
                motorArrayList.add(motor);
            }
           
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return motorArrayList;
    }

    @Override
    public ArrayList<Motor> laporanMotorByNama(String nama) {
        try 
        {
            motorArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from motor where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                motor=new Motor();
                motor.setId(rs.getInt("id"));
                motor.setKodeMotor(rs.getString("kode_motor"));
                motor.setNama(rs.getString("nama"));
                motor.setMerk(rs.getString("merk"));
                motor.setWarna(rs.getString("warna"));
                motor.setStok(rs.getInt("stok"));
                motor.setHarga(rs.getInt("harga"));
                
                motorArrayList.add(motor);
            }
           
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return motorArrayList;
    }

    @Override
    public ArrayList<Motor> laporanMotorByWarna(String warna) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from motor where warna=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, warna);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                motor=new Motor();
                motor.setId(rs.getInt("id"));
                motor.setKodeMotor(rs.getString("kode_motor"));
                motor.setNama(rs.getString("nama"));
                motor.setMerk(rs.getString("merk"));
                motor.setWarna(rs.getString("warna"));
                motor.setStok(rs.getInt("stok"));
                motor.setHarga(rs.getInt("harga"));
                
                motorArrayList.add(motor);
            }
           
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return motorArrayList;
    }

    
    @Override
    public ArrayList<Paket> laporanPaket() {
        try 
        {
            
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama` , motor.`merk` , motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id`";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
                paketArrayList.add(paket);
                
            }
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Paket Error"+ e.getMessage());
        }
        
        return paketArrayList;

    }

    @Override
    public ArrayList<Paket> laporanPaketByKodePaket(String kodePaket) {
        try 
        {
            paketArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama`, motor.`merk`, motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id` where paket.`kode_paket=?`";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kodePaket);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return paketArrayList;
    }

    @Override
    public ArrayList<Paket> laporanPaketByNama(String nama) {
        try 
        {
            paketArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="SELECT paket.*, motor.`nama`, motor.`merk`, motor.`warna` FROM paket INNER JOIN motor ON paket.`id_motor`=motor.`id` where motor.`nama=?`";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                paket=new Paket();
                
                paket.setIdPaket(rs.getInt("id_paket"));
                paket.setKodePaket(rs.getString("kode_paket"));
                paket.setIdMotor(rs.getInt("id_motor"));
                paket.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                paket.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                paket.setBunga(rs.getInt("bunga"));
                paket.setUangMuka(rs.getInt("uang_muka"));
                paket.setHargaTotal(rs.getInt("harga_total"));
                paket.setNamaMotor(rs.getString("nama"));
                paket.setMerkMotor(rs.getString("merk"));
                paket.setWarnaMotor(rs.getString("warna"));
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return paketArrayList;
    }

    
    
    
    
}
