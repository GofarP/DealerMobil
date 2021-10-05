/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.Cicilan;
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
public class CicilanDao implements InterfaceCicilan{

    Connection conn;
    String sql, kodeCicilan;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<Cicilan>arrayListCicilan;
    Cicilan cicilan;
    
    @Override
    public void bayarCicilan(Cicilan cicilan) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="";
            
            
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public boolean telatBayar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapusCicilan(int idCicilan) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="delete from cicilan where id_cicilan=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, idCicilan);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Menghapus cicilan");
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public ArrayList<Cicilan> showDataCicilan() {
        try 
        {
            arrayListCicilan=new ArrayList<>();
            
            conn=(Connection)koneksi.configDB();
            sql="select * from view_datacicilan";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while (rs.next()) 
            {
                cicilan=new Cicilan();
                
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setKodePaket(rs.getString("kode_paket"));
                cicilan.setNoBeli(rs.getString("no_beli"));
                cicilan.setNoKtp(rs.getString("no_ktp"));
//                cicilan.setNama(rs.getString("nama"));
//                cicilan.setJenisKelamin(rs.getString("jenis_kelamin"));
//                cicilan.setAlamat(rs.getString("alamat"));
//                cicilan.setNoTelp(rs.getString("notelp"));
//                cicilan.setTglBeli(rs.getString("tgl_beli"));
//                cicilan.setTglCicil(rs.getString("tgl_cicil"));
//                cicilan.setStatus(rs.getString("status"));
//                cicilan.setKodeMotor(rs.getString("kode_motor"));
//                cicilan.setNamaMotor(rs.getString("nama_motor"));
//                cicilan.setMerkMotor(rs.getString("merk"));
//                cicilan.setWarnaMotor(rs.getString("warna"));
                
//                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
//                cicilan.setIdBeli(rs.getInt("id_beli"));
//                cicilan.setIdPaket(rs.getInt("id_paket"));
//                cicilan.setIdMotor(rs.getInt("id_motor"));
//                
//                cicilan.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
//                cicilan.setNilaiCicilan(rs.getInt("nilai_cicilan"));
//                cicilan.setBunga(rs.getInt("bunga"));
//                cicilan.setUangMuka(rs.getInt("uang_muka"));
//                cicilan.setHargaTotal(rs.getInt("harga_total"));
//                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                
                arrayListCicilan.add(cicilan);
            }
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListCicilan;
    }

    @Override
    public ArrayList<Cicilan> cariDataByKode(String kode) {
        try 
        {
            arrayListCicilan=new ArrayList<>();
            
            conn=(Connection)koneksi.configDB();
            sql="select * from view_datacicilan where kode_cicilan=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while (rs.next()) 
            {
                cicilan=new Cicilan();
                
                cicilan=new Cicilan();
                
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setKodePaket(rs.getString("kode_paket"));
                cicilan.setNoBeli(rs.getString("no_beli"));
                cicilan.setNoKtp(rs.getString("no_ktp"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setJenisKelamin(rs.getString("jenis_kelamin"));
                cicilan.setAlamat(rs.getString("alamat"));
                cicilan.setNoTelp(rs.getString("notelp"));
                cicilan.setTglBeli(rs.getString("tgl_beli"));
                cicilan.setTglCicil(rs.getString("tgl_cicil"));
                cicilan.setStatus(rs.getString("status"));
                cicilan.setKodeMotor(rs.getString("kode_motor"));
                cicilan.setNamaMotor(rs.getString("nama_motor"));
                cicilan.setMerkMotor(rs.getString("merk"));
                cicilan.setWarnaMotor(rs.getString("warna"));
                
                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
                cicilan.setIdBeli(rs.getInt("id_beli"));
                cicilan.setIdPaket(rs.getInt("id_paket"));
                cicilan.setIdMotor(rs.getInt("id_motor"));
                
                cicilan.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                cicilan.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                cicilan.setBunga(rs.getInt("bunga"));
                cicilan.setUangMuka(rs.getInt("uang_muka"));
                cicilan.setHargaTotal(rs.getInt("harga_total"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                
                arrayListCicilan.add(cicilan);
            }
        } 
        
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListCicilan;
    }

    @Override
    public ArrayList<Cicilan> cariDatByNama(String nama) {
        try 
        {
            arrayListCicilan=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from view_datacicilan where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while (rs.next())
            {
                cicilan=new Cicilan();
                                
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setKodePaket(rs.getString("kode_paket"));
                cicilan.setNoBeli(rs.getString("no_beli"));
                cicilan.setNoKtp(rs.getString("no_ktp"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setJenisKelamin(rs.getString("jenis_kelamin"));
                cicilan.setAlamat(rs.getString("alamat"));
                cicilan.setNoTelp(rs.getString("notelp"));
                cicilan.setTglBeli(rs.getString("tgl_beli"));
                cicilan.setTglCicil(rs.getString("tgl_cicil"));
                cicilan.setStatus(rs.getString("status"));
                cicilan.setKodeMotor(rs.getString("kode_motor"));
                cicilan.setNamaMotor(rs.getString("nama_motor"));
                cicilan.setMerkMotor(rs.getString("merk"));
                cicilan.setWarnaMotor(rs.getString("warna"));
                
                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
                cicilan.setIdBeli(rs.getInt("id_beli"));
                cicilan.setIdPaket(rs.getInt("id_paket"));
                cicilan.setIdMotor(rs.getInt("id_motor"));
                
                cicilan.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                cicilan.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                cicilan.setBunga(rs.getInt("bunga"));
                cicilan.setUangMuka(rs.getInt("uang_muka"));
                cicilan.setHargaTotal(rs.getInt("harga_total"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                arrayListCicilan.add(cicilan);
            }
            
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListCicilan;
    }

    @Override
    public String autoNumber() {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select kode_cicilan from cicilan order by kode_cicilan desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                String kodeCicil=rs.getString("kode_cicilan").substring(2);
                
                String addnum = "" + (Integer.parseInt(kodeCicil) + 1);
                String nol="";
                
                switch (addnum.length()) {
                    case 1:
                        nol="000";
                        break;
                    case 2:
                        nol="00";
                        break;
                    case 3:
                        nol="0";
                        break;
                    case 4:
                        nol="";
                        break;
                    default:
                        break;
                }
                
                kodeCicilan="C-"+nol+addnum;
                
            }
            
            else
            {
                kodeCicilan="C-0001";
            }
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return kodeCicilan;
    }
    
}
