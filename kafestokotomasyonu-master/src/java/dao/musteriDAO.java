/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.musteri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class musteriDAO extends DBConnection {

    private masaDAO mDao;
    private siparisDAO sDao;

    public masaDAO getmDao() {
        if (this.mDao == null) {
            this.mDao = new masaDAO();
        }
        return mDao;
    }

    public void setmDao(masaDAO mDao) {
        this.mDao = mDao;
    }

    public siparisDAO getsDao() {
        if (this.sDao == null) {
            this.sDao = new siparisDAO();
        }
        return sDao;
    }

    public void setsDao(siparisDAO sDao) {
        this.sDao = sDao;
    }

    public void create(musteri i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into musteri (musteriadi,masa_id) values ( '" + i.getMusteriadi() + "','" + i.getMasa().getMasa_id() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<musteri> read() {
        List<musteri> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from musteri order by musteri_id asc");
            while (rs.next()) {
                musteri m = new musteri();
                m.setMusteri_id(rs.getInt("musteri_id"));
                m.setMusteriadi(rs.getString("musteriadi"));
                rs.getInt("masa_id");
                m.setMasa(this.getmDao().getById(rs.getInt("masa_id")));
                m.setMussiparis(this.getsDao().getMussiparis(m.getMusteri_id()));
                list.add(m);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(musteri i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update musteri set musteriadi= '" + i.getMusteriadi() + "',masa_id='" + i.getMasa().getMasa_id() + "'where musteri_id=" + i.getMusteri_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(musteri i) {
        try {

            PreparedStatement pst = this.connect().prepareStatement("DELETE FROM siparis_musteri  WHERE musteri_id=" + i.getMusteri_id() + "");
            pst.executeUpdate();

            PreparedStatement pst2 = this.connect().prepareStatement("DELETE FROM musteri WHERE musteri_id=" + i.getMusteri_id() + "");
            pst2.executeUpdate();
            pst.close();
//                 PreparedStatement pst = this.connect().prepareStatement("delete from siparis_musteri where musteri_id=?");
//                 pst.setInt(1,i.getMusteri_id());
//                 pst.executeUpdate();
//                 
//                 pst=this.connect().prepareStatement("delete from musteri where musteri_id=?");
//                 pst.setInt(1,i.getMusteri_id());
//            Statement st = this.connect().createStatement();
//             ResultSet rs = st.executeQuery("select*from siparis_musteri where musteri_id=" + i.getMusteri_id());
//            st.executeUpdate("delete from musteri where musteri_id=" + i.getMusteri_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
