/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.BeliCash;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class  TableDataBeliCredit extends AbstractTableModel {

    ArrayList<BeliCash> arrayListBeliCredit;
    
    @Override
    public int getRowCount() {
        return arrayListBeliCredit.size();
    }

    @Override
    public int getColumnCount() {
        return  14;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex)
        {
            case 0:return arrayListBeliCredit.get(rowIndex).getNoBeli();
            case 1: return arrayListBeliCredit.get(rowIndex).getNoKtp();
            case 2: return arrayListBeliCredit.get(rowIndex).getNama();
            case 3: return arrayListBeliCredit.get(rowIndex).getJeniKelamin();
            case 4: return arrayListBeliCredit.get(rowIndex).getNoTelp();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {

        switch(column)
        {
            case 0: return "No Beli";
            case 1: return "No KTP";
            case 2: return "Nama";
            case 3: return "Jenis Kelamin";
            case 4: return "No Telp";
            case 5: return "Kode Motor";
            case 6: return "Nama Motor";
            case 9: return "Merk Motor";
            case 10: return "Warna";
            case 11: return "Harga";
            case 12: return "Tanggal";
            case 13: return "Status";
            
            default: return null;
        }
        
    }
    
    
    
}
