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
@WebServlet(name = "update_owner_profile", urlPatterns = {"/update_owner_profile"})
public class update_owner_profile extends HttpServlet {

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
            out.println("<title>Servlet update_owner_profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_owner_profile at " + request.getContextPath() + "</h1>");
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
        String username = LoginBackend.username;
                String UpdateQuery = null;
                PreparedStatement ps=null;
                DatabaseConnection db = new DatabaseConnection();
                Connection con=db.getCon();
                try {
                    UpdateQuery = "Update owner_data SET name=?,email=?,password=?,address=?,phone=?,city=?,state=?,country=?,pincode=? WHERE username=?";
                    ps=con.prepareStatement(UpdateQuery);
                    ps.setString(1,request.getParameter("name"));
                    ps.setString(2,request.getParameter("email"));
                    ps.setString(3,request.getParameter("password"));
                    ps.setString(4,request.getParameter("address"));
                    ps.setString(5,request.getParameter("phone"));
                    ps.setString(6,request.getParameter("city"));
                    ps.setString(7,request.getParameter("state"));
                    ps.setString(8,request.getParameter("country"));
                    ps.setString(9,request.getParameter("pincode"));
                    ps.setString(10,username);                  
                    

                    ps.executeUpdate();

                    response.sendRedirect("owner_profile.jsp");

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
