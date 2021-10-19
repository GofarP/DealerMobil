/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DashboardDao;
import Dao.InterfaceDashboard;
import Form.DashboardForm;
import java.text.NumberFormat;

/**
 *
 * @author LENOVO
 */
public class DashboardController {
    
    DashboardForm dashboardForm;
    InterfaceDashboard interfaceDashboard;
    
    public DashboardController(DashboardForm dashboardForm)
    {
        this.dashboardForm=dashboardForm;
        interfaceDashboard=new DashboardDao();
        
        dashboardForm.getJLabelTerjual().setText(String.valueOf(interfaceDashboard.getMotorTerjual()));
        dashboardForm.getJLabelMerkMotor().setText(String.valueOf(interfaceDashboard.getMerkMotor()));
        dashboardForm.getJLabelIncome().setText("Rp."+NumberFormat.getInstance().format(interfaceDashboard.getIncome()));
    }
    
}
