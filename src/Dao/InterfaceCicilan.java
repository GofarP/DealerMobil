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
    public boolean telatBayar();
    public void hapusCicilan(int idCicilan);
    public ArrayList<Cicilan>showDataCicilan();
    public ArrayList<Cicilan>cariDataByKode(String kode);
    public ArrayList<Cicilan>cariDatByNama(String nama);
    public String autoNumber();
    
}
