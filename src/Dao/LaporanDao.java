/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conn.koneksi;
import Model.BeliCash;
import Model.BeliCredit;
import Model.Cicilan;
import Model.Motor;
import Model.Paket;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LaporanDao implements InterfaceLaporan{

    ArrayList<Motor>motorArrayList=new ArrayList<>();
    ArrayList<Paket>paketArrayList=new ArrayList<>();
    ArrayList<Cicilan>cicilanArrayList=new ArrayList<>();
    ArrayList<BeliCredit>beliCreditArrayList=new ArrayList<>();
    ArrayList<BeliCash>beliCashArrayList=new ArrayList<>();
    BeliCash beliCash;
    
    Date tglBayar;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    
    Motor motor;
    Paket paket;
    BeliCredit beliCredit;
    Cicilan cicilan;
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
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

    @Override
    public ArrayList<BeliCash> laporanBeliCash() {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_belicash";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) 
            {
               beliCash=new BeliCash();
               
               tglBayar=sdf.parse(rs.getString("tgl_beli"));
               sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
               
               beliCash.setIdBeli(rs.getInt("id_beli"));
               beliCash.setNoBeli(rs.getString("no_beli"));
               beliCash.setNama(rs.getString("nama"));
               beliCash.setNamaMotor(rs.getString("nama_motor"));
               beliCash.setMerkMotor(rs.getString("merk"));
               beliCash.setWarnaMotor(rs.getString("warna"));
               beliCash.setHargaMotor(rs.getInt("harga"));
               beliCash.setTglBeli(sdf.format(tglBayar));
               beliCash.setAlamat(rs.getString("alamat"));
               
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
    public ArrayList<BeliCash> laporanBeliCashByKodeTransaksi(String kode) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_belicash where no_beli=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            while (rs.next()) 
            {
               beliCash=new BeliCash();
               
               tglBayar=sdf.parse(rs.getString("tgl_beli"));
               sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
               
               beliCash.setIdBeli(rs.getInt("id_beli"));
               beliCash.setNoBeli(rs.getString("no_beli"));
               beliCash.setNama(rs.getString("nama"));
               beliCash.setNamaMotor(rs.getString("nama_motor"));
               beliCash.setMerkMotor(rs.getString("merk"));
               beliCash.setWarnaMotor(rs.getString("warna"));
               beliCash.setHargaMotor(rs.getInt("harga"));
               
               beliCash.setTglBeli(sdf.format(tglBayar));
               beliCash.setAlamat(rs.getString("alamat"));
               
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
    public ArrayList<BeliCash> laporanBeliCashByNamaPembeli(String nama) {
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_belicash where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            while (rs.next()) 
            {
               beliCash=new BeliCash();
               
               tglBayar=sdf.parse(rs.getString("tgl_beli"));
               sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
               
               beliCash.setIdBeli(rs.getInt("id_beli"));
               beliCash.setNoBeli(rs.getString("no_beli"));
               beliCash.setNama(rs.getString("nama"));
               beliCash.setNamaMotor(rs.getString("nama_motor"));
               beliCash.setMerkMotor(rs.getString("merk"));
               beliCash.setWarnaMotor(rs.getString("warna"));
               beliCash.setHargaMotor(rs.getInt("harga"));
               
               beliCash.setTglBeli(sdf.format(tglBayar));
               beliCash.setAlamat(rs.getString("alamat"));
               
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
    public ArrayList<BeliCredit> laporanBeliCredit() {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_belicredit";
            
            pst=conn.prepareStatement(sql);
            
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCredit=new BeliCredit();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTglBeli(sdf.format(tglBayar));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setStatus(rs.getString("status"));
                
                beliCreditArrayList.add(beliCredit);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beliCreditArrayList;
    }

    @Override
    public ArrayList<BeliCredit> laporanBeliCreditByKodeTransaksi(String kode) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_belicredit WHERE no_beli=?";
            
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCredit=new BeliCredit();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTglBeli(sdf.format(tglBayar));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setStatus(rs.getString("status"));
                
                beliCreditArrayList.add(beliCredit);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beliCreditArrayList;
    }

    @Override
    public ArrayList<BeliCredit> laporanBeliCreditByNama(String nama) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_belicredit where nama=?";
            
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                beliCredit=new BeliCredit();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                beliCredit.setIdBeli(rs.getInt("id_beli"));
                beliCredit.setNoBeli(rs.getString("no_beli"));
                beliCredit.setNama(rs.getString("nama"));
                beliCredit.setNamaMotor(rs.getString("nama_motor"));
                beliCredit.setMerkMotor(rs.getString("merk"));
                beliCredit.setWarna(rs.getString("warna"));
                beliCredit.setHarga(rs.getInt("harga_total"));
                beliCredit.setTglBeli(sdf.format(tglBayar));
                beliCredit.setAlamat(rs.getString("alamat"));
                beliCredit.setStatus(rs.getString("status"));
                
                beliCreditArrayList.add(beliCredit);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beliCreditArrayList;
    }

    @Override
    public ArrayList<Cicilan> laporanCicilan() {
        
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_cicilan";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                cicilan=new Cicilan();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setNamaMotor(rs.getString("nama_motor"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
                cicilan.setDenda(rs.getInt("denda"));
                cicilan.setTglCicil(sdf.format(tglBayar));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                cicilanArrayList.add(cicilan);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return cicilanArrayList;
    }

    @Override
    public ArrayList<Cicilan> laporanCicilanByKodeCicilan(String kode) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_cicilan where kode_cicilan=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, kode);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                cicilan=new Cicilan();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setNamaMotor(rs.getString("nama_motor"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
                cicilan.setDenda(rs.getInt("denda"));
                cicilan.setTglCicil(sdf.format(tglBayar));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                cicilanArrayList.add(cicilan);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return cicilanArrayList;
    }

    @Override
    public ArrayList<Cicilan> laporanCicilanByNama(String nama) {
        try 
        {
            conn=(Connection)koneksi.configDB();
            sql="select * from view_laporan_cicilan where nama=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, nama);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                cicilan=new Cicilan();
                
                tglBayar=sdf.parse(rs.getString("tgl_beli"));
                sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                
                cicilan.setIdCicilan(rs.getInt("id_cicilan"));
                cicilan.setKodeCicilan(rs.getString("kode_cicilan"));
                cicilan.setNama(rs.getString("nama"));
                cicilan.setNamaMotor(rs.getString("nama_motor"));
                cicilan.setJumlahBayar(rs.getInt("jml_bayar"));
                cicilan.setStatus(rs.getString("status_cicilan"));
                cicilan.setDenda(rs.getInt("denda"));
                cicilan.setTglCicil(sdf.format(tglBayar));
                cicilan.setCicilanKe(rs.getInt("cicilan_ke"));
                
                cicilanArrayList.add(cicilan);
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return cicilanArrayList;
    }

    
    
    
    
}
