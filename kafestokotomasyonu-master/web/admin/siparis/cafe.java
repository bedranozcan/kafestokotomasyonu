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
public class cafe {

    private int cafe_id;
    private String adres;
//    private String telefon;
//    private String mail;

    public cafe() {
    }

    public cafe(int cafe_id, String adres) {
        this.cafe_id = cafe_id;
        this.adres = adres;
//        this.telefon = telefon;
//        this.mail = mail;
    }

    public int getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(int cafe_id) {
        this.cafe_id = cafe_id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
//
//    public String getTelefon() {
//        return telefon;
//    }
//
//    public void setTelefon(String telefon) {
//        this.telefon = telefon;
//    }
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.cafe_id;
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
        final cafe other = (cafe) obj;
        if (this.cafe_id != other.cafe_id) {
            return false;
        }
        return true;
    }
    

}
