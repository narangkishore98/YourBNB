package com.yourbnb.users;

import com.yourbnb.IDisplay;
import com.yourbnb.exceptions.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class User implements IDisplay {
    private String userID;
    private String userType; // [Owner] Type [Customer] Type
    private String firstName;
    private String lastName;
    private char gender; // (M/m) for males {F/f) for females
    private String email;
    private String password;
    private String mobile;
    public   String getUserID()
    {
        return  userID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getUserType() {
        return userType;
    }

    protected void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
            this.email=email;
        }
        else
        {
            throw new InvalidEmailException("Invalid Email.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullName()
    {
        return  getFirstName()+" "+getLastName();
    }
    public abstract  String  userDescription();
}
