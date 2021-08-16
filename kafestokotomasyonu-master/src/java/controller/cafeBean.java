/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.cafeDAO;
import entity.cafe;
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
public class cafeBean implements Serializable {

    private cafeDAO cafedao;
    private cafe cafeentity;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getCafedao().read().size() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getCafedao().create(cafeentity);

        //return "/cafe/list";
    }

//    public cafe getById(int id){
//        
//        return this.getCafedao().getById(id);
//        
//    }
    public List<cafe> getRead() {//xhtml read diye bir degişken varmış  gibi görür
        return this.getCafedao().read(page, pageSize);
    }

    public void updateForm(cafe i) {
        this.cafeentity = i;  //erişilebilir olarak düzenledik
        //return "/cafe/update";
    }

//    public String update() {
//        this.getCafedao().update(cafeentity);
//
//        return "/cafe/list";
//    }
    public void update() {
        this.getCafedao().update(cafeentity);

        //return "/cafe/list";
    }

    public void delete(cafe i) {// void bulunduğu sayfaya geri döner
        this.cafedao.delete(i);

    }

    public cafeBean() {
    }

    public cafeDAO getCafedao() {
        if (this.cafedao == null) {
            this.cafedao = new cafeDAO();
        }
        return cafedao;
    }

    public void setCafedao(cafeDAO cafedao) {
        this.cafedao = cafedao;
    }

    public cafe getCafeentity() {
        if (this.cafeentity == null) {
            this.cafeentity = new cafe();
        }
        return cafeentity;
    }

    public void setCafeentity(cafe cafeentity) {
        this.cafeentity = cafeentity;
    }

}
