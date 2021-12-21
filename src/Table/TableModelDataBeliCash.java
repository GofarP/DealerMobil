/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Model.BeliCash;
import Model.Pelanggan;
import Model.Motor;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class TableModelDataBeliCash extends AbstractTableModel{

    ArrayList<BeliCash>beliArrayList;
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    Date date=new Date();
    
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
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        switch(columnIndex)
        {
                
            case 0:return  beliArrayList.get(rowIndex).getNoBeli();
            case 1:return  beliArrayList.get(rowIndex).getNama();
            case 2:return  beliArrayList.get(rowIndex).getJeniKelamin();
            case 3:return  beliArrayList.get(rowIndex).getAlamat();
            case 4:return  beliArrayList.get(rowIndex).getNoTelp();
            case 5:return  beliArrayList.get(rowIndex).getNamaMotor();
            case 6:return  beliArrayList.get(rowIndex).getMerkMotor();
            case 7:return  beliArrayList.get(rowIndex).getWarnaMotor();
            case 8:return  "Rp."+NumberFormat.getInstance().format(beliArrayList.get(rowIndex).getHargaMotor());
            case 9: return beliArrayList.get(rowIndex).getTglBeli();
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column)
        {
            case 0: return "No Beli";
            case 1: return "Nama";
            case 2: return "Jenis Kelamin";
            case 3: return "Alamat";
            case 4: return "No.Telp";
            case 5: return "Nama Motor";
            case 6: return "Merk Motor";
            case 7: return "Warna";
            case 8: return "Harga";
            case 9: return "tanggal";
            
            default:return null;
        }
        
    }
    
    
}
