/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.InterfaceLogin;
import Dao.LoginDao;
import Form.LoginForm;
import Model.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class LoginController {
    
    LoginForm loginForm;
    Login login;
    InterfaceLogin interfaceLogin;
    
    public LoginController(LoginForm loginForm)
    {
        this.loginForm=loginForm;
        interfaceLogin=new LoginDao();
    }
    
    public boolean login()
    {
        login=new Login();
        
         boolean correct=false;
         
        login.setUsername(loginForm.getTxtUsername().getText().trim());
        login.setPassword(loginForm.getTxtPassword().getText().trim());
                
        if(login.getUsername().equals("")||login.getPassword().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Username/Password Yang Kosong");
        }
        
        else if(interfaceLogin.login(login))
        {
            correct=true;
        }
        
        return correct;
         
    }
    
    
}
