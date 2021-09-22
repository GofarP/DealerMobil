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
    
    private Pelanggan pelanggan=new Pelanggan();
    private Pembelian pembelian=new Pembelian();
    private Motor motor=new Motor(); 
    
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
        pelanggan.setNoKtp(noKtp);
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

    public int getIdMotor() {
        return motor.getId();
    }

    public void setIdMotor(int idMotor) {
        motor.setId(idMotor);
    }
    
    
    public String getKodeMotor() {
        return motor.getKodeMotor();
    }

    public void setKodeMotor(String kodeMotor) {
        motor.setKodeMotor(kodeMotor);
    }

    public String getNamaMotor() {
        return motor.getNama();
    }

    public void setNamaMotor(String namaMotor) {
        motor.setNama(namaMotor);
    }

    public String getMerkMotor() {
        return motor.getMerk();
    }

    public void setMerkMotor(String merkMotor) {
        motor.setMerk(merkMotor);
    }
    
    public String getWarnaMotor() {
        return motor.getWarna();
    }

    public void setWarnaMotor(String warnaMotor) {
        motor.setWarna(warnaMotor);
    }
    
    public int getHargaMotor() {
        return motor.getHarga();
    }

    public void setHargaMotor(int hargaMotor) {
        motor.setHarga(hargaMotor);
    }
    
    
    public String getStatus() {
        return pembelian.getStatus();
    }

    public void setStatus(String status) {
        pembelian.setStatus(status);
    }

    public String getTglbayar() {
        return pembelian.getTglbayar();
    }

    public void setTglbayar(String tglbayar) {
        pembelian.setTglbayar(tglbayar);
    }
    
    
    
}
