package com.entity;

import com.util.SystemStringUtils;

public class Users {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = SystemStringUtils.strNotNullTrim(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SystemStringUtils.strNotNullTrim(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = SystemStringUtils.strNotNullTrim(name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = SystemStringUtils.strNotNullTrim(phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = SystemStringUtils.strNotNullTrim(address);
    }
}
