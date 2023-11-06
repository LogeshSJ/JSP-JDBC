package com.codewithsj.model;

public class Register {
        private int id;
        private String username;
        private String password;
        private String Confirm_password;

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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return Confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        Confirm_password = confirm_password;
    }
}
