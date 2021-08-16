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
public class masa {
    private int masa_id;
    private String konum;

    public masa() {
    }

    public masa(int masa_id, String konum) {
        this.masa_id = masa_id;
        this.konum = konum;
    }

    public int getMasa_id() {
        return masa_id;
    }

    public void setMasa_id(int masa_id) {
        this.masa_id = masa_id;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.masa_id;
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
        final masa other = (masa) obj;
        if (this.masa_id != other.masa_id) {
            return false;
        }
        return true;
    }
    
    
}
