package com.example.orderdetails.DTO;

public class UserDTO {
    private long userid;
    private String name;
    private String email;

    public UserDTO()
    {

    }
    public UserDTO(long userid,String name, String email) {
        this.userid=userid;
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
