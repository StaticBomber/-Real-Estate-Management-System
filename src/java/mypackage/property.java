/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Blob;
import java.util.Comparator;

/**
 *
 * @author rohan
 */
public class property {
     private String name; 
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String type;
    private float rating;
    private String owner;
    private String contact;
    private String ownerusername;
    private Blob image;
    private int propertyid;
    private int price;
    private int noofrating;
    public property(String name,String address,String city,String state,String country,String pincode,String type,float rating,String owner,String contact,String ownerusername,Blob image,int propertyid,int price,int noofrating)
    {
        this.name = name;
        this.address = address;    
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.type=type;
        this.rating=rating;
        this.owner=owner;
        this.contact=contact;
        this.ownerusername=ownerusername;
        this.image=image;
        this.propertyid=propertyid;
        this.price = price;
        this.noofrating = noofrating;
   
        
    }    
    public String getownerusername()
    {
        return ownerusername;
    }
    public float getrating()
    {
        return rating;
    }
    public String getname()
    {
        return name;
    }
    public String getaddress()
    {
        return address;
    }
    public String getowner()
    {
        return owner;
    }
    public String getcity()
    {
        return city;
    }
    public String getstate()
    {
        return state;
    }
    public String getcountry()
    {
        return country;
    }
    public String getpincode()
    {
        return pincode;
    }
    public String getcontact()
    {
        return contact;
    }
    public Blob getimage()
    {
        return image;
    }
    public String gettype()
    {
        return type;
    }
    public int getpropertyid()
    {
        return propertyid;
    }
    public int getprice()
    {
        return price;
    }
    public int getnoofrating()
    {
        return noofrating;
    }

   
}
