/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCreditDao;
import Dao.InterfaceBeliCredit;
import Dao.InterfacePaket;
import Dao.PaketDao;
import Form.BeliCreditForm;
import Model.BeliCredit;
import Model.Paket;
import Table.TableModelDataBeliCredit;
import Table.TableModelDataPaket;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class BeliCreditController  {
    
    BeliCreditForm beliCreditForm;
    InterfaceBeliCredit interfaceBeliCredit;
    ArrayList<BeliCredit> beliCreditArrayList;
    
    public BeliCreditController(BeliCreditForm beliCreditForm)
    {
        this.beliCreditForm=beliCreditForm;
        interfaceBeliCredit=new BeliCreditDao();
        beliCreditArrayList=new ArrayList<>();
        beliCreditArrayList=interfaceBeliCredit.showDataBeliCredit();
        
    }
    
    public void showDataBeliCredit()
    {
        TableModelDataBeliCredit modelDataBeliCredit=new TableModelDataBeliCredit(beliCreditArrayList);
        beliCreditForm.getTblKredit().setModel(modelDataBeliCredit);
    }
    
}
