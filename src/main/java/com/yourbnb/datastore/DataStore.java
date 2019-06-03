package com.yourbnb.datastore;



import com.yourbnb.properties.Property;
import com.yourbnb.users.Customer;
import com.yourbnb.users.Owner;
import com.yourbnb.users.User;
import org.json.simple.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class  DataStore
{
    static String fileName = "log.txt";
    public static void log(String message) throws IOException
    {
        File f = new File(fileName);
        if(!f.isFile())
        {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f,true);
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        fw.write(df.format(d)+" ---- "+message);
    }
    public static void changeLogPath(String newFileName)
    {
        fileName = newFileName;
    }
    public static  User[] getUsersFromJSON(String fileName) throws FileNotFoundException, ParseException {
        User[] users = null;
        List<User> userList = new ArrayList<User>();
        FileReader fr = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(fileName);

        JSONArray jsonArrayUsers = (JSONArray) root.get("users");
        Iterator<JSONObject> userIterator = jsonArrayUsers.iterator();
        while(userIterator.hasNext())
        {


            JSONObject jsonObject = userIterator.next();
            String userid = (String) jsonObject.get("userid");
            if(userid.startsWith("C"))
            {
                Customer  user = new Customer();
                user.setUserID(userid);
                user.setFirstName((String)jsonObject.get("firsName"));
                user.setLastName((String)jsonObject.get("lastName"));
                user.setEmail((String)jsonObject.get("email"));
                user.setMobile((String)jsonObject.get("mobile"));
                user.setGender((jsonObject.get("gender").toString().charAt(0)));
                user.setPassword((String)jsonObject.get("password"));
                List<Property> ownerProperties = new ArrayList<Property>();
                JSONArray properties = (JSONArray) jsonObject.get("properties");
                Iterator propertiesIterator = properties.iterator();
                JSONArray ownerPropertiesArray = (JSONArray) propertiesIterator.next();
                Iterator ownerPropertiesIterator = ownerPropertiesArray.iterator();
                while(ownerPropertiesIterator.hasNext())
                {

                }

            }
            else if(userid.startsWith("O"))
            {
              Owner  user = new Owner();
            }
        }



        return  users;



    }


}
