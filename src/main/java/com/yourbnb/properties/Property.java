package com.yourbnb.properties;
import com.yourbnb.IDisplay;
import com.yourbnb.exceptions.InvalidPropertyException;

public abstract class Property implements IDisplay {

    private  String propertyName;
    private String fullAddress;
    private byte maxPeopleAllowed;
    private float perPersonPrice;
    private float price;
    private String  propertyID;
    public   String getPropertyID()
    {
        return  (propertyID);
    }

    protected void setPropertyID(String propertyID)
    {

        this.propertyID = propertyID;
    }
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public byte getMaxPeopleAllowed() {
        return maxPeopleAllowed;
    }

    public void setMaxPeopleAllowed(byte maxPeopleAllowed) {
        if(maxPeopleAllowed<0)
        {
            throw new InvalidPropertyException("Max people cannot go in negative. your value: "+maxPeopleAllowed);
        }
        this.maxPeopleAllowed = maxPeopleAllowed;
    }

    public float getPerPersonPrice() {
        return perPersonPrice;
    }

    public void setPerPersonPrice(float perPersonPrice) {
        if(perPersonPrice<0)
        {
            throw new InvalidPropertyException("per person price cannot go in negative. your value: "+perPersonPrice);
        }
        this.perPersonPrice = perPersonPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price<0)
        {
            throw new InvalidPropertyException("price cannot go in negative. your value: "+price);
        }
        this.price = price;
    }
    public abstract  String propertyDescription();
}
