package com.yl.my.shop.entity;

import java.io.Serializable;

/**
 * @author: yl
 * @version: 1.0
 * @date: 2021-11-28  23:34
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String cherkRemember;



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String isCherkRemember() {
        return cherkRemember;
    }

    public void setCherkRemember(String cherkRemember) {
        this.cherkRemember = cherkRemember;
    }
}
