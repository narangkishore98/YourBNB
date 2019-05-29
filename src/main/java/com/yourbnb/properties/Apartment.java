package com.yourbnb.properties;

import com.yourbnb.IDisplay;
import com.yourbnb.exceptions.InvalidPropertyException;

public class Apartment extends Property implements IDisplay {

     public Apartment()
     {

     }
     public Apartment(String propertyName, String fullAddress, byte maxPeopleAllowed, float perPersonPrice, float price)
     {
         if(maxPeopleAllowed<0)
         {
             throw new InvalidPropertyException("Max people cannot go in negative. your value: "+maxPeopleAllowed);
         }
         if(perPersonPrice<0)
         {
             throw new InvalidPropertyException("Per person price cannot go in negative. your value: "+perPersonPrice);
         }
         if(price<0)
         {
             throw new InvalidPropertyException("Price cannot go in negative. your value: "+price);
         }
         setPropertyName(propertyName);
         setFullAddress(fullAddress);
         setMaxPeopleAllowed(maxPeopleAllowed);
         setPerPersonPrice(perPersonPrice);
         setPrice(price);
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
