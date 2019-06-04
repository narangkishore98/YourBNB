package com.yourbnb.users;

import com.yourbnb.IDisplay;

public class Customer extends  User implements IDisplay
{

    public Customer()
    {

        setUserType("Customer");
    }


    @Override
    public String display()
    {
        String password = "";
        for(int i=0;i<getPassword().length();i++)
        {
            password+="*";
        }
        return "User Type: "+getUserType()+"\n" +
                "Full Name: "+getFullName()+"\n" +
                "Gender: "+getGender()+"\n" +
                "Email: "+getEmail()+"\n" +
                "Password: "+password+"\n" +
                "Mobile: "+getMobile();
    }
    @Override
    public String userDescription() {
        return "An individual who wants to rent the house.";
    }
}
