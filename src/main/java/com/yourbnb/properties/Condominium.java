package com.yourbnb.properties;

import com.yourbnb.IDisplay;

public class Condominium extends Property implements IDisplay
{

    public Condominium()
    {

    }
    @Override
    public String getPropertyID()
    {
        return "C"+super.getPropertyID();
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
    public String display() {
        return "A condominium, often shortened to condo, in the United States of America and in most Canadian provinces, is a type of living space similar to an apartment but independently sellable and therefore regarded as real estate. ";
    }
}
