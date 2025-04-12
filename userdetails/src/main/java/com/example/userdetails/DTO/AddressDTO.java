package com.example.userdetails.DTO;

import com.example.userdetails.Entity.Address;

public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private int zip;
    private long userId;


    public AddressDTO() {
    }


    public AddressDTO(String street, String city, String state, int zip,long userId) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.userId=userId;
    }

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        this.userId=address.getUser().getUserid();
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
