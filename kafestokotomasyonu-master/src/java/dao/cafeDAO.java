/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.cafe;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class cafeDAO extends DBConnection {

    public cafe getById(int id) {
        cafe c = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from cafe where cafe_id=" + id);
            rs.next();
            c = new cafe(rs.getInt("cafe_id"), rs.getString("addres"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;

    }

    public void create(cafe i) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into cafe (addres) values(?)");
            pst.setString(1, i.getAdres());
            // Statement st = this.connect().createStatement();
            ResultSet rs = pst.executeQuery();
//st.executeUpdate("insert into cafe (addres) values('" + i.getAdres() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public List<cafe> read(int page, int pageSize) {
        List<cafe> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM public.\"cafe\" LIMIT " + pageSize + " OFFSET " + start + " ");
            //Statement st = this.connect().createStatement();
            ResultSet rs = pst.executeQuery();
            //  ResultSet rs = st.executeQuery("select*from cafe order by cafe_id asc");
            while (rs.next()) {
                // cafe tmp= new cafe(cafe_id, null, null, null);
                cafe tmp = new cafe(rs.getInt("cafe_id"), rs.getString("addres"));
                //cafe tmp=new cafe(cafe_id, null, fiyatı, stokadedi, cafe_id);
                list.add(tmp);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public List<cafe> read() {
        List<cafe> list = new ArrayList<>();

        try {
            PreparedStatement pst = this.connect().prepareStatement("select*from cafe order by cafe_id  ");
            //Statement st = this.connect().createStatement();
            ResultSet rs = pst.executeQuery();
            //  ResultSet rs = st.executeQuery("select*from cafe order by cafe_id asc");
            while (rs.next()) {
                // cafe tmp= new cafe(cafe_id, null, null, null);
                cafe tmp = new cafe(rs.getInt("cafe_id"), rs.getString("addres"));
                //cafe tmp=new cafe(cafe_id, null, fiyatı, stokadedi, cafe_id);
                list.add(tmp);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

//    public int count() {
//        int count = 0;
//        List<cafe> list = new ArrayList<>();
//        try {
//            PreparedStatement pst = this.connect().prepareStatement("select count(cafe_id) as cafe_count from ");
//            //Statement st = this.connect().createStatement();
//            ResultSet rs = pst.executeQuery();
//            rs.next();
//            count=rs.getInt("cafe_count");
//            //  ResultSet rs = st.executeQuery("select*from cafe order by cafe_id asc");
//        
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }
//        return count;
//    }
    public void update(cafe i) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into cafe (addres) values(?)");
            pst.setString(1, i.getAdres());
            // Statement st = this.connect().createStatement();
            //st.executeUpdate("update cafe set addres='" + i.getAdres() + "'where cafe_id=" + i.getCafe_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(cafe i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from cafe where cafe_id=" + i.getCafe_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
