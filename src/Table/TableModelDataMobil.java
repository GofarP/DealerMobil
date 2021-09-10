/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.Mobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataMobil extends AbstractTableModel{
    
    ArrayList<Mobil>mobilArrayList;
    
    public TableModelDataMobil(ArrayList<Mobil>mobilArrayList)
    {   
        this.mobilArrayList=mobilArrayList;
    }

    @Override
    public int getRowCount() {
        return mobilArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return mobilArrayList.get(rowIndex).getId();
            case 1: return mobilArrayList.get(rowIndex).getKodeMobil();
            case 2: return mobilArrayList.get(rowIndex).getNama();
            case 3: return mobilArrayList.get(rowIndex).getMerk();
            case 4: return mobilArrayList.get(rowIndex).getWarna();
            case 5: return mobilArrayList.get(rowIndex).getStok();
            case 6: return mobilArrayList.get(rowIndex).getHarga();
            
            default:return null;
        }
    }

    
    @Override
    public String getColumnName(int column) {
         switch(column)
        {
            case 0: return "ID";
            case 1: return "Kode Mobil";
            case 2: return "Nama Mobil";
            case 3: return "Merk";
            case 4: return "Warna";
            case 5: return "Stok";
            case 6: return "Harga";
            
            default :return  null;
         }
    }
    
    
    
}
