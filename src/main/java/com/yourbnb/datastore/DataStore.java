package com.yourbnb.datastore;



import com.yourbnb.users.User;
import org.json.simple.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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
        Iterator<User> userIterator = jsonArrayUsers.iterator();



        return  users;



    }


}
