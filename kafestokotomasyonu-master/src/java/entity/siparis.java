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
public class siparis {

    private int siparis_id;
    private int siparisadedi;
    private int toplam;

    public siparis(int siparis_id, int siparisadedi, int toplam) {
        this.siparis_id = siparis_id;
        this.siparisadedi = siparisadedi;
        this.toplam = toplam;
    }

    public siparis() {
    }

    public int getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(int siparis_id) {
        this.siparis_id = siparis_id;
    }

    public int getSiparisadedi() {
        return siparisadedi;
    }

    public void setSiparisadedi(int siparisadedi) {
        this.siparisadedi = siparisadedi;
    }

    public int getToplam() {
        return toplam;
    }

    public void setToplam(int toplam) {
        this.toplam = toplam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.siparis_id;
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
        final siparis other = (siparis) obj;
        if (this.siparis_id != other.siparis_id) {
            return false;
        }
        return true;
    }

}
