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
public class rating {
    private int propertyid,bookingid,rating,status;
    private String tenantusername;
    public rating(int propertyid,int bookingid,int rating,int status,String tenantusername){
        this.propertyid = propertyid;
        this.bookingid = bookingid;
        this.rating = rating;
        this.status = status;
        this.tenantusername = tenantusername;
    }
    public int getpropertyid(){
        return propertyid;
    }
    public int getbookingid(){
        return bookingid;
    }
    public int getrating(){
        return rating;
    }
    public int getstatus(){
        return status;
    }
    public String tenantusername(){
        return tenantusername;
    }
    
}
