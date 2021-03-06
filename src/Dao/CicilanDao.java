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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    SimpleDateFormat sdf=new SimpleDateFormat();
    
    @Override
    public void bayarCicilan(Cicilan cicilan) {
        try 
        {
        
            
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
                           
            sql="insert into cicilan(kode_cicilan, id_beli, id_paket, cicilan_ke, jml_bayar, status_cicilan, denda,tgl_bayar) values(?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, cicilan.getKodeCicilan());
            pst.setInt(2, cicilan.getIdBeli());
            pst.setInt(3, cicilan.getIdPaket());
            pst.setInt(4, cicilan.getCicilanKe());
            pst.setInt(5, cicilan.getJumlahBayar());
            pst.setString(6, cicilan.getStatus());
            pst.setInt(7, cicilan.getDenda());
            pst.setString(8, cicilan.getTglCicil());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sukses Membayar Cicilan");
            conn.commit();
        } 
        
        catch (Exception e) 
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
                cicilan.setNama(rs.getString("nama"));
                cicilan.setJenisKelamin(rs.getString("jenis_kelamin"));
                cicilan.setAlamat(rs.getString("alamat"));
                cicilan.setNoTelp(rs.getString("notelp"));
                cicilan.setTglBeli(rs.getString("tgl_beli"));
                cicilan.setTglCicil(rs.getString("tgl_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
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
                cicilan.setUangMuka(rs.getInt("uangmuka_paket"));
                cicilan.setHargaTotal(rs.getInt("harga_total"));
                cicilan.setStatus(rs.getString("status_cicilan"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                cicilan.setDenda(rs.getInt("denda"));
                
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
                
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setKodePaket(rs.getString("kode_paket"));
                cicilan.setNoBeli(rs.getString("no_beli"));
                cicilan.setNoKtp(rs.getString("no_ktp"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setJenisKelamin(rs.getString("jenis_kelamin"));
                cicilan.setAlamat(rs.getString("alamat"));
                cicilan.setNoTelp(rs.getString("notelp"));
                cicilan.setTglBeli(rs.getString("tgl_beli"));
                cicilan.setTglCicil(rs.getString("tgl_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
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
                cicilan.setUangMuka(rs.getInt("uangmuka_paket"));
                cicilan.setHargaTotal(rs.getInt("harga_total"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                cicilan.setDenda(rs.getInt("denda"));
                
                
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
                cicilan.setTglCicil(rs.getString("tgl_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
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
                cicilan.setUangMuka(rs.getInt("uangmuka_paket"));
                cicilan.setHargaTotal(rs.getInt("harga_total"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                cicilan.setDenda(rs.getInt("denda"));
                
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

    @Override
    public boolean cekCicilan(int id) {
        
        boolean lunas=false;
        int jmlCicilan;
        try 
        {
            conn=(Connection)koneksi.configDB();
            String sqlGetJumlahCicilan="SELECT jumlah_cicilan FROM paket INNER JOIN beli_credit ON beli_credit.`id_paket`=paket.`id_paket` WHERE id_beli=?";
            pst=conn.prepareStatement(sqlGetJumlahCicilan);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            rs.next();
            jmlCicilan=rs.getInt("jumlah_cicilan");
            
            sql="select count(*) as cicilan_dibayar from cicilan where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            rs.next();
            
            if (rs.getInt("cicilan_dibayar")==jmlCicilan) 
            {
                lunas=true;
            }
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return lunas;
    }

    @Override
    public void updateStatus(String idBeli) {
        try
        {
            
            int jmlCicilan=0;
            conn=(Connection)koneksi.configDB();
            conn.setAutoCommit(false);
            
            sql="SELECT jumlah_cicilan FROM paket INNER JOIN beli_credit ON beli_credit.`id_paket`=paket.`id_paket` WHERE id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, idBeli);
            rs=pst.executeQuery();
            
            if(rs.next())jmlCicilan=rs.getInt("jumlah_cicilan");

            sql="select count(*) as cicilan_dibayar from cicilan where id_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, idBeli);
            rs=pst.executeQuery();
            
            rs.next();
            
            if (rs.getInt("cicilan_dibayar")==jmlCicilan) 
            {
                sql="update beli_credit set status=? where id_beli=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, "lunas");
                pst.setString(2,idBeli);
                pst.executeUpdate();    
            }
            
            else
            {
                sql="update beli_credit set status=? where id_beli=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, "belum");
                pst.setString(2,idBeli);
                pst.executeUpdate();
            }
            
            
            conn.commit();
           
        }
        
        catch(SQLException e)
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
    public ArrayList<Cicilan> cariDataById(String id) {
        try 
        {
            arrayListCicilan=new ArrayList<>();
            conn=(Connection)koneksi.configDB();
            sql="SELECT id_beli,MAX(cicilan_ke) AS cicilan_ke, MAX(tgl_bayar) AS tgl_bayar FROM cicilan WHERE id_beli=?  HAVING MAX(tgl_bayar) IS NOT NULL ";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            rs=pst.executeQuery();
            
            if(rs.next())
            {
                cicilan=new Cicilan();
                cicilan.setIdBeli(rs.getInt("id_beli"));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                cicilan.setTglCicil(rs.getString("tgl_bayar"));
                
                arrayListCicilan.add(cicilan);
            }
            
            
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return arrayListCicilan;
    }

   
    
}
