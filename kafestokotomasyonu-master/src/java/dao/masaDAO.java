/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.masa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class masaDAO extends DBConnection {

    public masa getById(int id) {
        masa c = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from masa where masa_id=" + id);
            rs.next();
            c = new masa(rs.getInt("masa_id"), rs.getString("konum"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;

    }

    public void create(masa i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into masa (konum) values ( '" + i.getKonum() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

//    public List<masa> read(int page, int pageSize) {
//        List<masa> list = new ArrayList<>();
//        int start = 0;
//        start = (page - 1) * pageSize;
//        try {
//            Statement st = this.connect().createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.\"masa\" ORDER BY id LIMIT " + pageSize + " OFFSET " + start + " ");
//            while (rs.next()) {
//                // masa tmp= new masa(masa_id, null, null, null);
//                masa tmp = new masa(rs.getInt("masa_id"), rs.getString("konum"));
//                //masa tmp=new masa(masa_id, null, fiyatı, stokadedi, masa_id);
//                list.add(tmp);
//
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }
//        return list;
//    }

    public List<masa> read() {
        List<masa> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select*from masa order by masa_id asc");
            while (rs.next()) {
                // masa tmp= new masa(masa_id, null, null, null);
                masa tmp = new masa(rs.getInt("masa_id"), rs.getString("konum"));
                //masa tmp=new masa(masa_id, null, fiyatı, stokadedi, masa_id);
                list.add(tmp);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void update(masa i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update masa set konum='" + i.getKonum() + "'where masa_id=" + i.getMasa_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void delete(masa i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from masa where masa_id=" + i.getMasa_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
