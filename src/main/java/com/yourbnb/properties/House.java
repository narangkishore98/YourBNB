package com.yourbnb.properties;

import com.yourbnb.IDisplay;

public class House extends Property implements IDisplay
{

    public House()
    {
    }
    @Override
    public String getPropertyID()
    {
        return "H"+super.getPropertyID();
    }



    @Override
    public String propertyDescription() {
        return "a building for human habitation, especially one that is lived in by a family or small group of people.";
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
