package com.yourbnb.properties;
import com.yourbnb.IDisplay;

public abstract class Property implements IDisplay {

    private  String propertyName;
    private String fullAddress;
    private byte maxPeopleAllowed;
    private float perPersonPrice;
    private float price;
    private int  propertyID;
    public   String getPropertyID()
    {
        return  Integer.toString(propertyID);
    }

    protected void setPropertyID(int propertyID)
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

    public void setMaxPeopleAllowed(byte maxPeopleAllowedd) {
        this.maxPeopleAllowed = maxPeopleAllowed;
    }

    public float getPerPersonPrice() {
        return perPersonPrice;
    }

    public void setPerPersonPrice(float perPersonPrice) {
        this.perPersonPrice = perPersonPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public abstract  String propertyDescription();
}
