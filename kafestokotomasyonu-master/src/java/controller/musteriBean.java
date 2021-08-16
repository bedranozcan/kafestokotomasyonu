/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.musteriDAO;
import entity.masa;
import entity.musteri;
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
public class musteriBean implements Serializable {

    private musteriDAO musteridao;
    private musteri musterientity;
    private int selectedMasa;

    @Inject
    private masaBean masaBean;

    public int getSelectedMasa() {

        return selectedMasa;
    }

    public void setSelectedMasa(int selectedMasa) {
        this.selectedMasa = selectedMasa;
    }

    public void create() {
        masa c = masaBean.getMasadao().getById(selectedMasa);
        musterientity.setMasa(c);
        this.getMusteridao().create(musterientity);
        this.musterientity = new musteri();
        this.clearForm();
        //return "/musteri/list";
    }
  public void clearForm() {
        this.musterientity = new musteri();
    }
//    public musteri getById(int id){
//        
//        return this.getMusteridao().getById(id);
//        
//    }
    public List<musteri> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getMusteridao().read();
    }

    public void updateForm(musteri i) {

        this.musterientity = i;  //erişilebilir olarak düzenledik
        this.selectedMasa = i.getMasa().getMasa_id();
        //return "/musteri/update";
    }

//    public String update() {
//        this.getMusteridao().update(musterientity);
//
//        return "/musteri/list";
//    }
    public void update() {
        masa c = masaBean.getMasadao().getById(selectedMasa);
        musterientity.setMasa(c);
        this.getMusteridao().update(musterientity);
        this.musterientity = new musteri();
        //return "/musteri/list";
    }

    public void delete(musteri i) {// void bulunduğu sayfaya geri döner
        this.musteridao.delete(i);
        // this.selectedMasa=null;

    }

    public musteriBean() {
    }

    public musteriDAO getMusteridao() {
        if (this.musteridao == null) {
            this.musteridao = new musteriDAO();
        }
        return musteridao;
    }

    public void setMusteridao(musteriDAO musteridao) {
        this.musteridao = musteridao;
    }

    public musteri getMusterientity() {
        if (this.musterientity == null) {
            this.musterientity = new musteri();
        }
        return musterientity;
    }

    public void setMusterientity(musteri musterientity) {
        this.musterientity = musterientity;
    }

}
