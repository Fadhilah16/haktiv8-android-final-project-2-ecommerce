package com.hacktiv.ecommerce.models;

import com.hacktiv.ecommerce.models.enums.RoleTypes;

public class User {

    private String id;
    private String username;
    private String email;
    private RoleTypes role;

    public User() {
        super();
    }

    public User(String username, String password, RoleTypes role) {
        this.username = username;
        this.role = role;
    }

    public User(String id, String username, String password, String email, RoleTypes role) {
        this.id = id;
        this.username = username;
        this.email = email;
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

    public RoleTypes getRole() {
        return role;
    }

    public void setRole(RoleTypes role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
