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
    
//    private Pelanggan pelanggan=new Pelanggan();
//    private Pembelian pembelian=new Pembelian();
//    private Motor motor=new Motor(); 
    private int idBeli, idMotor, hargaMotor;
    private String noBeli, noKtp, nama, jenisKelamin,alamat, noTelp, kodeMotor, namaMotor;
    private String merkMotor,warnaMotor, status, tglBeli;
    
    
            
    public int getIdBeli()
    {
        return  idBeli;
    }
    
    public void setIdBeli(int idBeli)
    {
        this.idBeli=idBeli;
    }
    
    public String getNoBeli() {
        return noBeli;
    }

    public void setNoBeli(String noBeli) {
       this.noBeli=noBeli;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp=noKtp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama=nama;
    }

    public String getJeniKelamin() {
        return jenisKelamin;
    }

    public void setJeniKelamin(String jenisKelamin) {
        this.jenisKelamin=jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat=alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp=noTelp;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
       this.idMotor=idMotor;
    }
    
    
    public String getKodeMotor() {
        return kodeMotor;
    }

    public void setKodeMotor(String kodeMotor) {
        this.kodeMotor=kodeMotor;
    }

    public String getNamaMotor() {
        return namaMotor;
    }

    public void setNamaMotor(String namaMotor) {
        this.namaMotor=namaMotor;
    }

    public String getMerkMotor() {
        return merkMotor;
    }

    public void setMerkMotor(String merkMotor) {
       this.merkMotor=merkMotor;
    }
    
    public String getWarnaMotor() {
       return warnaMotor;
    }

    public void setWarnaMotor(String warnaMotor) {
       this.warnaMotor=warnaMotor;
    }
    
    public int getHargaMotor() {
       return  hargaMotor;
    }

    public void setHargaMotor(int hargaMotor) {
        this.hargaMotor=hargaMotor;
    }
    
    
    public String getStatus() {
       return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public String getTglBeli() {
        return tglBeli;
    }

    public void setTglBeli(String tglBeli) {
        this.tglBeli=tglBeli;
    }
    
    
    
}
