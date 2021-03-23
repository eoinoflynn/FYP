/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin.web;

/* Below code taken and adapted from https://www.codejava.net/coding/how-to-code-login-and-logout-with-java-servlet-jsp-and-mysql*/
 
import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import userlogin.bean.OwnerLoginBean;
import userlogin.database.OwnerLoginDAO;
 
@WebServlet("/OwnerLogin")
public class OwnerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public OwnerLoginServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
         
        OwnerLoginDAO ownerLoginDao = new OwnerLoginDAO();
         
        try {
            OwnerLoginBean owner = ownerLoginDao.checkLogin(name, pass);
            String destPage = "loginowner.jsp";
             
            if (owner != null) {
                HttpSession session = request.getSession();
                session.setAttribute("owner", owner);
                destPage = "homepageowner2.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}