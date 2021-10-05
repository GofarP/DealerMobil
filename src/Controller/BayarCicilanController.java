/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BeliCreditDao;
import Dao.CicilanDao;
import Dao.InterfaceBeliCredit;
import Dao.InterfaceCicilan;
import Form.BayarCicilanForm;
import Model.BeliCredit;
import Model.Cicilan;
import Table.TableModelDataBeliCredit;
import Table.TableModelDataCicilan;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class BayarCicilanController {
    
    BayarCicilanForm bayarCicilanForm;
    InterfaceBeliCredit interfaceDataBeliCredit;
    InterfaceCicilan interfaceCicilan;
    ArrayList<BeliCredit> arrayListCredit;
    ArrayList<Cicilan>arrayListCicilan;
    
    public BayarCicilanController(BayarCicilanForm bayarCicilanForm)
    {
        this.bayarCicilanForm=bayarCicilanForm;
        
        interfaceDataBeliCredit=new BeliCreditDao();
        interfaceCicilan=new CicilanDao();
        
    }
    
    public void showDataCredit()
    {
        arrayListCredit=new ArrayList<>();
        arrayListCredit=interfaceDataBeliCredit.showDataBeliCredit();
        TableModelDataBeliCredit tableModelDataBeliCredit=new TableModelDataBeliCredit(arrayListCredit);
        bayarCicilanForm.getTblCicilan().setModel(tableModelDataBeliCredit);
    }
    
    public void showDataCicilan()
    {
        arrayListCicilan=new ArrayList<>();
        arrayListCicilan=interfaceCicilan.showDataCicilan();
        TableModelDataCicilan tableModelDataCicilan=new TableModelDataCicilan(arrayListCicilan);
        bayarCicilanForm.getTblCicilan().setModel(tableModelDataCicilan);
    }
    
}
