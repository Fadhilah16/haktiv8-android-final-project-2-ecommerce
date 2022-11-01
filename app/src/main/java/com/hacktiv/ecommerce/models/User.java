package com.hacktiv.ecommerce.models;

import com.hacktiv.ecommerce.models.enums.RoleTypes;

public class User {

    private String id;
    private String username;
    private String password;
    private RoleTypes role;

    public User() {
        super();
    }

    public User(String username, String password, RoleTypes role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String id, String username, String password, RoleTypes role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public RoleTypes getAdmin() {
        return role;
    }

    public void setAdmin(RoleTypes role) {
        this.role = role;
    }
}
