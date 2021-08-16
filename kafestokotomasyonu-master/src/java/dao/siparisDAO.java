/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.siparis;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class siparisDAO extends DBConnection {

    public void create(siparis i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into siparis (toplam,siparisadedi) values ( '" + i.getToplam() + "','" + i.getSiparisadedi() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<siparis> read() {
        List<siparis> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from siparis order by siparis_id asc");
            while (rs.next()) {
                siparis s = new siparis();
                s.setSiparis_id(rs.getInt("siparis_id"));
                s.setSiparisadedi(rs.getInt("siparisadedi"));
                s.setToplam(rs.getInt("toplam"));

                list.add(s);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(siparis i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update siparis set siparisadedi='" + i.getSiparisadedi() + "', toplam='" + i.getToplam() + "'where siparis_id=" + i.getSiparis_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<siparis> getMussiparis(int musteri_id) {
        List<siparis> musSiparis = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from siparis_musteri where musteri_id=" + musteri_id);

            while (rs.next()) {
                musSiparis.add(this.find(rs.getInt("siparis_id")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return musSiparis;
    }

    public siparis find(int id) {
        siparis s = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from siparis where siparis_id=" + id);
            rs.next();
            s = new siparis();
            s.setSiparis_id(rs.getInt("siparis_id"));
            s.setToplam(rs.getInt("toplam"));
            s.setSiparisadedi(rs.getInt("siparisadedi"));
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return s;
    }

    public void delete(siparis i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from siparis where siparis_id=" + i.getSiparis_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
