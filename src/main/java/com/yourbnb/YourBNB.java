package com.yourbnb;

import com.yourbnb.datastore.DataStore;
import com.yourbnb.properties.Property;
import com.yourbnb.users.User;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class YourBNB
{
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        List<User> users = DataStore.getUsersFromJSON("C:\\Users\\naran\\IdeaProjects\\YourBNB\\src\\main\\java\\com\\yourbnb\\data.json");
        System.out.println("----------------------------------YOUR BNB-------------------------------------------");
        System.out.println();
        System.out.println("===============USERS===============");
        Iterator i = users.iterator();
        while(i.hasNext())
        {
            User u = (User) i.next();
            System.out.println("User ID: "+u.getUserID());
            System.out.println("User Type: "+u.getUserType());
            System.out.println("User Name: "+u.getFullName());
            System.out.println("User Email: "+u.getEmail());
            System.out.println("User Mobile: "+u.getMobile());
            if(u.getGender()=='M'){
                System.out.println("User Gender: Male");}
            else if(u.getGender()=='F')
            {
                System.out.println("User Gender: Female");
            }
            else
            {
                System.out.println("User Gender: N.A.");
            }
            if(u.getUserType().equals("Owner"))
            {
                System.out.println("::::::::::Properties Owned::::::::::");
                List<Property> l= u.getOwnerProperties();
                Iterator propertiesIterator = l.iterator();
                if(!propertiesIterator.hasNext())
                {
                    System.out.println("Owner Owns No Properties.");
                    System.out.println();
                }
                else
                {
                    while(propertiesIterator.hasNext())
                    {
                        Property p = (Property) propertiesIterator.next();
                        System.out.println("    Property ID: "+p.getPropertyID());
                    }
                }
            }
            System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

        }
        System.out.println();
        System.out.println("--------------------------------------END--------------------------------------------");
    }
}
