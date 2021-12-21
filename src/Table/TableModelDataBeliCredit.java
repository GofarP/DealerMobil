/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.BeliCredit;
import java.text.NumberFormat;
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
        return 14;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return arrayListBeliCredit.get(rowIndex).getNoBeli();
            case 1: return arrayListBeliCredit.get(rowIndex).getNama();
            case 2: return arrayListBeliCredit.get(rowIndex).getJenisKelamin();
            case 3: return arrayListBeliCredit.get(rowIndex).getNoTelp();
            case 4: return arrayListBeliCredit.get(rowIndex).getNamaMotor();
            case 5: return arrayListBeliCredit.get(rowIndex).getMerkMotor();
            case 6: return arrayListBeliCredit.get(rowIndex).getWarna();
            case 7: return arrayListBeliCredit.get(rowIndex).getJumlahCicilan();
            case 8: return "Rp."+NumberFormat.getInstance().format(arrayListBeliCredit.get(rowIndex).getNilaiCicilan());
            case 9: return arrayListBeliCredit.get(rowIndex).getBunga()+"%";
            case 10: return "Rp."+NumberFormat.getInstance().format(arrayListBeliCredit.get(rowIndex).getUangMuka());
            case 11: return "Rp."+NumberFormat.getInstance().format(arrayListBeliCredit.get(rowIndex).getHarga());
            case 12: return arrayListBeliCredit.get(rowIndex).getTanggal();
            case 13: return arrayListBeliCredit.get(rowIndex).getStatus();
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
           switch(column)
        {
            case 0: return "No Beli";
            case 1: return "Nama";
            case 2: return "Jenis Kelamin";
            case 3: return "No Telp";
            case 4: return "Nama Motor";
            case 5: return "Merk Motor";
            case 6: return "Warna";
            case 7: return "Jumlah Cicilan";
            case 8: return "Nilai cicilan";
            case 9: return "Bunga";
            case 10: return "Uang Muka";
            case 11: return "Harga";
            case 12: return "Tanggal";
            case 13: return "Status";
            
            default: return null;
        }
    }
    
    
}
