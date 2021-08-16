/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class userDAO extends DBConnection {

    private GroupDAO groupDao;

    public void create(user u) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("INSERT INTO user (email,password,name,groupid) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "','" + u.getName() + "' ," + u.getGroup().getId() + ")");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(user u) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("INSERT INTO user(email,password,name) VALUES ('" + u.getEmail() + "','" + u.getPassword() + "','" + u.getName() + "')");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<user> findAll() {
        List<user> userrList = new ArrayList<>();
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM user ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user us = new user();
                us.setEmail(rs.getString("email"));
                us.setId(rs.getLong("id"));
                us.setName(rs.getString("name"));
                us.setPassword(rs.getString("password"));
                us.setGroup(this.getGroupDao().find(rs.getLong("groupid")));
                userrList.add(us);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userrList;
    }

    public List<user> findAll(int page, int pageSize) {
        List<user> userrList = new ArrayList<>();
        int start = 0;
        start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM  user ORDER BY id LIMIT " + pageSize + " OFFSET " + start + " ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user us = new user();
                us.setEmail(rs.getString("email"));
                us.setId(rs.getLong("id"));
                us.setName(rs.getString("name"));
                us.setPassword(rs.getString("password"));
                us.setGroup(this.getGroupDao().find(rs.getLong("groupid")));
                userrList.add(us);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userrList;
    }

    public user find(Long id) {
        user userr = null;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM user WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            userr = new user();
            userr.setEmail(rs.getString("email"));
            userr.setId(rs.getLong("id"));
            userr.setName(rs.getString("name"));
            userr.setPassword(rs.getString("password"));
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userr;
    }

    public List<user> getGroupuser(Long groupid) {
        List<user> groupuser = new ArrayList<>();
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM user WHERE groupid=" + groupid + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                groupuser.add(this.find(rs.getLong("id")));
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupuser;
    }

    public void update(user u) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("UPDATE user SET email='" + u.getEmail() + "' , password='" + u.getPassword() + "' , name='" + u.getName() + "' , groupid=" + u.getGroup().getId() + " WHERE id=" + u.getId() + " ");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(user u) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("DELETE FROM user WHERE id=" + u.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public GroupDAO getGroupDao() {
        if (this.groupDao == null) {
            this.groupDao = new GroupDAO();
        }
        return groupDao;
    }

}
