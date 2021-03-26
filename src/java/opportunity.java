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
 * Code taken and adapted from Java Database connectivity "https://www.youtube.com/watch?v=akW6bzoRcZo&app=desktop"
 */
public class opportunity extends HttpServlet {

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
            /* Creating opportunity - making the connection to the db*/
            String activity = request.getParameter("activity"); /* Taking the variables activity, location, etc */
            String location = request.getParameter("location");
            String payment = request.getParameter("payment");
            String sdate = request.getParameter("sdate");
            String edate = request.getParameter("edate");
            String length = request.getParameter("length");
            String dname = request.getParameter("dname");
            String dbreed = request.getParameter("dbreed");
            String dage = request.getParameter("dage");
            String additional = request.getParameter("additional");
            String name = request.getParameter("name");
            
            OppDb db = new OppDb(); /* Creating an object connection class*/
            Connection con = db.getCon();
            Statement stmt = con.createStatement();
             stmt.executeUpdate("insert into opportunity (activity,location,payment,sdate,edate,length,dname,dbreed,dage,additional, name) values('"+activity+"','"+location+"','"+payment+"','"+sdate+"','"+edate+"','"+length+"','"+dname+"','"+dbreed+"','"+dage+"','"+additional+"','"+name+"')");
             /* out.println("the opportunity has been created"); */
             
             /* code was taken and adapted from: "https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp?fbclid=IwAR1aHDfhS-34Vx3NgwT1xpHmGnA9ki0-XjWNJGl4h_rJoQslKeBrDQfX4fg" */
              /* The below code shows an alert in the jsp and redirects the user to the createopp.jsp location*/
                out.println("<script type=\"text/javascript\">");
//                out.println("alert('The opportunity has been created');");
                out.println("location='opportunity/list';");
                out.println("</script>");
                

    }   catch (SQLException ex) {
            Logger.getLogger(opportunity.class.getName()).log(Level.SEVERE, null, ex);
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
