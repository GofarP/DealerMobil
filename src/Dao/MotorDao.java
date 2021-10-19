/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Motor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class MotorDao implements InterfaceMotor{
    
    Connection conn;
    String sql="",kodeMotor="";
    PreparedStatement pst;
    ResultSet rs;
    
    Motor motor;
    
    ArrayList<Motor>motorArrayList;

    @Override
    public ArrayList<Motor> showDataMotor() {
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
    public ArrayList<Motor> searchKodeMotor(String kode) {
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
    public ArrayList<Motor> searchNamaMotor(String nama) {
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
    public ArrayList<Motor> searchMerkMotor(String merk)
    {
        try 
        {
            motor=new Motor();
            motorArrayList=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from motor where merk=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, merk);
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
    public void saveDataMotor(Motor motor) {
        try 
        {
           conn=(Connection)koneksi.configDB();
           sql="insert into motor(kode_motor,nama,merk,warna,stok,harga) values(?,?,?,?,?,?)";
           pst=conn.prepareStatement(sql);
           pst.setString(1, motor.getKodeMotor());
           pst.setString(2, motor.getNama());
           pst.setString(3, motor.getMerk());
           pst.setString(4, motor.getWarna());
           pst.setInt(5, motor.getStok());
           pst.setInt(6, motor.getHarga());
           
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Sukses Menambah Data Motor Baru");
           
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void updateDataMotor(Motor motor) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="update motor set nama=?, merk=?, warna=?, stok=?, harga=? where id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, motor.getNama());
            pst.setString(2, motor.getMerk());
            pst.setString(3, motor.getWarna());
            pst.setInt(4, motor.getStok());
            pst.setInt(5, motor.getHarga());
            pst.setInt(6, motor.getId());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data");
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void deleteDataMotor(int id) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="delete from motor where id=?";
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
            sql="select * from motor order by kode_motor desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                String idmotor=rs.getString("kode_motor").substring(1);
                String addnum = "" + (Integer.parseInt(idmotor) + 1);
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
                
                kodeMotor="M"+nol+addnum;
            }
            
            else 
            {
                kodeMotor="M0001";
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return kodeMotor;
    }

    @Override
    public boolean cekMotor(int id) {
        
        boolean ada=false;

        try 
        {            
            conn=(Connection)koneksi.configDB();
            sql="SELECT motor.`id` FROM motor " +
                "INNER JOIN paket ON motor.`id`=paket.`id_motor`" +
                "INNER JOIN beli_credit ON paket.`id_paket`=beli_credit.`id_paket`" +
                "WHERE beli_credit.`status`='belum' AND motor.`id`=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                ada=true;
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return ada;
    }

    
    
}
