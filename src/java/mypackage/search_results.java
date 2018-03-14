/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rohan
 */
@WebServlet(name = "search_results", urlPatterns = {"/search_results"})
public class search_results extends HttpServlet {
public static ArrayList<property> search_list;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet search_results</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search_results at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("order").equals("1")){
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String type = request.getParameter("type");        
        String price = request.getParameter("price");
        int price1;
        if(price.length()>0){price1  = Integer.parseInt(price);}
        else{price1 = 100000000;}

  
    search_list = new ArrayList<property>();
    
           DatabaseConnection db= new DatabaseConnection();
           Connection con = db.getCon();
           String query = "SELECT * FROM property_data";
        try {
         
            java.sql.Statement st;
            ResultSet rs;
            st=con.createStatement();
            rs=st.executeQuery(query);
            property t;
            while(rs.next())
            {
                if(type.length()==0&&price.length()==0&&rs.getString("city").equals(city)&&rs.getString("state").equals(state)&&rs.getInt("status")==0){
                     t = new property(rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("type"),rs.getFloat("rating"),rs.getString("owner"),rs.getString("contact"),rs.getString("ownerusername"),rs.getBlob("image"),rs.getInt("propertyid"),rs.getInt("price"),rs.getInt("noofrating"));
                search_list.add(t);
                }
                else if(type.length()>0&&price.length()==0&&rs.getString("city").equals(city)&&rs.getString("state").equals(state)&&rs.getInt("status")==0&&rs.getString("type").equals(type)){
                     t = new property(rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("type"),rs.getFloat("rating"),rs.getString("owner"),rs.getString("contact"),rs.getString("ownerusername"),rs.getBlob("image"),rs.getInt("propertyid"),rs.getInt("price"),rs.getInt("noofrating"));
                search_list.add(t);
                }
                else if(type.length()==0&&price.length()>0&&rs.getString("city").equals(city)&&rs.getString("state").equals(state)&&rs.getInt("status")==0&&rs.getInt("price")<price1){
                     t = new property(rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("type"),rs.getFloat("rating"),rs.getString("owner"),rs.getString("contact"),rs.getString("ownerusername"),rs.getBlob("image"),rs.getInt("propertyid"),rs.getInt("price"),rs.getInt("noofrating"));
                search_list.add(t);
                }
                else if(type.length()>0&&price.length()>0&&rs.getString("city").equals(city)&&rs.getString("state").equals(state)&&rs.getInt("status")==0&&rs.getInt("price")<price1&&rs.getString("type").equals(type)){
                     t = new property(rs.getString("name"),rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("country"),rs.getString("pincode"),rs.getString("type"),rs.getFloat("rating"),rs.getString("owner"),rs.getString("contact"),rs.getString("ownerusername"),rs.getBlob("image"),rs.getInt("propertyid"),rs.getInt("price"),rs.getInt("noofrating"));
                search_list.add(t);
                }
            }
            response.sendRedirect("search_results.jsp");
        }  
         catch (SQLException ex) {
           
        }}
        if(request.getParameter("order").equals("3")){
            Collections.sort(search_list,Comparator.comparingInt(property::getprice).reversed());
       response.sendRedirect("search_results.jsp");
    
        }
        else if(request.getParameter("order").equals("2")){
            Collections.sort(search_list,Comparator.comparingInt(property::getprice));
       response.sendRedirect("search_results.jsp");
        }
        
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
