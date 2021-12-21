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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DashboardDao implements InterfaceDashboard{

    Connection conn;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<Motor>motorArrayList;
    
    @Override
    public int getMotorTerjual() {
        
        int terjual=0;
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select count(*) as jml_beli_cash from beli_cash";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())terjual+=rs.getInt("jml_beli_cash");
            
            sql="select count(*) as jml_beli_credit from beli_credit where status='lunas'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())terjual+=rs.getInt("jml_beli_credit");
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return terjual;
    }

    @Override
    public int getMerkMotor() {
        
        int jumlahMotor=0;
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select count(*) as jml_motor from motor";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                jumlahMotor=rs.getInt("jml_motor");
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return jumlahMotor;
    }

    @Override
    public int getIncome() {
        
        int income=0;
        
        try 
        {            
            //ambil data dari tabel beli_cash
            conn=(Connection)koneksi.configDB();
            sql=" SELECT SUM(motor.`harga`) AS total_income" +
                " FROM beli_cash " +
                " INNER JOIN motor ON beli_cash.`id_motor`=motor.`id` "+
                " WHERE MONTH(tgl_beli)=MONTH(CURRENT_DATE()) and YEAR(tgl_beli)=YEAR(CURRENT_DATE()) HAVING MAX(tgl_beli) IS NOT NULL";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                income+=rs.getInt("total_income");
            }
            
            //ambil data dari tabel kredit
            sql="SELECT SUM(beli_credit.`uang_muka`) AS uang_muka FROM beli_credit "
                 + "WHERE MONTH(tgl_beli)=MONTH(CURRENT_DATE()) AND YEAR(tgl_beli)=YEAR(CURRENT_DATE()) HAVING MAX(tgl_beli) IS NOT NULL";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                income+=rs.getInt("uang_muka");
            }
            
            //ambil data dari tabel cicilan
            sql="SELECT SUM(cicilan.`jml_bayar`) AS jml_bayar, SUM(cicilan.`denda`) AS denda " +
                "FROM cicilan WHERE MONTH(tgl_bayar)=MONTH(CURRENT_DATE()) AND YEAR(tgl_bayar)=YEAR(CURRENT_DATE()) HAVING MAX(tgl_bayar) IS NOT NULL";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                income+=rs.getInt("jml_bayar")+rs.getInt("denda");
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return income;
    }
    
}
