/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

/**
 *
 * @author rohan
 */
public class tenant {
    private String username; 
    private String email ;
    private String name;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String country;
    private String pincode;
    public tenant(String username,String email,String name,String address,String phone,String city,String state,String country,String pincode)
    {
        this.username = username;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
   
        
    }    
    public String getusername()
    {
        return username;
    }
    public String getemail()
    {
        return email;
    }
    public String getname()
    {
        return name;
    }
    public String getaddress()
    {
        return address;
    }
    public String getphone()
    {
        return phone;
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
}
