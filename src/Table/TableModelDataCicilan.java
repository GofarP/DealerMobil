/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.Cicilan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataCicilan extends AbstractTableModel{
    
    ArrayList<Cicilan>arrayListCicilan;
    
    public TableModelDataCicilan(ArrayList<Cicilan>arrayListCicilan)
    {
        this.arrayListCicilan=arrayListCicilan;
    }
    
    @Override
    public int getRowCount() {
        return arrayListCicilan.size();
    }

    @Override
    public int getColumnCount() {
        return 14;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex)
        {
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column)
        {
            case 0: return "Kode Cicilan";
            case 1: return "Nama Pembeli";
            case 2: return "Kode Paket";
            case 3: return "Kode Motor";
            case 4: return "Nama Motor";
            case 5: return "Merk Motor";
            case 6: return "Warna Motor";
            case 7: return "Jumlah Cicilan";
            case 8: return "Nilai Cicilan";
            case 9: return "Bunga";
            case 10: return "Uang Muka";
            case 11: return "Harga Total";
            case 12: return "Cicilan ke";
            case 13: return "Tanggal Cicil";
            
            default: return null;
        }
    }
    
    
}
