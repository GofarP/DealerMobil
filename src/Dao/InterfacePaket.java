/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Paket;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfacePaket {
    
    public String autoNumber();
    public ArrayList<Paket> showDataPaket();
    public ArrayList<Paket> searchDataPaketByKode(String kode);
    public ArrayList<Paket> searchDataPaketByMotor(String nama);
    public void tambahPaket(Paket paket);
    public void editPaket(int idpaket);
    public void deletePacket(int idpaket);
    
}
