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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rohan
 */
@WebServlet(name = "updaterating", urlPatterns = {"/updaterating"})
public class updaterating extends HttpServlet {

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
            out.println("<title>Servlet updaterating</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updaterating at " + request.getContextPath() + "</h1>");
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
         int rating = Integer.parseInt(request.getParameter("rating"));
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        int propertyid=0;
        DatabaseConnection db = new DatabaseConnection();  
        ArrayList<booking> booking_list = db.get_booking_list();
        for(int i=0;i<booking_list.size();i++){
            if(booking_list.get(i).getbookingid()==bookingid){
                propertyid= booking_list.get(i).getpropertyid();
                break;
            }
        }
        System.out.println(request.getParameter("propertyid")+request.getParameter("rating"));      
         
        float initial_rating = 0;
        
        int noofrating = 0;
        ArrayList<property> list = db.get_property_list();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getpropertyid()==propertyid)
            {
                initial_rating =list.get(i).getrating();
                noofrating = list.get(i).getnoofrating();
                break;
            }
        }
        DecimalFormat df = new DecimalFormat(".#");
        float final_rating = (initial_rating*noofrating + rating)/(noofrating+1);
                Connection con=db.getCon();
                String UpdateQuery = null;
                PreparedStatement ps=null;
                try {
                    UpdateQuery = "Update property_data SET rating=?,noofrating=? WHERE propertyid=?";
                    ps=con.prepareStatement(UpdateQuery);
                    ps.setFloat(1,final_rating);
                    ps.setInt(2, noofrating+1);
                    ps.setInt(3,propertyid);             
                    

                    ps.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(update_tenant_profile.class.getName()).log(Level.SEVERE, null, ex);
                }
            try {
                    UpdateQuery = "Update booking_data SET status=? WHERE bookingid=?";
                    ps=con.prepareStatement(UpdateQuery);
                    
                    ps.setInt(1, 1);       
                    ps.setInt(2,bookingid);

                    ps.executeUpdate();

                    response.sendRedirect("rating.jsp");

                } catch (SQLException ex) {
                    Logger.getLogger(update_tenant_profile.class.getName()).log(Level.SEVERE, null, ex);
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
