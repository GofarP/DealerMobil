/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.Motor;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataMotor extends AbstractTableModel{
    
    ArrayList<Motor>motorArrayList;
    
    public TableModelDataMotor(ArrayList<Motor>motorArrayList)
    {   
        this.motorArrayList=motorArrayList;
    }

    @Override
    public int getRowCount() {
        return motorArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return motorArrayList.get(rowIndex).getId();
            case 1: return motorArrayList.get(rowIndex).getKodeMotor();
            case 2: return motorArrayList.get(rowIndex).getNama();
            case 3: return motorArrayList.get(rowIndex).getMerk();
            case 4: return motorArrayList.get(rowIndex).getWarna();
            case 5: return motorArrayList.get(rowIndex).getStok();
            case 6: return "Rp."+NumberFormat.getInstance().format(motorArrayList.get(rowIndex).getHarga());
            
            default:return null;
        }
    }

    
    @Override
    public String getColumnName(int column) {
         switch(column)
        {
            case 0: return "ID";
            case 1: return "Kode Motor";
            case 2: return "Nama Motor";
            case 3: return "Merk";
            case 4: return "Warna";
            case 5: return "Stok";
            case 6: return "Harga";
            
            default :return  null;
         }
    }
    
    
    
}
