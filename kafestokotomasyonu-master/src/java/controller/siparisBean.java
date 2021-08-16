/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.siparisDAO;
import entity.siparis;
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
public class siparisBean implements Serializable {

    private siparisDAO siparisdao;
    private siparis siparisentity;

    public void create() {
        this.getSiparisdao().create(siparisentity);
        this.clearForm();
        //return "/siparis/list";
    }

    public void clearForm() {
        this.siparisentity = new siparis();
    }

//    public siparis getById(int id){
//        
//        return this.getSiparisdao().getById(id);
//        
//    }
    public List<siparis> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getSiparisdao().read();
    }

    public void updateForm(siparis i) {
        this.siparisentity = i;  //erişilebilir olarak düzenledik
        //return "/siparis/update";
    }

//    public String update() {
//        this.getSiparisdao().update(siparisentity);
//
//        return "/siparis/list";
//    }
    public void update() {
        this.getSiparisdao().update(siparisentity);

        // return "/siparis/list";
    }

    public void delete(siparis i) {// void bulunduğu sayfaya geri döner
        this.siparisdao.delete(i);

    }

    public siparisBean() {
    }

    public siparisDAO getSiparisdao() {
        if (this.siparisdao == null) {
            this.siparisdao = new siparisDAO();
        }
        return siparisdao;
    }

    public void setSiparisdao(siparisDAO siparisdao) {
        this.siparisdao = siparisdao;
    }

    public siparis getSiparisentity() {
        if (this.siparisentity == null) {
            this.siparisentity = new siparis();
        }
        return siparisentity;
    }

    public void setSiparisentity(siparis siparisentity) {
        this.siparisentity = siparisentity;
    }

}
