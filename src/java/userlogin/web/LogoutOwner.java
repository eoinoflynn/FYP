/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * https://www.codejava.net/coding/how-to-code-login-and-logout-with-java-servlet-jsp-and-mysql
 */
@WebServlet("/LogoutOwner")
public class LogoutOwner extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutOwner() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("owner");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("whatareyou.jsp");
            dispatcher.forward(request, response);
        }
    }
}
