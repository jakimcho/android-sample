package com.example.jakim.dbandroid.util;

/**
 * Created by Jakim on 12.7.2015 ã..
 */
public class User {
    private String userName;
    private String userSirName;
    private Integer userGender;

    public User(){

    }

    public User(String userName, String userSirName, Integer userGender) {
        this.userName = userName;
        this.userSirName = userSirName;
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSirName() {
        return userSirName;
    }

    public void setUserSirName(String userSirName) {
        this.userSirName = userSirName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }
}
