package mypackage;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con=null;
        try {            
            con=DriverManager.getConnection("jdbc:mysql://localhost/main_database","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<tenant> get_tenant_list(){
           ArrayList<tenant> tenant_list;
           tenant_list = new ArrayList<tenant>();
           Connection con = getCon();
           String query = "SELECT * FROM tenant_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            tenant t;
            while(rs.next())
            {
                t = new tenant(rs.getString("username"),rs.getString("email"),rs.getString("name"),rs.getString("address"),rs.getString("phone"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"));
                tenant_list.add(t);
            }
            
        } catch (SQLException ex) {
           
        }
        return tenant_list;
    }
    public ArrayList<owner> get_owner_list(){
           ArrayList<owner> owner_list;
           owner_list = new ArrayList<owner>();
           Connection con = getCon();
           String query = "SELECT * FROM owner_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            owner t;
            while(rs.next())
            {
                t = new owner(rs.getString("username"),rs.getString("email"),rs.getString("name"),rs.getString("address"),rs.getString("phone"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"));
                owner_list.add(t);
            }
            
        } catch (SQLException ex) {
           
        }
        return owner_list;
    }
    
    public ArrayList<property> get_property_list(){
           ArrayList<property> property_list;
           property_list = new ArrayList<property>();
           Connection con = getCon();
           String query = "SELECT * FROM property_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            property t;
            while(rs.next())
            {
                t = new property(rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("type"),rs.getFloat("rating"),rs.getString("owner"),rs.getString("contact"),rs.getString("ownerusername"),rs.getBlob("image"),rs.getInt("propertyid"),rs.getInt("price"),rs.getInt("noofrating"));
                property_list.add(t);
            }
            
        } catch (SQLException ex) {
           
        }
        return property_list;
    }
    
    
     public ArrayList<booking> get_booking_list(){
           ArrayList<booking> booking_list;
           booking_list = new ArrayList<booking>();
           Connection con = getCon();
           String query = "SELECT * FROM booking_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            booking t;
            while(rs.next())
            {
                t = new booking(rs.getString("ownerusername"),rs.getString("tenantusername"),rs.getInt("bookingid"),rs.getInt("propertyid"),rs.getInt("status"));
                booking_list.add(t);
            }
            
        } catch (SQLException ex) {
           
        }
        return booking_list;
    }
     public ArrayList<rating> get_rating_list(){
           ArrayList<rating> rating_list;
           rating_list = new ArrayList<rating>();
           Connection con = getCon();
           String query = "SELECT * FROM rating_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            rating t;
            while(rs.next())
            {
                t = new rating(rs.getInt("propertyid"),rs.getInt("bookingid"),rs.getInt("rating"),rs.getInt("status"),rs.getString("tenantusername"));
                rating_list.add(t);
            }
            
        } catch (SQLException ex) {
           
        }
        return rating_list;
    }
}
