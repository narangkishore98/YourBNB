package com.yourbnb.properties;

import com.yourbnb.IDisplay;

public class Basement  extends  Property implements IDisplay {

    private static  int id;
    public Basement()
    {
        setPropertyID(++id);
    }
    @Override
    public String propertyDescription() {
        return "Property Name: "+getPropertyName()+"\n" +
                "Property ID: "+getPropertyID()+"\n" +
                "Address: "+getFullAddress()+"\n" +
                "Max People Allowed: "+getMaxPeopleAllowed() +"\n" +
                "Per Person Price: "+getPerPersonPrice()+"\n" +
                "Whole Rent Price"+getPrice();
    }
    @Override
    public String getPropertyID()
    {
        return "B"+super.getPropertyID();
    }

    @Override
    public String display() {
        return "A basement or cellar is one or more floors of a building that are completely or partly below the ground floor. ";
    }
}
