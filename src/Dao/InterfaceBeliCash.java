/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.BeliCash;
import Model.Pelanggan;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfaceBeliCash {
    
    public String autoNumber();
    public ArrayList<BeliCash> showDataBeli();
    public void tambahPembelian(BeliCash beliCash);
    public void editPembelian(BeliCash beliCash, int idLamaMotor);
    public void deletePembelian(String idBeli,String idMotor);
    public ArrayList<BeliCash>searchById(String id);
    public ArrayList<BeliCash>searchByKode(String no);
    public ArrayList<BeliCash>searchByName(String nama);
    
}
