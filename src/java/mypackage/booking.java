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
public class booking {
    private String ownerusername;
    private String tenantusername;
    private int bookingid;
    private int propertyid;
    private int status;
    public booking(String ownerusername,String tenantusername,int bookingid,int propertyid,int status)
    {
        this.ownerusername = ownerusername;
        this.tenantusername =tenantusername;
        this.bookingid = bookingid;
        this.propertyid = propertyid;
        this.status = status;
    }
    public String getownerusername()
    {
        return ownerusername;
    }
    public String gettenantusername()
    {
        return tenantusername;
    }
    public int getbookingid()
    {
        return bookingid;
    }
    public int getpropertyid()
    {
        return propertyid;
    }
    public int getstatus()
    {
        return status;
    }
    
}
