/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cicilan;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfaceCicilan {
    
    public void bayarCicilan(Cicilan cicilan);
    public void updateStatus(String idBeli);
    public boolean cekCicilan(int id);
    public void hapusCicilan(int idCicilan);
    public ArrayList<Cicilan>showDataCicilan();
    public ArrayList<Cicilan>cariDataByKode(String kode);
    public ArrayList<Cicilan>cariDatByNama(String nama);
    public ArrayList<Cicilan>cariDataById(String id);
    public String autoNumber();
    
}
