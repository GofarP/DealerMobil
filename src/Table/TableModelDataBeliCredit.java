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
public class TableModelDataBeliCredit extends AbstractTableModel{

    ArrayList<BeliCredit> arrayListBeliCredit;
    
    public TableModelDataBeliCredit(ArrayList<BeliCredit> arrayListBeliCredit) {
       this.arrayListBeliCredit=arrayListBeliCredit;
    }

    @Override
    public int getRowCount() {
       return arrayListBeliCredit.size();
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return arrayListBeliCredit.get(rowIndex).getNoBeli();
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
            case 13: return arrayListBeliCredit.get(rowIndex).getHarga();
            case 14: return arrayListBeliCredit.get(rowIndex).getTanggal();
            case 15: return arrayListBeliCredit.get(rowIndex).getStatus();
            
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
            case 9: return "Jumlah Cicilan";
            case 10: return "Nilai cicilan";
            case 11: return "Bunga";
            case 12: return "Uang Muka";
            case 13: return "Harga";
            case 14: return "Tanggal";
            case 15: return "Status";
            
            default: return null;
        }
    }
    
    
}
