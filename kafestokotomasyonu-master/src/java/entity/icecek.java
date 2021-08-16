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
public class icecek {

    private long icecek_id;
    private String icecekadi;
    private int fiyatı;
    private int stokadedi;
    private cafe cafe;

    public icecek() {
    }

    public icecek(long icecek_id, String icecekadi, int fiyatı, int stokadedi, cafe cafe) {
        this.icecek_id = icecek_id;
        this.icecekadi = icecekadi;
        this.fiyatı = fiyatı;
        this.stokadedi = stokadedi;
        this.cafe = cafe;
    }

    public cafe getCafe() {
        return cafe;
    }

    public void setCafe(cafe cafe) {
        this.cafe = cafe;
    }

    public long getIcecek_id() {
        return icecek_id;
    }

    public void setIcecek_id(long icecek_id) {
        this.icecek_id = icecek_id;
    }

    public String getIcecekadi() {
        return icecekadi;
    }

    public void setIcecekadi(String icecekadi) {
        this.icecekadi = icecekadi;
    }

    public int getFiyatı() {
        return fiyatı;
    }

    public void setFiyatı(int fiyatı) {
        this.fiyatı = fiyatı;
    }

    public int getStokadedi() {
        return stokadedi;
    }

    public void setStokadedi(int stokadedi) {
        this.stokadedi = stokadedi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.icecek_id ^ (this.icecek_id >>> 32));
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
        final icecek other = (icecek) obj;
        if (this.icecek_id != other.icecek_id) {
            return false;
        }
        return true;
    }

   

}
