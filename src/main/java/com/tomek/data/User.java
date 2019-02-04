package com.tomek.data;

public class User {

    private String userName;
    private String password;
    private String emailAddress;

    public User() {
    }

    public User(String userName, String password, String emailAddress) {
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}