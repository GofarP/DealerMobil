/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import Model.BeliCredit;
/**
 *
 * @author LENOVO
 */
public interface InterfaceBeliCredit {
    
    public String noOtomatis();
    public ArrayList<BeliCredit> showDataBeliCredit();
    public ArrayList<BeliCredit> searchDataKreditById(String id);
    public ArrayList<BeliCredit> searchDataKreditByKode(String kode);
    public ArrayList<BeliCredit> searchDatKreditByNama(String nama);
    public void tambahData(BeliCredit beliCredit);
    public void editData(BeliCredit beliCredit, String idLamaPaket);
    public void deletedata(int idBeli, int idMotor);
    public boolean cekCicilan(int id);
    public boolean cekStok(int idMotor);
    
}
