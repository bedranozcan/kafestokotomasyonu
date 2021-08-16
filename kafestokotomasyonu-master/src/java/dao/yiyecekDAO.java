/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yiyecek;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class yiyecekDAO extends DBConnection {//crud işlemleri  burada gerçekleşecek.

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

    public void create(yiyecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into yiyecek (yiyecekadi,fiyatı,stokadedi,cafe_id) values ( '" + i.getYiyecekadi() + "','" + i.getFiyat() + "','" + i.getStokadedi() + "','" + i.getCafe().getCafe_id() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<yiyecek> read() {
        List<yiyecek> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from yiyecek order by yemek_id asc");
            while (rs.next()) {
                yiyecek c = new yiyecek();
                c.setYiyecek_id(rs.getInt("yemek_id"));
                c.setYiyecekadi(rs.getString("yiyecekadi"));
                c.setFiyat(rs.getInt("fiyatı"));
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

    public void update(yiyecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update yiyecek set yiyecekadi='" + i.getYiyecekadi() + "',fiyatı='" + i.getFiyat() + "',stokadedi='" + i.getStokadedi() + "',cafe_id='" + i.getCafe().getCafe_id() + "'where yemek_id=" + i.getYiyecek_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(yiyecek i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from yiyecek where yemek_id=" + i.getYiyecek_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
