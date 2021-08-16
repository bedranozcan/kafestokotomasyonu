package dao;

import entity.Group;
import entity.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author sinem
 */
public class GroupDAO extends DBConnection {

    private userDAO userDao;

    public void create(Group group) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("INSERT INTO Group (authority) VALUES ('" + group.getAuthority() + "')");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Group find(Long id) {
        Group group = null;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM Group WHERE id=" + id + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            group = new Group();
            group.setId(rs.getLong("id"));
            group.setAuthority(rs.getString("authority"));
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    public List<Group> findAll() {
        List<Group> groupList = new ArrayList<>();
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM Group ORDER BY id ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getLong("id"));
                group.setAuthority(rs.getString("authority"));
                group.setUserList(this.getUserDao().getGroupuser(group.getId()));
                groupList.add(group);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupList;
    }

    public List<Group> findAll(int page, int pageSize) {
        List<Group> groupList = new ArrayList<>();
        int start = 0;
        start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("SELECT * FROM Group ORDER BY id LIMIT " + pageSize + " OFFSET " + start + " ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getLong("id"));
                group.setAuthority(rs.getString("authority"));
                group.setUserList(this.getUserDao().getGroupuser(group.getId()));
                groupList.add(group);
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groupList;
    }

    public void update(Group group) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("UPDATE Group SET authority='" + group.getAuthority() + "' WHERE id=" + group.getId() + " ");
            pst.executeUpdate();
            for (user u : group.getUserList()) {
                PreparedStatement pst2 = this.connect().prepareStatement("UPDATE user SET groupid=" + group.getId() + " WHERE id=" + u.getId() + " ");
                pst2.executeUpdate();
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Group group) {
        try {
            PreparedStatement pst;
            pst = this.connect().prepareStatement("DELETE FROM user WHERE groupid=" + group.getId() + "");
            pst.executeUpdate();

            pst = this.connect().prepareStatement("DELETE FROM Group WHERE id=" + group.getId() + "");
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public userDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new userDAO();
        }
        return userDao;
    }
}
