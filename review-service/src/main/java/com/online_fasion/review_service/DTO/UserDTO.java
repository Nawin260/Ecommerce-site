package com.online_fasion.review_service.DTO;

public class UserDTO {
    private Long userid;
    private String name;
    private String email;

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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public UserDTO(){}

    public UserDTO(long userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }
    @Override
    public String toString() {
        return "UserDTO{id=" + userid + ", name='" + name + "', email='" + email + "'}";
    }


}
