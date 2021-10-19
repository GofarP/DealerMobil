/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.BeliCash;
import Model.BeliCredit;
import Model.Cicilan;
import Model.Motor;
import Model.Paket;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfaceLaporan {
    
    public ArrayList<Motor>laporanMotor();
    public ArrayList<Motor>laporanMotorByKode(String kode);
    public ArrayList<Motor>laporanMotorByMerk(String merk);
    public ArrayList<Motor>laporanMotorByNama(String nama);
    public ArrayList<Motor>laporanMotorByWarna(String warna);
    
    public ArrayList<Paket>laporanPaket();
    public ArrayList<Paket>laporanPaketByKodePaket(String kodePaket);
    public ArrayList<Paket>laporanPaketByNama(String nama);
    
    public ArrayList<BeliCash>laporanBeliCash();
    public ArrayList<BeliCash>laporanBeliCashByKodeTransaksi(String kode);
    public ArrayList<BeliCash>laporanBeliCashByNamaPembeli(String namaPembeli);
    
    public ArrayList<BeliCredit>laporanBeliCredit();
    public ArrayList<BeliCredit>laporanBeliCreditByKodeTransaksi(String kode);
    public ArrayList<BeliCredit>laporanBeliCreditByNama(String namaPembeli);
    
    public ArrayList<Cicilan>laporanCicilan();
    public ArrayList<Cicilan>laporanCicilanByKodeCicilan(String kode);
    public ArrayList<Cicilan>laporanCicilanByNama(String nama);
    
    
    
    
    
    
}
