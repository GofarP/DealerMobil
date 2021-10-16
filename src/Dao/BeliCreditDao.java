/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.BeliCash;
import Model.BeliCredit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class BeliCreditDao implements InterfaceBeliCredit{

    ArrayList<BeliCredit>arrayListBeliCredit;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql, kodeBeli;
    BeliCredit beliCredit;
    
    @Override
    public ArrayList<BeliCredit> showDataBeliCredit() {
        try 
        {
          arrayListBeliCredit=new ArrayList<>();
          
          conn=(Connection)koneksi.configDB();
          sql="SELECT * from view_belicredit ";
          pst=conn.prepareStatement(sql);
          rs=pst.executeQuery();
          
          while(rs.next())
          {
              beliCredit=new BeliCredit();
              
//              date=sdf.parse(rs.getString("tgl_beli")); 
//              sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//              String formattedDate=sdf.format(date);
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setIdPaket(rs.getInt("id_paket"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNoKtp(rs.getString("no_ktp"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setJenisKelamin(rs.getString("jenis_kelamin"));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setNoTelp(rs.getString("notelp"));
                beliCredit.setKodeMotor(rs.getString("kode_motor"));
                beliCredit.setKodePaket(rs.getString("kode_paket"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                beliCredit.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                beliCredit.setBunga(rs.getInt("bunga"));
                beliCredit.setUangMuka(rs.getInt("uang_muka"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTanggal(rs.getString("tgl_beli"));
                beliCredit.setStatus(rs.getString("status"));
              
              
              arrayListBeliCredit.add(beliCredit);
          }
          
          
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListBeliCredit;
    }

    @Override
    public ArrayList<BeliCredit> searchDataKreditByKode(String kode) {
        try 
        {
            arrayListBeliCredit=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from view_belicredit where no_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCredit=new BeliCredit();
                
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setIdPaket(rs.getInt("id_paket"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNoKtp(rs.getString("no_ktp"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setJenisKelamin(rs.getString("jenis_kelamin"));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setNoTelp(rs.getString("notelp"));
                beliCredit.setKodeMotor(rs.getString("kode_motor"));
                beliCredit.setKodePaket(rs.getString("kode_paket"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                beliCredit.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                beliCredit.setBunga(rs.getInt("bunga"));
                beliCredit.setUangMuka(rs.getInt("uang_muka"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTanggal(rs.getString("tgl_beli"));
                beliCredit.setStatus(rs.getString("status"));
                
                arrayListBeliCredit.add(beliCredit);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListBeliCredit;
    }

    @Override
    public ArrayList<BeliCredit> searchDatKreditByNama(String nama) {
        try 
        {
            arrayListBeliCredit=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="select * from view_belicredit where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCredit=new BeliCredit();
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setIdPaket(rs.getInt("id_paket"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNoKtp(rs.getString("no_ktp"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setJenisKelamin(rs.getString("jenis_kelamin"));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setNoTelp(rs.getString("notelp"));
                beliCredit.setKodeMotor(rs.getString("kode_motor"));
                beliCredit.setKodePaket(rs.getString("kode_paket"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setJumlahCicilan(rs.getInt("jumlah_cicilan"));
                beliCredit.setNilaiCicilan(rs.getInt("nilai_cicilan"));
                beliCredit.setBunga(rs.getInt("bunga"));
                beliCredit.setUangMuka(rs.getInt("uang_muka"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTanggal(rs.getString("tgl_beli"));
                beliCredit.setStatus(rs.getString("status"));
                
                arrayListBeliCredit.add(beliCredit);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListBeliCredit;
    }

    @Override
    public void tambahData(BeliCredit beliCredit) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
            
            sql="insert into beli_credit(no_beli, no_ktp, nama, jenis_kelamin, alamat, notelp, id_paket, tgl_beli, uang_muka,  status) values(?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, beliCredit.getNoBeli());
            pst.setString(2, beliCredit.getNoKtp());
            pst.setString(3, beliCredit.getNama());
            pst.setString(4, beliCredit.getJenisKelamin());
            pst.setString(5, beliCredit.getAlamat());
            pst.setString(6, beliCredit.getNoTelp());
            pst.setInt(7, beliCredit.getIdPaket());
            pst.setString(8, beliCredit.getTglBeli());
            pst.setInt(9, beliCredit.getUangMuka());
            pst.setString(10, beliCredit.getStatus());
            
            pst.executeUpdate();
            
            String sqlKurangStock="update motor set stok=stok-1 where id=?";
            pst=conn.prepareStatement(sqlKurangStock);
            pst.setInt(1, beliCredit.getIdMotor());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "sukses Menambah Data Baru");
            
            conn.commit();
        } 
        
        catch (SQLException e) 
        {
            try 
            {
                JOptionPane.showMessageDialog(null, "Exception:"+e.getMessage());
                conn.rollback();
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(BeliCreditDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void editData(BeliCredit beliCredit) {
        try 
        {            
            conn=(Connection)koneksi.configDB();
            sql="update beli_credit set no_ktp=?, nama=?, jenis_kelamin=?,alamat=?, notelp=? where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, beliCredit.getNoKtp());
            pst.setString(2, beliCredit.getNama());
            pst.setString(3, beliCredit.getJenisKelamin());
            pst.setString(4, beliCredit.getAlamat());
            pst.setString(5, beliCredit.getNoTelp());
            pst.setInt(6, beliCredit.getIdBeli());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Mengubah Data Pembelian");
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void deletedata(int idBeli, int idMotor) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
            
            sql="delete from beli_credit where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,idBeli);
            pst.executeUpdate();
            
            sql="update motor set stok=stok+1 where id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, idMotor);
            pst.executeUpdate();
            
            conn.commit();
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Data Beli");
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
                Logger.getLogger(BeliCreditDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean cekCicilan(int id) {
        
        boolean found=false;

        try 
        {            
            conn=(Connection)koneksi.configDB();
            sql="select * from cicilan where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                found=true;
            }
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return found;
    }

    @Override
    public String noOtomatis() {
        
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from beli_credit order by no_beli desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
               
                String noBeli=rs.getString("no_beli").substring(3);
                String addnum = "" + (Integer.parseInt(noBeli) + 1);
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

                kodeBeli="CR-"+nol+addnum;
            }
            
            else
            {
                kodeBeli="CR-0001";
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return kodeBeli;
    }

    @Override
    public boolean cekStok(int idMotor) {
        boolean habis=false;
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select stok from motor where id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, idMotor);
            rs=pst.executeQuery();
            rs.next();
            
            if(rs.getInt("stok")==0) habis=true;
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Cek Motor:"+ e.getMessage());
        }
        
        return  habis;
        
    }
    
}
