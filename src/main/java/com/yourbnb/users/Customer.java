package com.yourbnb.users;

import com.yourbnb.IDisplay;

public class Customer extends  User implements IDisplay
{
    private  static  int id;
    Customer()
    {
        setUserID(++id);
        setUserType("Customer");
    }
    @Override
    public String getUserID()
    {
        return "O"+super.getUserID();
    }

    @Override
    public String userDescription() {
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
    public String display() {
        return "An individual who holds the rights to rent the property of owner";
    }
}
