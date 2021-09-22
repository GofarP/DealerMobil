/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.Paket;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataPaket extends AbstractTableModel{

    ArrayList<Paket>paketArrayList=new ArrayList<>();

    public TableModelDataPaket(ArrayList<Paket>paketArrayList) 
    {
        this.paketArrayList=paketArrayList;
    }
    
    
    @Override
    public int getRowCount() {
        return paketArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        switch(columnIndex)
        {
            case 0: return paketArrayList.get(rowIndex).getKodePaket();
            case 1: return paketArrayList.get(rowIndex).getNamaMotor();
            case 2: return paketArrayList.get(rowIndex).getMerkMotor();
            case 3: return paketArrayList.get(rowIndex).getWarnaMotor();
            case 4: return paketArrayList.get(rowIndex).getJumlahCicilan();
            case 5: return paketArrayList.get(rowIndex).getNilaiCicilan();
            case 6: return paketArrayList.get(rowIndex).getBunga();
            case 7: return paketArrayList.get(rowIndex).getUangMuka();
            case 8: return paketArrayList.get(rowIndex).getHargaTotal();
            
            default:return null;
        }
        
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column)
        {
            case 0: return "Kode Paket";
            case 1: return "Nama Mobil";
            case 2: return "Merk";
            case 3:return "Warna";
            case 4: return "Jml Cicilan";
            case 5: return "Nilai Cicilan";
            case 6: return "Bunga";
            case 7: return "Uang Muka";
            case 8: return "Total";
            
            default: return null;
        }
    }
    
    
}
