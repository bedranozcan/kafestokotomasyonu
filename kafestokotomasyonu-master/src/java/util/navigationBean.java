/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named(value = "navigationController")
@RequestScoped

public class navigationBean implements Serializable {

    public String page(String page) {
        return "/admin/" + page + "/" + page + "?faces-redirect=true";
    }

    public String goToFrontendPage(String page) {
        return "/frontend/" + page + "?faces-redirect=true";
    }

//    public String goToAdminPage(String page) {
//        return "/admin/"+page+"/"+page+"?faces-redirect=true";
//    } 
}
