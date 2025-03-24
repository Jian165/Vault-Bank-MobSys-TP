package com.example.vaultbank;

public class PersonalInfromationModel {
    private String firstName;
    private String LastName;
    private String email;

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private long phoneNumber;

    public PersonalInfromationModel(String firstName, String lastName, String email, long phoneNumber) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
