package com.example.pizzasystemv001;

//Class that will contain user's information
public class UserInformation {
    private static String firstName;
    private static String lastName;
    private static String phoneNumber;
    private static String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        UserInformation.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        UserInformation.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        UserInformation.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserInformation.password = password;
    }
}
