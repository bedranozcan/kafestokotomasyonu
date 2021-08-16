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
public class tatli {

    private int tatli_id;
    private String tatliadi;
    private int fiyati;
    private int stokadedi;
    private int cafe_id;
    private cafe cafe;
    
    public tatli() {
    }

    public cafe getCafe() {
        return cafe;
    }

    public void setCafe(cafe cafe) {
        this.cafe = cafe;
    }

    public tatli(int tatli_id, String tatliadi, int fiyati, int stokadedi, int cafe_id, cafe cafe) {
        this.tatli_id = tatli_id;
        this.tatliadi = tatliadi;
        this.fiyati = fiyati;
        this.stokadedi = stokadedi;
        this.cafe_id = cafe_id;
        this.cafe = cafe;
    }

    public int getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(int cafe_id) {
        this.cafe_id = cafe_id;
    }


    public int getTatli_id() {
        return tatli_id;
    }

    public void setTatli_id(int tatli_id) {
        this.tatli_id = tatli_id;
    }

    public String getTatliadi() {
        return tatliadi;
    }

    public void setTatliadi(String tatliadi) {
        this.tatliadi = tatliadi;
    }

    public int getFiyati() {
        return fiyati;
    }

    public void setFiyati(int fiyati) {
        this.fiyati = fiyati;
    }

    public int getStokadedi() {
        return stokadedi;
    }

    public void setStokadedi(int stokadedi) {
        this.stokadedi = stokadedi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.tatli_id;
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
        final tatli other = (tatli) obj;
        if (this.tatli_id != other.tatli_id) {
            return false;
        }
        return true;
    }
    

}
