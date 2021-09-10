/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.BeliCash;
import Model.Pelanggan;
import Model.Mobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataBeliCash extends AbstractTableModel{

    ArrayList<BeliCash>beliArrayList;
    
    public TableModelDataBeliCash(ArrayList<BeliCash>beliArrayList)
    {
        this.beliArrayList=beliArrayList;
    }
    
    @Override
    public int getRowCount() {
        return beliArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
//            case 0: return beliArrayList.get(rowIndex).getIdBeli();
//            case 1: return beliArrayList.get(rowIndex).getNoKtp();
//            case 2:return  beliArrayList.get(rowIndex).getNoBeli();
//            case 3:return  beliArrayList.get(rowIndex).getNama();
//            case 4:return  beliArrayList.get(rowIndex).getJeniKelamin();
//            case 5:return  beliArrayList.get(rowIndex).getAlamat();
//            case 6:return  beliArrayList.get(rowIndex).getNoTelp();
//            case 7:return  beliArrayList.get(rowIndex).getIdMobil();
//            case 8:return  beliArrayList.get(rowIndex).getNamaMobil();
//            case 9:return  beliArrayList.get(rowIndex).getMerkMobil();
//            case 10:return  beliArrayList.get(rowIndex).getWarnaMobil();
//            case 11:return  beliArrayList.get(rowIndex).getHargaMobil();
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column)
        {
            case 0: return "ID Beli";
            case 1: return "No Ktp";
            case 2: return "No Beli";
            case 3: return "Nama";
            case 4: return "Jenis Kelamin";
            case 5: return "Alamat";
            case 6: return "No.Telp";
            case 7: return "ID Mobil";
            case 8: return "Nama Mobil";
            case 9: return "Merk Mobil";
            case 10: return "Warna";
            case 11: return "Harga";
            
            default:return null;
        }
        
    }
    
    
}
