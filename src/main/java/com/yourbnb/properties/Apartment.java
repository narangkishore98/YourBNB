package com.yourbnb.properties;

import com.yourbnb.IDisplay;

public class Apartment extends Property implements IDisplay {
     private  static int id;
     public Apartment()
     {
         id++;
         setPropertyID(id);
     }

     @Override
     public String getPropertyID()
     {
         return "A"+super.getPropertyID();
     }
    @Override
    public String propertyDescription() {
        return "An apartment, flat or unit is a self-contained housing unit that occupies only part of a building, generally on a single storey.";
    }

    @Override
    public String display() {

         return "Property Name: "+getPropertyName()+"\n" +
                 "Property ID: "+getPropertyID()+"\n" +
                 "Address: "+getFullAddress()+"\n" +
                 "Max People Allowed: "+getMaxPeopleAllowed() +"\n" +
                 "Per Person Price: "+getPerPersonPrice()+"\n" +
                 "Whole Rent Price"+getPrice();


    }

}
