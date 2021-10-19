/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.InterfaceLaporan;
import Dao.LaporanDao;
import Form.LaporanForm;
import Model.BeliCash;
import Model.BeliCredit;
import Model.Cicilan;
import Model.Motor;
import Model.Paket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class LaporanController {
    
    LaporanForm laporanForm;
    ArrayList<Motor>motorArrayList;
    ArrayList<Paket>paketArrayList;
    ArrayList<BeliCash>beliCashArrayList;
    ArrayList<BeliCredit>beliCreditArrayList;
    ArrayList<Cicilan>cicilanCreditArrayList;
    
    InterfaceLaporan interfaceLaporan;
    
    JRBeanCollectionDataSource itemsJRBean=null;
    Map<String, Object> parameters = new HashMap<String, Object>();
    JasperPrint jasperPrint=null;
    JasperViewer jasperViewer=null;
    
    public LaporanController(LaporanForm laporanForm)
    {
        this.laporanForm=laporanForm;
        interfaceLaporan=new LaporanDao();

    }
    
    
    public void cetakLaporanMotor()
    {
        try 
        {
            int index=laporanForm.getCbMotorBerdasarkan().getSelectedIndex();
        
            String cari=laporanForm.getTxtCariMotor().getText().trim();

            switch(index)
            {
                case 0:
                    motorArrayList=interfaceLaporan.laporanMotor();
                    break;

                case 1:
                    motorArrayList=interfaceLaporan.laporanMotorByKode(cari);
                    break;

                case 2:
                    motorArrayList=interfaceLaporan.laporanMotorByMerk(cari);
                    break;

                case 3:
                    motorArrayList=interfaceLaporan.laporanMotorByNama(cari);
                    break;

                case 4:
                    motorArrayList=interfaceLaporan.laporanMotorByWarna(cari);
                    break;
            }
            
             itemsJRBean = new JRBeanCollectionDataSource(motorArrayList);
             parameters.put("MotorDataSource", itemsJRBean);
             
             jasperPrint = JasperFillManager.fillReport("src/report/LaporanMotor.jasper", parameters, new JREmptyDataSource());
             jasperViewer=new JasperViewer(jasperPrint, false);
             jasperViewer.viewReport(jasperPrint,false);
             
             motorArrayList.clear();
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    public void cetakLaporanPaket()
    {
        try
        {
           
            int index=laporanForm.getCbPaketBerdasarkan().getSelectedIndex();
        
            String cari=laporanForm.getTxtCariPaket().getText().trim();
            
            switch(index)
            {
                case 0:
                    paketArrayList=interfaceLaporan.laporanPaket();
                    break;
                    
                case 1:
                    paketArrayList=interfaceLaporan.laporanPaketByKodePaket(cari);
                    break;
                    
                case 2:
                    paketArrayList=interfaceLaporan.laporanPaketByNama(cari);
                    break;
            }
            
            itemsJRBean = new JRBeanCollectionDataSource(paketArrayList);
            parameters.put("PaketDataSource", itemsJRBean);
            
            jasperPrint = JasperFillManager.fillReport("src/report/LaporanPaket.jasper", parameters, new JREmptyDataSource());
            jasperViewer=new JasperViewer(jasperPrint, false);
            jasperViewer.viewReport(jasperPrint,false);
             
            paketArrayList.clear();
             
            
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "controller Error:"+e.getMessage());
        }
            
    }
    
    public void cetakLaporanTransaksi()
    {
        try 
        {
            int jenis=laporanForm.getCbTransaksiJenis().getSelectedIndex();
            int berdasarkan=laporanForm.getCbTransaksiBerdasarkan().getSelectedIndex();
            String cari=laporanForm.getTxtCariPenjualan().getText().trim();
            
            if(jenis==0)
            {
                switch(berdasarkan)
                {
                    case 0:
                        beliCashArrayList=interfaceLaporan.laporanBeliCash();
                        break;
                        
                    case 1:
                        beliCashArrayList=interfaceLaporan.laporanBeliCashByKodeTransaksi(cari);
                        break;    
                        
                    case 2:
                        beliCashArrayList=interfaceLaporan.laporanBeliCashByNamaPembeli(cari);
                        break;
                }
                
                
                if(beliCashArrayList.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Data beli cash tidak Ditemukan atau masih kosong");
                }
                
                else
                {
                    itemsJRBean = new JRBeanCollectionDataSource(beliCashArrayList);
                    parameters.put("BeliCashDataSource", itemsJRBean);
                    jasperPrint = JasperFillManager.fillReport("src/report/LaporanBeliCash.jasper", parameters, new JREmptyDataSource());
                    beliCashArrayList.clear();
                }
                
                
            }
            
            else if(jenis==1)
            {
                switch(berdasarkan)
                {
                    case 0:
                        beliCreditArrayList=interfaceLaporan.laporanBeliCredit();
                        break;
                        
                    case 1:
                        beliCreditArrayList=interfaceLaporan.laporanBeliCreditByKodeTransaksi(cari);
                        break;
                        
                    case 2:
                        beliCreditArrayList=interfaceLaporan.laporanBeliCreditByNama(cari);
                        break;
                }
                
                if(beliCreditArrayList.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Data beli credit kosong atau tidak ditemukan");
                }
                
                else
                {
                    itemsJRBean = new JRBeanCollectionDataSource(beliCreditArrayList);
                    parameters.put("BeliCreditDataSource", itemsJRBean);
                    jasperPrint = JasperFillManager.fillReport("src/report/LaporanBelicredit.jasper", parameters, new JREmptyDataSource());
                    beliCreditArrayList.clear();
                }
                
            }
            
            else if(jenis==2)
            {
                switch(berdasarkan)
                {
                    case 0:
                        cicilanCreditArrayList=interfaceLaporan.laporanCicilan();
                        break;
                        
                    case 1:
                        cicilanCreditArrayList=interfaceLaporan.laporanCicilanByKodeCicilan(cari);
                        break;
                        
                    case 2:
                        cicilanCreditArrayList=interfaceLaporan.laporanCicilanByNama(cari);
                        break;
                }
                
                if(cicilanCreditArrayList.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Data cicilan tidak ditemukan atau masih kosong");
                }
                
                else
                {
                    itemsJRBean = new JRBeanCollectionDataSource(cicilanCreditArrayList);
                    parameters.put("CicilanDataSource", itemsJRBean);
                    jasperPrint = JasperFillManager.fillReport("src/report/LaporanCicilan.jasper", parameters, new JREmptyDataSource());
                    cicilanCreditArrayList.clear();
                }
                
                
            }
            
            
            jasperViewer=new JasperViewer(jasperPrint, false);
            jasperViewer.viewReport(jasperPrint,false);
            
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
