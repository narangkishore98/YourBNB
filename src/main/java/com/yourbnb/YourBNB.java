package com.yourbnb;

import com.yourbnb.datastore.DataStore;
import com.yourbnb.properties.Property;
import com.yourbnb.users.User;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class YourBNB
{
    public static void main(String[] args) throws IOException, ParseException {
        User[] users = DataStore.getUsersFromJSON("C:\\Users\\naran\\IdeaProjects\\YourBNB\\src\\main\\java\\com\\yourbnb\\data.json");
    }
}
