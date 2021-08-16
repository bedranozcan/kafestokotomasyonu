/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.tatli;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class tatliDAO extends DBConnection {

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

    public void create(tatli i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tatli (tatliadi,fiyatı,stokadedi,cafe_id) values ( '" + i.getTatliadi() + "','" + i.getFiyati() + "','" + i.getStokadedi() + "','" + i.getCafe().getCafe_id() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<tatli> read() {
        List<tatli> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from tatli order by tatli_id asc");
            while (rs.next()) {
                tatli c = new tatli();
                c.setTatli_id(rs.getInt("tatli_id"));
                c.setTatliadi(rs.getString("tatliadi"));
                c.setFiyati(rs.getInt("fiyatı"));
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

    public void update(tatli i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update tatli set tatliadi='" + i.getTatliadi() + "',fiyatı='" + i.getFiyati() + "',stokadedi='" + i.getStokadedi() + "',cafe_id='" + i.getCafe().getCafe_id() + "'where tatli_id=" + i.getTatli_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(tatli i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from tatli where tatli_id=" + i.getTatli_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
