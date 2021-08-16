/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Asus
 */
public class musteri {

    private int musteri_id;
    private String musteriadi;
    private masa masa;
    private List<siparis>mussiparis;

    public musteri(int musteri_id, String musteriadi, masa masa) {
        this.musteri_id = musteri_id;
        this.musteriadi = musteriadi;
        this.masa = masa;
    
    }



    public musteri() {
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getMusteriadi() {
        return musteriadi;
    }

    public void setMusteriadi(String musteriadi) {
        this.musteriadi = musteriadi;
    }

    public masa getMasa() {
        return masa;
    }

    public void setMasa(masa masa) {
        this.masa = masa;
    }

    public List<siparis> getMussiparis() {
        return mussiparis;
    }

    public void setMussiparis(List<siparis> mussiparis) {
        this.mussiparis = mussiparis;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.musteri_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final musteri other = (musteri) obj;
        if (this.musteri_id != other.musteri_id) {
            return false;
        }
        return true;
    }

}
