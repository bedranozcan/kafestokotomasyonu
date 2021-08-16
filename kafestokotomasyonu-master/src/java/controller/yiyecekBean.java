/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.yiyecekDAO;
import entity.cafe;
import entity.yiyecek;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named
@SessionScoped
public class yiyecekBean implements Serializable {

    private yiyecekDAO yiyecekdao;
    private yiyecek yiyecekentity;
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
        yiyecekentity.setCafe(c);
        this.getYiyecekdao().create(yiyecekentity);
        this.yiyecekentity = new yiyecek();
        this.clearForm();;
        //return "/yiyecek/list";
    }
      public void clearForm() {
        this.yiyecekentity = new yiyecek();
    }

    public List<yiyecek> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getYiyecekdao().read();
    }

    public void updateForm(yiyecek i) {
        this.yiyecekentity = i;  //erişilebilir olarak düzenledik
        this.selectedCafe = i.getCafe().getCafe_id();
        //return "/yiyecek/update";
    }

//    public String update() {
//        this.getYiyecekdao().update(yiyecekentity);
//
//        return "/yiyecek/list";
//    }
    public void update() {
        cafe c = cafeBean.getCafedao().getById(selectedCafe);
        yiyecekentity.setCafe(c);
        this.getYiyecekdao().update(yiyecekentity);
        this.yiyecekentity = new yiyecek();

        // return "/yiyecek/list";
    }

    public void delete(yiyecek i) {// void bulunduğu sayfaya geri döner
        this.yiyecekdao.delete(i);

    }

    public yiyecekBean() {
    }

    public yiyecekDAO getYiyecekdao() {
        if (this.yiyecekdao == null) {
            this.yiyecekdao = new yiyecekDAO();
        }
        return yiyecekdao;
    }

    public void setYiyecekdao(yiyecekDAO yiyecekdao) {
        this.yiyecekdao = yiyecekdao;
    }

    public yiyecek getYiyecekentity() {
        if (this.yiyecekentity == null) {
            this.yiyecekentity = new yiyecek();
        }
        return yiyecekentity;
    }

    public void setYiyecekentity(yiyecek yiyecekentity) {
        this.yiyecekentity = yiyecekentity;
    }

}
