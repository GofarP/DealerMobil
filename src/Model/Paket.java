/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Paket {
    private Motor motor;
    private int idPaket,idMotor, nilaiCicilan, jumlahCicilan, bunga, uangMuka, hargaTotal, stok;
    private String kodePaket, kodeMotor, nama, merk, warna;

    public int getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(int idPaket) {
        this.idPaket = idPaket;
    }

    public String getKodePaket() {
        return kodePaket;
    }

    public void setKodePaket(String kodePaket) {
        this.kodePaket = kodePaket;
    }
    

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor=idMotor;
    }
    
    public String getKodeMotor()
    {
        return kodeMotor;
    }
    
    public void setKodeMotor(String kodeMotor)
    {
        this.kodeMotor=kodeMotor;
    }
    
    public int getStok()
    {
        return stok;
    }
    
    public void setStok(int stok)
    {
       this.stok=stok;
    }
    
    public String getNamaMotor()
    {
        return nama;
    }
    
    public void setNamaMotor(String namaMotor)
    {
       this.nama=namaMotor;
    }
    
    public String getMerkMotor()
    {
        return merk;
    }
    
    public void setMerkMotor(String merk)
    {
        this.merk=merk;
    }
    
    public String getWarnaMotor()
    {
        return warna;
    }
    
    public void setWarnaMotor(String warna)
    {
       this.warna=warna;
    }
    
    public int getJumlahCicilan() {
        return jumlahCicilan;
    }

    public void setJumlahCicilan(int cicilan) {
        this.jumlahCicilan = cicilan;
    }

    public int getNilaiCicilan() {
        return nilaiCicilan;
    }

    public void setNilaiCicilan(int nilaiCicilan) {
        this.nilaiCicilan = nilaiCicilan;
    }
    
    

    public int getBunga() {
        return bunga;
    }

    public void setBunga(int bunga) {
        this.bunga = bunga;
    }

    public int getUangMuka() {
        return uangMuka;
    }

    public void setUangMuka(int uangMuka) {
        this.uangMuka = uangMuka;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
    
    
    
    
    
}
