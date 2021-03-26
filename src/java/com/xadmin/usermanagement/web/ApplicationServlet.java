/*
 * 
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 * 
 */
package com.xadmin.usermanagement.web;

import com.xadmin.usermanagement.bean.Application;
import com.xadmin.usermanagement.bean.Opportunity;
import com.xadmin.usermanagement.dao.ApplicationDao;
import com.xadmin.usermanagement.dao.OpportunityDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userlogin.bean.OwnerLoginBean;
import userlogin.bean.UserLoginBean;

// @WebServlet("") //(name = "OpportunityServlet", urlPatterns = {"/OpportunityServlet"}) //@WebServlet("/") 
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private ApplicationDao applicationDao;
   
 	public void init() {
                applicationDao = new ApplicationDao();
	}  
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        try {
        switch(action){
        case "/application/new":
            showNewForm(request, response);
            break;
    
        case "/application/insert":
            insertApplication(request, response);
            
       case "/application/delete":
            deleteApplication(request, response);
            break;
            
        case "/application/edit":
            showEditForm(request, response);
            break;
            
        case "/application/update":
            updateApplication(request, response);
            break;
            
        case "/application/listuser":
            listApplicationUser(request, response);
            break;

       case "/application/deleteuser":
            deleteApplicationUser(request, response);
            break;
            
        case "/application/listLocation":
            listApplicationLocation(request, response);
            break;
                   
        case "/application/listLocationOwner":
            listApplicationLocationOwner(request, response);
            break;
            

        default:
            listApplication(request, response);
            break;
        }
        } catch (SQLException ex) {
			throw new ServletException(ex);
		}
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../application-form.jsp");
		dispatcher.forward(request, response);
    }
    
    //Insert Opportunity
    private void insertApplication(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
                String activity = request.getParameter("activity");
		String location = request.getParameter("location");
		String payment = request.getParameter("payment"); //
                String sdate = request.getParameter("sdate");
                String edate = request.getParameter("edate");
                String length = request.getParameter("length");
                String dname = request.getParameter("dname");
                String dbreed = request.getParameter("dbreed");
                String dage = request.getParameter("dage");    
                String additional = request.getParameter("additional");
                String name = request.getParameter("name");
                String userName = request.getParameter("userName");
                String status = request.getParameter("status");
                String message = request.getParameter("message");
                Application newApplication = new Application (activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message);
		applicationDao.insertApplication(newApplication);
		response.sendRedirect("list");
        
    }
    
    //Delete Opportunity
    private void deleteApplication(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
                int appid = Integer.parseInt(request.getParameter("appid"));
		applicationDao.deleteApplication(appid);
		response.sendRedirect("list");

	}
    
        //Delete Opportunity
    private void deleteApplicationUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
                int appid = Integer.parseInt(request.getParameter("appid"));
		applicationDao.deleteApplication(appid);
		response.sendRedirect("../application/listuser");

	}
    
    //edit Opportunity
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
        int appid = Integer.parseInt(request.getParameter("appid"));
		Application existingApplication = applicationDao.selectApplication(appid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../application-form.jsp");
		request.setAttribute("application", existingApplication);
		dispatcher.forward(request, response);                     
    }
    
    //Update opportunity
    private void updateApplication (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int appid = Integer.parseInt(request.getParameter("appid"));
		String activity = request.getParameter("activity");
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
                String userName = request.getParameter("userName");
                String status = request.getParameter("status");
                String message = request.getParameter("message");

		Application book = new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message);
		applicationDao.updateApplication(book);
		response.sendRedirect("list");  
    }

    //default 
    
    private void listApplication(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                HttpSession session = request.getSession();
                OwnerLoginBean owner = (OwnerLoginBean) session.getAttribute("owner");
		List<Application> listApplication = applicationDao.selectAllApplication(owner.getName());
		request.setAttribute("listApplication", listApplication);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../application-list.jsp");
		dispatcher.forward(request, response);
	}
    
        private void listApplicationUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                HttpSession session = request.getSession();
                UserLoginBean user = (UserLoginBean) session.getAttribute("user");
		List<Application> listApplicationUser = applicationDao.selectAllApplicationUser(user.getName());
		request.setAttribute("listApplication", listApplicationUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../application-listuser.jsp");
		dispatcher.forward(request, response);
	}
    
                private void listApplicationLocation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                HttpSession session = request.getSession();
                String  location2  = request.getParameter("location");
                UserLoginBean user = (UserLoginBean) session.getAttribute("user");
		List<Application> listApplicationLocation = applicationDao.selectAllApplicationLocation(user.getName(),location2);
		request.setAttribute("listApplication", listApplicationLocation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../application-listlocation.jsp");
		dispatcher.forward(request, response);
	}
                
                private void listApplicationLocationOwner(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                HttpSession session = request.getSession();
                String  location2  = request.getParameter("location");
                OwnerLoginBean owner = (OwnerLoginBean) session.getAttribute("owner");
		List<Application> listApplicationLocationOwner = applicationDao.selectAllApplicationLocationOwner(owner.getName(),location2);
		request.setAttribute("listApplicationOwner", listApplicationLocationOwner);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../application-listlocationowner.jsp");
		dispatcher.forward(request, response);
	}
    
  
    
    

}
