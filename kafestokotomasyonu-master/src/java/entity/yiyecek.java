/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Asus
 */
public class yiyecek {

    private int yiyecek_id;
    private String yiyecekadi;
    private int fiyat;
    private int stokadedi;
    private cafe cafe;

    public yiyecek() {
    }

    public yiyecek(int yiyecek_id, String yiyecekadi, int fiyat, int stokadedi, cafe cafe) {
        this.yiyecek_id = yiyecek_id;
        this.yiyecekadi = yiyecekadi;
        this.fiyat = fiyat;
        this.stokadedi = stokadedi;
        this.cafe = cafe;
    }

    public cafe getCafe() {
        return cafe;
    }

    public void setCafe(cafe cafe) {
        this.cafe = cafe;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getYiyecek_id() {
        return yiyecek_id;
    }

    public void setYiyecek_id(int yiyecek_id) {
        this.yiyecek_id = yiyecek_id;
    }

    public String getYiyecekadi() {
        return yiyecekadi;
    }

    public void setYiyecekadi(String yiyecekadi) {
        this.yiyecekadi = yiyecekadi;
    }

    public int getStokadedi() {
        return stokadedi;
    }

    public void setStokadedi(int stokadedi) {
        this.stokadedi = stokadedi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.yiyecek_id;
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
        final yiyecek other = (yiyecek) obj;
        if (this.yiyecek_id != other.yiyecek_id) {
            return false;
        }
        return true;
    }

}
