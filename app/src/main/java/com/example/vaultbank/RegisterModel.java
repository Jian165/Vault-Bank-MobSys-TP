package com.example.vaultbank;

public class RegisterModel {
    public RegisterModel(String password, String username) {
        Password = password;
        Username = username;
    }


    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    private String Password;

    private String Username;

}
