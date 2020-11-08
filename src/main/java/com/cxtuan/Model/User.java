package com.cxtuan.Model;

public class User extends Parent{
    private String  username;
    private String password;
    private String fillname;
    private int status;
    private int roleid;
    private Role role;

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String username, String password, String fillname, int status, int roleid) {
        this.username = username;
        this.password = password;
        this.fillname = fillname;
        this.status = status;
        this.roleid = roleid;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getFillname() {
        return fillname;
    }

    public void setFillname(String fillname) {
        this.fillname = fillname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
