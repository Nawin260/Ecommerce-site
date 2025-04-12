package com.example.userdetails.Entity;

import com.example.userdetails.Enum.UserCategory;
import com.example.userdetails.Enum.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="user_details")

public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    private LocalDateTime createdTime;

    public User()
    {

    }


    public User(long userid, String name, String email, String password, UserRole userRole,UserCategory userCategory, LocalDateTime createdTime) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.createdTime = createdTime;
        this.userCategory = userCategory;

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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }
}
