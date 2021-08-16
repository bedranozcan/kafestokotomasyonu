/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.masaDAO;
import entity.masa;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named
@SessionScoped
public class masaBean implements Serializable {

    private masaDAO masadao;
    private masa masaentity;

    public void create() {
        this.getMasadao().create(masaentity);
        this.clearForm();

        //return "/masa/list";
    }

//    public masa getById(int id){
//        
//        return this.getMasadao().getById(id);
//        
//    }
    public List<masa> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getMasadao().read();
    }

    public void updateForm(masa i) {
        this.masaentity = i;  //erişilebilir olarak düzenledik
        //return "/masa/update";
    }

//    public String update() {
//        this.getMasadao().update(masaentity);
//
//        return "/masa/list";
//    }
    public void update() {
        this.getMasadao().update(masaentity);

        //return "/masa/list";
    }

    public void delete(masa i) {// void bulunduğu sayfaya geri döner
        this.masadao.delete(i);

    }

    public masaBean() {
    }

    public masaDAO getMasadao() {
        if (this.masadao == null) {
            this.masadao = new masaDAO();
        }
        return masadao;
    }

    public void clearForm() {
        this.masaentity = new masa();
    }

    public void setMasadao(masaDAO masadao) {
        this.masadao = masadao;
    }

    public masa getMasaentity() {
        if (this.masaentity == null) {
            this.masaentity = new masa();
        }
        return masaentity;
    }

    public void setMasaentity(masa masaentity) {
        this.masaentity = masaentity;
    }

}
