/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Mobil;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfaceMobil {
    
    public String autoNumber();
    public ArrayList<Mobil>showDataMobil();
    public ArrayList<Mobil>searchNamaMobil(String nama);
    public ArrayList<Mobil>searchMerkMobil(String merk);
    public void saveDataMobil(Mobil mobil);
    public void updateDataMobil(Mobil mobil);
    public void  deleteDataMobil(int id);
    
}
