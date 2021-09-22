/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
    
    
    
    
    
}
