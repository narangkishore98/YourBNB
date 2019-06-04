package com.yourbnb.users;

import com.yourbnb.IDisplay;
import com.yourbnb.exceptions.InvalidEmailException;
import com.yourbnb.properties.Property;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class User implements IDisplay {
    private  List<Property> ownerProperties;
    private  class CustomerProperties
    {
        private Property property;
        private Date bookingDate, checkinDate, checkoutDate;

        public Property getProperty() {
            return property;
        }

        public void setProperty(Property property) {
            this.property = property;
        }

        public Date getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(Date bookingDate) {
            this.bookingDate = bookingDate;
        }

        public Date getCheckinDate() {
            return checkinDate;
        }

        public void setCheckinDate(Date checkinDate) {
            this.checkinDate = checkinDate;
        }

        public Date getCheckoutDate() {
            return checkoutDate;
        }

        public void setCheckoutDate(Date checkoutDate) {
            this.checkoutDate = checkoutDate;
        }
    }
    private  List<CustomerProperties> customerProperties;
    private String userID;
    private String userType; // [Owner] Type [Customer] Type
    private String firstName;
    public User()
    {
        ownerProperties = new ArrayList<Property>();
        customerProperties = new ArrayList<CustomerProperties>();
    }

    public List<Property> getOwnerProperties() {
        return ownerProperties;
    }
    public void addOwnerProperty(Property property)
    {
        ownerProperties.add(property);
    }
    public void addCustomerProperty(Property property, Date bookingDate, Date checkinDate, Date checkoutDate)
    {
        CustomerProperties c = new CustomerProperties();
        c.setProperty(property);
        c.setBookingDate(bookingDate);
        c.setCheckinDate(checkinDate);
        c.setCheckoutDate(checkoutDate);
        customerProperties.add(c);
    }

    public void setOwnerProperties(List<Property> ownerProperties) {
        this.ownerProperties = ownerProperties;
    }


    public List<CustomerProperties> getCustomerProperties() {
        return customerProperties;
    }

    public void setCustomerProperties(List<CustomerProperties> customerProperties) {
        this.customerProperties = customerProperties;
    }

    private String lastName;
    private char gender; // (M/m) for males {F/f) for females
    private String email;
    private String password;
    private String mobile;
    public   String getUserID()
    {
        return  userID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getUserType() {
        return userType;
    }

    protected void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        String regex = "^[a-z0-9A-Z\\.]*@[a-z0-9A-Z]*\\.[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
            this.email=email;
        }
        else
        {
            throw new InvalidEmailException("Invalid Email.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullName()
    {
        return  getFirstName()+" "+getLastName();
    }
    public abstract  String  userDescription();
}
