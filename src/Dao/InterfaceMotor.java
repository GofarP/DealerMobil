/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Motor;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface InterfaceMotor {
    
    public String autoNumber();
    public ArrayList<Motor>showDataMotor();
    public ArrayList<Motor>searchKodeMotor(String kode);
    public ArrayList<Motor>searchNamaMotor(String nama);
    public ArrayList<Motor>searchMerkMotor(String merk);
    public void saveDataMotor(Motor motor);
    public void updateDataMotor(Motor motor);
    public void  deleteDataMotor(int id);
    
}
