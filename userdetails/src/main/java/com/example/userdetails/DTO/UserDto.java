package com.example.userdetails.DTO;

import com.example.userdetails.Entity.User;

public class UserDto {

    private long userid;
    private String name;
    private String email;
    private String password;
    private String userCategory;
    private String userRole;

    public UserDto() {

    }

    public UserDto(long userid,String name, String email, String password, String userCategory, String userRole) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userCategory = userCategory;
        this.userRole = userRole;
    }

    public UserDto(User user) {
        this.userid=user.getUserid();
        this.name=user.getName();
        this.email=user.getEmail();
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
