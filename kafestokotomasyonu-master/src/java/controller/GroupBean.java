package controller;

import dao.GroupDAO;
import dao.userDAO;
import entity.Group;
import entity.user;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named
@SessionScoped
public class GroupBean implements Serializable {

    private Group group;
    private GroupDAO groupDao;
    private List<Group> fullGroupList;

    private userDAO userDao;
    private List<user> userList;

    private int page = 1;
    private int pageSize = 3;
    private List<Group> groupList;

    public void create() {
        this.getGroupDao().create(this.group);
        this.clearForm();
    }

    public void updateForm(Group g) {
        this.group = g;
    }

    public void clearForm() {
        this.group = new Group();
    }

    public void update() {
        this.getGroupDao().update(this.group);
        this.clearForm();
    }

    public void delete() {
        this.getGroupDao().delete(this.group);
        this.clearForm();
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.pageCount();
        } else {
            this.page--;
        }
    }

    public void next() {
        if (this.page == this.pageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public int pageCount() {
        return (int) Math.ceil(this.getGroupDao().findAll().size() / (double) pageSize);
    }

    public Group getGroup() {
        if (this.group == null) {
            this.group = new Group();
        }
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GroupDAO getGroupDao() {
        if (this.groupDao == null) {
            this.groupDao = new GroupDAO();
        }
        return groupDao;
    }

    public List<Group> getGroupList() {
        this.groupList = this.getGroupDao().findAll(page, pageSize);
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public userDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new userDAO();
        }
        return userDao;
    }

    public List<user> getUserList() {
        this.userList = this.getUserDao().findAll();
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

    public List<Group> getFullGroupList() {
        this.fullGroupList = this.getGroupDao().findAll();
        return fullGroupList;
    }

    public void setFullGroupList(List<Group> fullGroupList) {
        this.fullGroupList = fullGroupList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
