/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.tatliDAO;
import entity.cafe;
import entity.tatli;
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
public class tatliBean implements Serializable {

     private tatliDAO tatlidao;
    private tatli tatlientity;
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
        tatlientity.setCafe(c);
        this.getTatlidao().create(tatlientity);
        this.tatlientity = new tatli();
        this.clearForm();
        //return "/tatli/list";
    }
      public void clearForm() {
        this.tatlientity = new tatli();
    }

    public List<tatli> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getTatlidao().read();
    }

    public void updateForm(tatli i) {
        this.tatlientity = i;  //erişilebilir olarak düzenledik
        this.selectedCafe = i.getCafe().getCafe_id();
        //return "/tatli/update";
    }

//    public String update() {
//        this.getTatlidao().update(tatlientity);
//
//        return "/tatli/list";
//    }
    public void update() {
        cafe c = cafeBean.getCafedao().getById(selectedCafe);
        tatlientity.setCafe(c);
        this.getTatlidao().update(tatlientity);
        this.tatlientity = new tatli();

        // return "/tatli/list";
    }

    public void delete(tatli i) {// void bulunduğu sayfaya geri döner
        this.tatlidao.delete(i);

    }

    public tatliBean() {
    }

    public tatliDAO getTatlidao() {
        if (this.tatlidao == null) {
            this.tatlidao = new tatliDAO();
        }
        return tatlidao;
    }

    public void setTatlidao(tatliDAO tatlidao) {
        this.tatlidao = tatlidao;
    }

    public tatli getTatlientity() {
        if (this.tatlientity == null) {
            this.tatlientity = new tatli();
        }
        return tatlientity;
    }

    public void setTatlientity(tatli tatlientity) {
        this.tatlientity = tatlientity;
    }

}
