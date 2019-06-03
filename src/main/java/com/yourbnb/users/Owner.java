package com.yourbnb.users;

import com.yourbnb.IDisplay;
import com.yourbnb.properties.Property;



public class Owner extends User implements IDisplay
{

    public Owner()
    {


        setUserType("Owner");
    }
    public Owner(String firstName, String lastName, String email , String mobile, String password, char gender)
    {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setMobile(mobile);
        setPassword(password);
        setGender(gender);
    }

    @Override
    public String userDescription()
    {
        return "An individual who holds the rights to rent his property";
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
    public void addProperty(Property property)
    {
        getOwnerProperties().add(property);
    }
    public Property[] getProperties()
    {
        return (Property[]) getOwnerProperties().toArray();
    }
    public Property getProperty(String propertyID)
    {

        Property returner=null;
        for(Property property:getOwnerProperties())
        {
            if(property.getPropertyID().equals(propertyID))
            {
                returner = property;
                break;
            }
        }
        return returner;
    }
}
