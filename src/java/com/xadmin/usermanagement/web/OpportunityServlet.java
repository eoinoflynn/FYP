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

// @WebServlet("") //(name = "OpportunityServlet", urlPatterns = {"/OpportunityServlet"}) //@WebServlet("/") 
public class OpportunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OpportunityDao opportunityDao;
        private ApplicationDao applicationDao;
   
 	public void init() {
		opportunityDao = new OpportunityDao();
                applicationDao = new ApplicationDao();
	}  
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        try {
        switch(action){
        case "/opportunity/new":
            showNewForm(request, response);
            break;
    
        case "/opportunity/insert":
            insertOpportunity(request, response);
            
        case "/opportunity/delete":
            deleteOpportunity(request, response);
            break;
            
        case "/opportunity/edit":
            showEditForm(request, response);
            break;
            
        case "/opportunity/update":
            updateOpportunity(request, response);
            break;
            
        case "/opportunity/apply":
            showApplyForm(request, response);
            break;
        
            
        case "/opportunity/list2":
            listOpportunity2(request, response);
            break;
        
        case "/opportunity/listLocation":
            listOpportunityLocation(request, response);
            break;
            
        case "/opportunity/listLocationOwner":
            listOpportunityLocationOwner(request, response);
            break;
            
     
        default:
            listOpportunity(request, response);
            break;
        }
        } catch (SQLException ex) {
			throw new ServletException(ex);
		}
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-form.jsp");
		dispatcher.forward(request, response);
    }
    
    //Insert Opportunity
    private void insertOpportunity(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
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
                Opportunity newOpportunity = new Opportunity (activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name);
		opportunityDao.insertOpportunity(newOpportunity);
		response.sendRedirect("list");
        
    }
    
    //Delete Opportunity
    private void deleteOpportunity(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
                int id = Integer.parseInt(request.getParameter("id"));
		opportunityDao.deleteOpportunity(id);
		response.sendRedirect("list");

	}
    
    //edit Opportunity
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
		Opportunity existingOpportunity = opportunityDao.selectOpportunity(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-form2.jsp");
		request.setAttribute("opportunity", existingOpportunity);
		dispatcher.forward(request, response);                     
    }
    
    //Update opportunity
    private void updateOpportunity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
		String activity = request.getParameter("activity");
		String location = request.getParameter("location");
		String payment = request.getParameter("payment"); //Int?
                String sdate = request.getParameter("sdate");
                String edate = request.getParameter("edate");
                String length = request.getParameter("length");
                String dname = request.getParameter("dname");
                String dbreed = request.getParameter("dbreed");
                String dage = request.getParameter("dage");    
                String additional = request.getParameter("additional");
                String name = request.getParameter("name");

		Opportunity book = new Opportunity(id, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name);
		opportunityDao.updateOpportunity(book);
		response.sendRedirect("list");  
    }
    
        //apply Opportunity
    private void showApplyForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
		Opportunity existingOpportunity = opportunityDao.selectOpportunity(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../apply-form.jsp");
		request.setAttribute("opportunity", existingOpportunity);
		dispatcher.forward(request, response);                     
    }
    
//        //confirm apply opportunity
//     private void insertApplication(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int appid = Integer.parseInt(request.getParameter("appid"));
//		String activity = request.getParameter("activity");
//		String location = request.getParameter("location");
//		String payment = request.getParameter("payment"); //Int?
//                String sdate = request.getParameter("sdate");
//                String edate = request.getParameter("edate");
//                String length = request.getParameter("length");
//                String dname = request.getParameter("dname");
//                String dbreed = request.getParameter("dbreed");
//                String dage = request.getParameter("dage");    
//                String additional = request.getParameter("additional");
//                String name = request.getParameter("name");
//
//		Application newApplication = new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional,name);
//		applicationDao.updateApplication(newApplication);
//		response.sendRedirect("list");  
//    }
     //list for users
         private void listOpportunity2(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Opportunity> listOpportunity2 = opportunityDao.selectAllOpportunity();
		request.setAttribute("listOpportunity2", listOpportunity2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-listuser.jsp");
		dispatcher.forward(request, response);
	}
    
    //default 
    
    private void listOpportunity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                HttpSession session = request.getSession();
                OwnerLoginBean owner = (OwnerLoginBean) session.getAttribute("owner");
		List<Opportunity> listOpportunity = opportunityDao.selectAllOpportunity(owner.getName());
		request.setAttribute("listOpportunity", listOpportunity);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-list2.jsp");
		dispatcher.forward(request, response);
	}
    
        private void listOpportunityLocation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String  location2  = request.getParameter("location");
                List<Opportunity> listOpportunityLocation = opportunityDao.selectAllOpportunityLocation(location2);
		request.setAttribute("listOpportunity", listOpportunityLocation);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-listlocation.jsp");
		dispatcher.forward(request, response);
	}
        
                private void listOpportunityLocationOwner(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
                String  location2  = request.getParameter("location");
                OwnerLoginBean owner = (OwnerLoginBean) session.getAttribute("owner");
                List<Opportunity> listOpportunityLocationOwner = opportunityDao.selectAllOpportunityLocationOwner(owner.getName(),location2);
		request.setAttribute("listOpportunity", listOpportunityLocationOwner);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-listlocationowner.jsp");
		dispatcher.forward(request, response);
	}
    
    
  
    
    

}
