/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class BeliCash {
    
    private Pelanggan pelanggan;
    private Pembelian pembelian;
    private Mobil mobil; 
    private Date tglbayar;
    
    public String getIdBeli()
    {
        return  pembelian.getIdBeli();
    }
    
    public void setIdBeli(String idBeli)
    {
        pembelian.setIdBeli(idBeli);
    }
    
    public String getNoBeli() {
        return pembelian.getNoBeli();
    }

    public void setNoBeli(String noBeli) {
        pembelian.setNoBeli(noBeli);
    }

    public String getNoKtp() {
        return pelanggan.getNoKtp();
    }

    public void setNoKtp(String noKtp) {
        pelanggan.setAlamat(noKtp);
    }

    public String getNama() {
        return pelanggan.getNama();
    }

    public void setNama(String nama) {
        pelanggan.setNama(nama);
    }

    public String getJeniKelamin() {
        return pelanggan.getJeniKelamin();
    }

    public void setJeniKelamin(String jeniKelamin) {
       pelanggan.setJeniKelamin(jeniKelamin);
    }

    public String getAlamat() {
        return pelanggan.getAlamat();
    }

    public void setAlamat(String alamat) {
        pelanggan.setAlamat(alamat);
    }

    public String getNoTelp() {
        return pelanggan.getNoTelp();
    }

    public void setNoTelp(String noTelp) {
        pelanggan.setNoTelp(noTelp);
    }

    public int getIdMobil() {
        return mobil.getId();
    }

    public void setIdMobil(int idMobil) {
        mobil.setId(idMobil);
    }
    
    
    public String getKodeMobil() {
        return mobil.getKodeMobil();
    }

    public void setKodeMobil(String kodeMobil) {
        mobil.setKodeMobil(kodeMobil);
    }

    public String getNamaMobil() {
        return mobil.getNama();
    }

    public void setNamaMobil(String namaMobil) {
        mobil.setNama(namaMobil);
    }

    public String getMerkMobil() {
        return mobil.getMerk();
    }

    public void setMerkMobil(String merkMobil) {
        mobil.setMerk(merkMobil);
    }
    
    public String getWarnaMobil() {
        return mobil.getWarna();
    }

    public void setWarnaMobil(String warnaMobil) {
        mobil.setWarna(warnaMobil);
    }
    
    public int getHargaMobil() {
        return mobil.getHarga();
    }

    public void setHargaMobil(int hargaMobil) {
        mobil.setHarga(hargaMobil);
    }
    
    
    public String getStatus() {
        return pembelian.getStatus();
    }

    public void setStatus(String status) {
        pembelian.setStatus(status);
    }

    public Date getTglbayar() {
        return tglbayar;
    }

    public void setTglbayar(Date tglbayar) {
        this.tglbayar = tglbayar;
    }
    
    
    
}
