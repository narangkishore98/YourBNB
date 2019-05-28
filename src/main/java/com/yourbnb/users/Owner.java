package com.yourbnb.users;

public class Owner extends User
{
    private static int id;

    public Owner()
    {
        id++;
        setUserID(id);
        setUserType("Owner");
    }
    @Override
    public String getUserID()
    {
        return "O"+ super.getUserID();
    }
    @Override
    public String userDescription()
    {
        return "An individual who holds the rights to rent his property";
    }
    @Override
    public String display()
    {
        String password = "*";
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
}
