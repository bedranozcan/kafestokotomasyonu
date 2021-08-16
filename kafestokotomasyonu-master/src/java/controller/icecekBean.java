/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.icecekDAO;
import entity.cafe;
import entity.icecek;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named
@SessionScoped
public class icecekBean implements Serializable {

    private icecekDAO icecekdao;
    private icecek icecekentity;
    private int selectedCafe;

    @Inject
    private cafeBean cafeBean;

    public int getSelectedCafe() {
        return selectedCafe;
    }

    public void setSelectedCafe(int selectedCafe) {
        this.selectedCafe = selectedCafe;
    }

    public void create() {
        cafe c = cafeBean.getCafedao().getById(selectedCafe);
        icecekentity.setCafe(c);
        this.getIcecekdao().create(icecekentity);
        this.icecekentity = new icecek();
        this.clearForm();
       // return "/admin/icecek/list";
    }
      public void clearForm() {
        this.icecekentity = new icecek();
    }

    public List<icecek> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getIcecekdao().read();
    }

    public void updateForm(icecek i) {
        this.icecekentity = i;  //erişilebilir olarak düzenledik
        this.selectedCafe = i.getCafe().getCafe_id();
        //return "/admin/icecek/update";
    }

//    public String update() {
//        this.getIcecekdao().update(icecekentity);
//
//        return "/icecek/list";
//    }
    public void update() {
        cafe c = cafeBean.getCafedao().getById(selectedCafe);
        icecekentity.setCafe(c);
        this.getIcecekdao().update(icecekentity);
        this.icecekentity = new icecek();

       // return "/admin/icecek/list";
    }

    public void delete(icecek i) {// void bulunduğu sayfaya geri döner
        this.icecekdao.delete(i);

    }

    public icecekBean() {
    }

    public icecekDAO getIcecekdao() {
        if (this.icecekdao == null) {
            this.icecekdao = new icecekDAO();
        }
        return icecekdao;
    }

    public void setIcecekdao(icecekDAO icecekdao) {
        this.icecekdao = icecekdao;
    }

    public icecek getIcecekentity() {
        if (this.icecekentity == null) {
            this.icecekentity = new icecek();
        }
        return icecekentity;
    }

    public void setIcecekentity(icecek icecekentity) {
        this.icecekentity = icecekentity;
    }

}
