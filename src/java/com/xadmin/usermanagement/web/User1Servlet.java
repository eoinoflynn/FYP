/*
 * 
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 * 
 */
package com.xadmin.usermanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.bean.User1;
import com.xadmin.usermanagement.dao.User1Dao;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author eoinp
 */
public class User1Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private User1Dao userDao;

public void init() {
    userDao = new User1Dao();
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getServletPath();   
      try {
			switch (action) {
			case "/user/new":
				showNewForm(request, response);
				break;
			case "/user/insert":
				insertUser(request, response);
				break;
			case "/user/delete":
				deleteUser(request, response);
				break;
			case "/user/edit":
				showEditForm(request, response);
				break;
			case "/user/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
       }
      }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../user-form.jsp");
		dispatcher.forward(request, response);
    }
    
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User1 newUser = new User1(name, pass);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}
        
        private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		userDao.deleteUser(userid);
		response.sendRedirect("list");

	}
        
        	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		User1 existingUser = userDao.selectUser(userid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
                
          	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User1 book = new User1(userid, name, pass);
		userDao.updateUser(book);
		response.sendRedirect("list");
	} 
                
         private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User1> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../user-list.jsp");
		dispatcher.forward(request, response);
	}      
        
        
}