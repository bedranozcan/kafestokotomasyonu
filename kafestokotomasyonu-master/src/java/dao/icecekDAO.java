/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.cafe;
import entity.icecek;
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
public class icecekDAO extends DBConnection {

    private cafeDAO cdao;

    public cafeDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new cafeDAO();
        }
        return cdao;
    }

    public void setCdao(cafeDAO cdao) {
        this.cdao = cdao;
    }

    public void create(icecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into icecek (icecekadi,fiyatı,stokadedi,cafe_id) values ( '" + i.getIcecekadi() + "','" + i.getFiyatı() + "','" + i.getStokadedi() + "','" + i.getCafe().getCafe_id() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<icecek> read() {
        List<icecek> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from icecek order by icecek_id asc");
            while (rs.next()) {
                icecek c = new icecek();
                c.setIcecek_id(rs.getLong("icecek_id"));
                c.setIcecekadi(rs.getString("icecekadi"));
                c.setFiyatı(rs.getInt("fiyatı"));
                c.setStokadedi(rs.getInt("stokadedi"));
                rs.getInt("cafe_id");
                c.setCafe(this.getCdao().getById(rs.getInt("cafe_id")));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(icecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update icecek set icecekadi='" + i.getIcecekadi() + "',fiyatı='" + i.getFiyatı() + "',stokadedi='" + i.getStokadedi() + "',cafe_id='" + i.getCafe().getCafe_id() + "'where icecek_id=" + i.getIcecek_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(icecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from icecek where icecek_id=" + i.getIcecek_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public Object find(Long icecek_id) {
        icecek c = null;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM icecek WHERE icecek_id=" + icecek_id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            c = new icecek();
            c.setIcecek_id(rs.getLong("icecek_id"));
            c.setIcecekadi(rs.getString("icecekadi"));
            c.setFiyatı(rs.getInt("fiyatı"));
            c.setStokadedi(rs.getInt("stokadedi"));
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return c;
    }
}
