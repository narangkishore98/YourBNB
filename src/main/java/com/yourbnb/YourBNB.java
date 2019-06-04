package com.yourbnb;

import com.yourbnb.datastore.DataStore;
import com.yourbnb.properties.Property;
import com.yourbnb.users.User;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class YourBNB
{
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        List<User> users = DataStore.getUsersFromJSON("C:\\Users\\Nikhil\\YourBNB\\src\\main\\java\\com\\yourbnb\\datastore\\DataStore.java");
        System.out.println(users);
    }
}
