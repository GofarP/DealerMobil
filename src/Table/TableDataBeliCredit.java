/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.BeliCredit;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class  TableDataBeliCredit extends AbstractTableModel {

    ArrayList<BeliCredit> arrayListBeliCredit;
    BeliCredit beliCredit;
    
    @Override
    public int getRowCount() {
        return arrayListBeliCredit.size();
    }

    @Override
    public int getColumnCount() {
        return  12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex)
        {
            case 0:return arrayListBeliCredit.get(rowIndex).getNoBeli();
            case 1: return arrayListBeliCredit.get(rowIndex).getNoKtp();
            case 2: return arrayListBeliCredit.get(rowIndex).getNama();
            case 3: return arrayListBeliCredit.get(rowIndex).getJenisKelamin();
            case 4: return arrayListBeliCredit.get(rowIndex).getNoTelp();
            case 5: return arrayListBeliCredit.get(rowIndex).getKodeMotor();
            case 6: return arrayListBeliCredit.get(rowIndex).getNamaMotor();
            case 7: return arrayListBeliCredit.get(rowIndex).getMerkMotor();
            case 8: return arrayListBeliCredit.get(rowIndex).getWarna();
            case 9: return arrayListBeliCredit.get(rowIndex).getJumlahCicilan();
            case 10: return arrayListBeliCredit.get(rowIndex).getNilaiCicilan();
            case 11: return arrayListBeliCredit.get(rowIndex).getBunga();
            case 12: return arrayListBeliCredit.get(rowIndex).getUangMuka();
            
           
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
            case 7: return "Merk Motor";
            case 8: return "Warna";
            case 10: return "Jumlah Cicilan";
            case 11: return "Nilai cicilan";
            case 12: return "Bunga";
            case 13: return "Uang Muka";
            case 14: return "Harga";
            case 15: return "Tanggal";
            case 16: return "Status";
            
            default: return null;
        }
        
    }
    
    
    
}
