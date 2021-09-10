/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Pembelian {
    
   private Date tglbayar;
   private String status, noBeli, idBeli; 

    public String getIdBeli() {
        return idBeli;
    }

    public void setIdBeli(String idBeli) {
        this.idBeli = idBeli;
    }
   
   
    

    public String getNoBeli() {
        return noBeli;
    }

    public void setNoBeli(String noBeli) {
        this.noBeli = noBeli;
    }
   

    public Date getTglbayar() {
        return tglbayar;
    }

    public void setTglbayar(Date tglbayar) {
        this.tglbayar = tglbayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
}
