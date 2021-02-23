/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin.web;

import java.io.IOException;

/* Below code taken and adapted from https://www.javaguides.net/2019/03/login-form-using-jsp-servlet-jdbc-mysql-example.html*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userlogin.bean.UserLoginBean;
import userlogin.database.UserLoginDao;

@WebServlet("/Userlogin") /* changed from /login due to clash*/
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserLoginDao loginDao;

    public void init() {
        loginDao = new UserLoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        UserLoginBean loginBean = new UserLoginBean();
        loginBean.setName(name);
        loginBean.setPass(pass);

        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("homepage2.jsp"); /* was originally loginsuccess.jsp, now just directing to homepage*/
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("login2.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}