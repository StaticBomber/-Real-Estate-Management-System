/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rohan
 */
@WebServlet(name = "make_booking", urlPatterns = {"/make_booking"})
public class make_booking extends HttpServlet {

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
            out.println("<title>Servlet make_booking</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet make_booking at " + request.getContextPath() + "</h1>");
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
        int propertyid = Integer.parseInt(request.getParameter("property_book"));
        
        String ownerusername=null;
        String tenantusername = LoginBackend.username;
         DatabaseConnection db = new DatabaseConnection();
         ArrayList<property> list = db.get_property_list();
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).getpropertyid()==propertyid)
             {
                 ownerusername = list.get(i).getownerusername();
                 break;
             }
         }
         System.out.println(propertyid+" "+ownerusername+" "+tenantusername);
        Connection con = db.getCon();
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO booking_data (tenantusername,ownerusername,propertyid)"+"values(?,?,?)");
                ps.setString(1,tenantusername);
                ps.setString(2,ownerusername);
                ps.setInt(3,propertyid);
                ps.executeUpdate();                 
               
           } catch (Exception ex) {
              
           }
          String UpdateQuery2 = null;
                PreparedStatement ps2=null;
                DatabaseConnection db2 = new DatabaseConnection();
                Connection con2=db2.getCon();
                try {
                    UpdateQuery2 = "Update property_data SET status=? WHERE propertyid=?";
                    ps2=con.prepareStatement(UpdateQuery2);
                    ps2.setInt(1,1);
                    ps2.setInt(2,propertyid);                
                    

                    ps2.executeUpdate();

                    

                } catch (SQLException ex) {
                  
                }
          
              
         ArrayList<booking> booking_list = db2.get_booking_list();
         int bookingid = booking_list.get(booking_list.size()-1).getbookingid();
            try {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO rating_data (bookingid,propertyid,tenantusername)"+"values(?,?,?)");
                    ps.setInt(1, bookingid);
                    ps.setInt(2, propertyid);
                    ps.setString(3, tenantusername);
                    ps.executeUpdate();    
                   
                     response.sendRedirect("tenant_dashboard.jsp");
            } catch (Exception ex) {
                        ex.printStackTrace();
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
