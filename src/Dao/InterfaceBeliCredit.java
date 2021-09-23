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
    
    public ArrayList<BeliCredit> showDataBeliCredit();
    public ArrayList<BeliCredit> searchDataKreditByKode(String kode);
    public ArrayList<BeliCredit> searchDatKreditByNama(String nama);
    public void tambahData();
    public void editData();
    public void deletedata(int id);
    
}
