/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.user;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named
@SessionScoped
public class loginController implements Serializable {

    private user user;

    public String login() {
        if (this.user.getEmail().equals("kullanici") && this.user.getPassword().equals("1234")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
         return "/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("hatalı kullanıcı adı veya şifre"));
            return "/frontend/login?faces-redirect=true";

        }

    }

    public user getUser() {
        if (this.user == null) {
            this.user = new user();
        }
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

}
