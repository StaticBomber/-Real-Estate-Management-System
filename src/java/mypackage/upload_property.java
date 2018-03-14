/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize = 16177216)
/**
 *
 * @author rohan
 */
@WebServlet(name = "upload_property", urlPatterns = {"/upload_property"})
public class upload_property extends HttpServlet {

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
            out.println("<title>Servlet upload_property</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet upload_property at " + request.getContextPath() + "</h1>");
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
            
        DatabaseConnection db = new DatabaseConnection();
        
        Part part = request.getPart("image");
        InputStream si = part.getInputStream();
        Connection con = db.getCon();
            try {
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO property_data(name,address,city,state,country,pincode,type,owner,image,contact,ownerusername,price)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,request.getParameter("name"));
                ps.setString(2,request.getParameter("address"));
                ps.setString(3,request.getParameter("city"));
                ps.setString(4,request.getParameter("state"));
                ps.setString(5,request.getParameter("country"));
                ps.setString(6,request.getParameter("pincode"));
                ps.setString(7,request.getParameter("type"));
                ps.setString(8,request.getParameter("owner"));
                ps.setBlob(9,si);
                ps.setString(10,request.getParameter("contact"));
                ps.setString(11,LoginBackend.username);
                ps.setString(12,request.getParameter("price"));
                ps.executeUpdate();                 
                response.sendRedirect("owner_dashboard.jsp");
               
           } catch (Exception ex) {
              
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
