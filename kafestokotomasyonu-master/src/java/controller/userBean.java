package controller;

import dao.GroupDAO;
import dao.userDAO;
import entity.Group;
import entity.user;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named
@SessionScoped
public class userBean implements Serializable {

    private user user;
    private userDAO userDao;
    private List<user> fullUserList;

    private GroupDAO groupDao;
    private List<Group> groupList;

    private int page = 1;
    private int pageSize = 3;
    private List<user> userList;

    public void create() {
        this.getUserDao().create(this.user);
        this.clearForm();
    }

    public void register() {
        this.getUserDao().register(this.user);
        this.clearForm();
    }

    public void updateForm(user u) {
        this.user = u;
    }

    public void clearForm() {
        this.user = new user();
    }

    public void update() {
        this.getUserDao().update(this.user);
        this.clearForm();
    }

    public void delete() {
        this.getUserDao().delete(this.user);
        this.clearForm();
    }

    public boolean validateName(FacesContext fc, UIComponent com, Object value) throws ValidatorException {
        String name = (String) value;
        if (name.length() < 8 || name.length() > 25) {
            String msg = "Name 8 ile 25 karakter arasında olmalıdır";
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            throw new ValidatorException(m);
        }
        return true;
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
        return (int) Math.ceil(this.getUserDao().findAll().size() / (double) pageSize);
    }

    public user getUser() {
        if (this.user == null) {
            this.user = new user();
        }
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public userDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new userDAO();
        }
        return userDao;
    }

    public List<user> getUserList() {
        this.userList = this.getUserDao().findAll(page, pageSize);
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

    public GroupDAO getGroupDao() {
        if (this.groupDao == null) {
            this.groupDao = new GroupDAO();
        }
        return groupDao;
    }

    public List<Group> getGroupList() {
        this.groupList = this.getGroupDao().findAll();
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<user> getFullUserList() {
        this.fullUserList = this.getUserDao().findAll();
        return fullUserList;
    }

    public void setFullUserList(List<user> fullUserList) {
        this.fullUserList = fullUserList;
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
