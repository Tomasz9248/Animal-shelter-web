package com.tomek.data;

public class User {

    private String user_name;
    private String password;
    private String email_address;

    public User() {
    }

    public User(String user_name, String password, String email_address) {
        this.user_name = user_name;
        this.password = password;
        this.email_address = email_address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
}
