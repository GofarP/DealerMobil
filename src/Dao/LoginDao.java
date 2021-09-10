/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LoginDao implements InterfaceLogin{
    
    Connection conn=null;
    String sql="";
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @Override
    public boolean login(Login login) {
        
        boolean correct=false;
        
        try 
        {
            
            conn=(Connection)koneksi.configDB();
            sql="select * from login where username=? and password=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, login.getUsername());
            pst.setString(2, login.getPassword());
            
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                correct=true;
                
                JOptionPane.showMessageDialog(null, "Selamat datang "+rs.getString("username"));
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return correct;
    }
    
}
