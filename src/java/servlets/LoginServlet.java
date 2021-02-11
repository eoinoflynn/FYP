/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import utils.IConstants;
import utils.StringUtils;

/**
 *
 * @author be_me
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (StringUtils.isStringEmpty(email) || StringUtils.isStringEmpty(password)) {

            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);

        } else {

            UserService uServ = new UserService();
            User user = uServ.loginUser(email, password);
            if (user == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Home");
                rd.forward(request, response);
            } else {
                request.getSession(true).setAttribute(IConstants.SESSION_KEY_USER, user);
                if (user.getUserType().equals(IConstants.USER_TYPE_ADMIN)) {
                    RequestDispatcher rd = request.getRequestDispatcher("/adminHome.jsp");
                    rd.forward(request, response);
                } else if (user.getUserType().equals(IConstants.USER_TYPE_GENERAL)) {
                    RequestDispatcher rd = request.getRequestDispatcher("/Home");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/Home");
                    rd.forward(request, response);
                }
            }
        }
        UserService uServ = new UserService();
        User u1 = uServ.loginUser(email, password);
        String url = null;
        
        if (u1.getUserType() == IConstants.USER_TYPE_ADMIN){
            url = "Home";
        }
        
        request.getRequestDispatcher("/Home").forward(request, response);
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
