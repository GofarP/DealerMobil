/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.Cicilan;
import java.text.NumberFormat;
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
        return 12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return arrayListCicilan.get(rowIndex).getKodeCicilan();
            case 1: return arrayListCicilan.get(rowIndex).getNama();
            case 2: return arrayListCicilan.get(rowIndex).getKodePaket();
            case 3: return arrayListCicilan.get(rowIndex).getNamaMotor();
            case 4: return arrayListCicilan.get(rowIndex).getWarnaMotor();
            case 5: return arrayListCicilan.get(rowIndex).getJumlahCicilan();
            case 6: return "Rp."+NumberFormat.getInstance().format(arrayListCicilan.get(rowIndex).getNilaiCicilan());
            case 7: return arrayListCicilan.get(rowIndex).getBunga()+"%";
            case 8: return "Rp."+NumberFormat.getInstance().format(arrayListCicilan.get(rowIndex).getUangMuka());
            case 9: return "Rp."+NumberFormat.getInstance().format(arrayListCicilan.get(rowIndex).getHargaTotal());
            case 10: return arrayListCicilan.get(rowIndex).getCicilanKe();
            case 11: return arrayListCicilan.get(rowIndex).getTglCicil();
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
            case 3: return "Nama Motor";
            case 4: return "Warna Motor";
            case 5: return "Jumlah Cicilan";
            case 6: return "Nilai Cicilan";
            case 7: return "Bunga";
            case 8: return "Uang Muka";
            case 9: return "Harga Total";
            case 10: return "Cicilan ke";
            case 11: return "Tanggal Cicil";
            
            default: return null;
        }
    }
    
    
}
