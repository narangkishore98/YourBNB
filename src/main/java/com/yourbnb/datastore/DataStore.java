package com.yourbnb.datastore;



import com.yourbnb.properties.*;
import com.yourbnb.users.Customer;
import com.yourbnb.users.Owner;
import com.yourbnb.users.User;
import javafx.css.CssMetaData;
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
    static String fileName = "../log.txt";
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


    public static  List<User> getUsersFromJSON(String fileName) throws IOException, ParseException, java.text.ParseException {
        List<User> userList = new ArrayList<User>();
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        String data="";
        int ch;
        while(( ch =fr.read())!=-1)
        {
            data += (char)ch;
        }
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(data);

        JSONArray jsonArrayUsers = (JSONArray) root.get("users");
        Iterator<JSONObject> userIterator = jsonArrayUsers.iterator();
        while(userIterator.hasNext())
        {


            JSONObject jsonObject = userIterator.next();
            String userid = (String) jsonObject.get("userID");
            if(userid.startsWith("O"))
            {
                Owner  user = new Owner();
                user.setUserID(userid);
                user.setFirstName((String)jsonObject.get("firstName"));
                user.setLastName((String)jsonObject.get("lastName"));
                user.setEmail((String)jsonObject.get("email"));
                user.setMobile((String)jsonObject.get("mobile"));
                user.setGender((jsonObject.get("gender").toString().charAt(0)));
                user.setPassword((String)jsonObject.get("password"));
                JSONArray properties = (JSONArray) jsonObject.get("properties");
                Iterator propertiesIterator = properties.iterator();
                JSONArray ownerPropertiesArray = (JSONArray) propertiesIterator.next();
                Iterator ownerPropertiesIterator = ownerPropertiesArray.iterator();
                while(ownerPropertiesIterator.hasNext())
                {
                    JSONObject oJSONObject = (JSONObject) ownerPropertiesIterator.next();
                    String propertyID = (String) oJSONObject.get("propertyID");
                    if(propertyID.startsWith("A"))
                    {
                        Apartment h = new Apartment();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());

                        user.addOwnerProperty(h);
                    }
                    else if(propertyID.startsWith("B"))
                    {
                        Basement h = new Basement();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());
                        user.addOwnerProperty(h);
                    }
                    else if(propertyID.startsWith("C"))
                    {
                        Condominium h = new Condominium();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());
                        user.addOwnerProperty(h);
                    }
                    else if(propertyID.startsWith("H"))
                    {
                        House h = new House();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());
                        user.addOwnerProperty(h);
                    }


                }
                userList.add(user);

            }
            else if(userid.startsWith("C"))
            {
                Customer user = new Customer();
                user.setUserID(userid);
                user.setFirstName((String)jsonObject.get("firstName"));
                user.setLastName((String)jsonObject.get("lastName"));
                user.setEmail((String)jsonObject.get("email"));
                user.setMobile((String)jsonObject.get("mobile"));
                user.setGender((jsonObject.get("gender").toString().charAt(0)));
                user.setPassword((String)jsonObject.get("password"));
                JSONArray properties = (JSONArray) jsonObject.get("properties");
                Iterator propertiesIterator = properties.iterator();
                propertiesIterator.next();
                JSONArray customerPropertiesArray = (JSONArray) propertiesIterator.next();
                Iterator customerPropertiesIterator = customerPropertiesArray.iterator();

                while(customerPropertiesIterator.hasNext())
                {
                    JSONObject oJSONObject = (JSONObject) customerPropertiesIterator.next();
                    String propertyID = (String) oJSONObject.get("propertyID");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    if(propertyID.startsWith("A"))
                    {
                        Apartment h = new Apartment();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String) oJSONObject.get("propertyName"));
                        h.setFullAddress((String) oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long) oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long) oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long) oJSONObject.get("price")).floatValue());
                        Date booking = sdf.parse((String) oJSONObject.get("bookingDate"));
                        Date checkin = sdf.parse((String) oJSONObject.get("checkinDate"));
                        Date checkout = sdf.parse((String) oJSONObject.get("checkoutDate"));
                        user.addCustomerProperty(h, booking, checkin, checkout);
                    }
                    else if(propertyID.startsWith("B"))
                    {
                        Basement h = new Basement();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());

                        Date booking = sdf.parse((String)oJSONObject.get("bookingDate"));
                        Date checkin = sdf.parse((String)oJSONObject.get("checkinDate"));
                        Date checkout = sdf.parse((String)oJSONObject.get("checkoutDate"));
                        user.addCustomerProperty(h, booking, checkin, checkout);
                    }
                    else if(propertyID.startsWith("C"))
                    {
                        Condominium h = new Condominium();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());

                        Date booking = sdf.parse((String)oJSONObject.get("bookingDate"));
                        Date checkin = sdf.parse((String)oJSONObject.get("checkinDate"));
                        Date checkout = sdf.parse((String)oJSONObject.get("checkoutDate"));
                        user.addCustomerProperty(h, booking, checkin, checkout);
                    }
                    else if(propertyID.startsWith("H"))
                    {
                        House h = new House();
                        h.setPropertyID(propertyID);
                        h.setPropertyName((String)oJSONObject.get("propertyName"));
                        h.setFullAddress((String)oJSONObject.get("fullAddress"));
                        h.setMaxPeopleAllowed(((Long)oJSONObject.get("maxPeopleAllowed")).byteValue());
                        h.setPerPersonPrice(((Long)oJSONObject.get("perPersonPrice")).floatValue());
                        h.setPrice(((Long)oJSONObject.get("price")).floatValue());

                        Date booking = sdf.parse((String)oJSONObject.get("bookingDate"));
                        Date checkin = sdf.parse((String)oJSONObject.get("checkinDate"));
                        Date checkout = sdf.parse((String)oJSONObject.get("checkoutDate"));
                        user.addCustomerProperty(h, booking, checkin, checkout);
                    }

                }
                userList.add(user);
            }
        }



        return userList;



    }


}
