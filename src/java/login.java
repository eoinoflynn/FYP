/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eoinp
 */
public class login extends HttpServlet {

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
            /* Code taken and adapted from Java Database connectivity "https://www.youtube.com/watch?v=akW6bzoRcZo&app=desktop" */
            /* Creating user - making the connection to the db */
            String uname = request.getParameter("uname"); /* Taking the variables uname and pass */
            String pass = request.getParameter("pass");
            MyDb db = new MyDb(); /* Creating an object connection class*/
            Connection con = db.getCon();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into user (name,pass) values('"+uname+"','"+pass+"')");
            /* out.println("every thing is fine data is inserted"); */
            
             /* code was taken and adapted from: "https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp?fbclid=IwAR1aHDfhS-34Vx3NgwT1xpHmGnA9ki0-XjWNJGl4h_rJoQslKeBrDQfX4fg" */
              /* The below code shows an alert in the jsp and redirects the user to the createopp.jsp location*/
                out.println("<script type=\"text/javascript\">");
                out.println("alert('The User has been created');");
                out.println("location='homepage2.jsp';");
                out.println("</script>");
       
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
