///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.xadmin.usermanagement.web;
//
//import com.xadmin.usermanagement.bean.Application;
//import com.xadmin.usermanagement.dao.ApplicationDao;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author eoinp
// */
//public class ApplicationServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private ApplicationDao applicationDao;
//   
// 	public void init() {
//		applicationDao = new ApplicationDao();
//	}  
//        
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getServletPath();
//        
//        try {
//        switch(action){
//        case "/application/insert":
//            insertApplication(request, response);
//            
//            
//        default:
//            listApplication(request, response);
//            break;
//        }
//        } catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//    }
//    
////    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
////        RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-form.jsp");
////		dispatcher.forward(request, response);
////    }
//    
//    //Insert Opportunity
//    private void insertApplication(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
//                String activity = request.getParameter("activity");
//		String location = request.getParameter("location");
//		String payment = request.getParameter("payment"); //
//                String sdate = request.getParameter("sdate");
//                String edate = request.getParameter("edate");
//                String length = request.getParameter("length");
//                String dname = request.getParameter("dname");
//                String dbreed = request.getParameter("dbreed");
//                String dage = request.getParameter("dage");    
//                String additional = request.getParameter("additional");
//                String userid = request.getParameter("userid");
//                String name = request.getParameter("name");
//                Application newApplication = new Application (activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, userid, name);
//		applicationDao.insertApplication(newApplication);
//		response.sendRedirect("list");
//        
//    }
//    
////    //Delete Opportunity
////    private void deleteOpportunity(HttpServletRequest request, HttpServletResponse response) 
////			throws SQLException, IOException {
////                int id = Integer.parseInt(request.getParameter("id"));
////		opportunityDao.deleteOpportunity(id);
////		response.sendRedirect("list");
////
////	}
////    
////    //edit Opportunity
////    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
////        int id = Integer.parseInt(request.getParameter("id"));
////		Opportunity existingOpportunity = opportunityDao.selectOpportunity(id);
////		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-form.jsp");
////		request.setAttribute("opportunity", existingOpportunity);
////		dispatcher.forward(request, response);                     
////    }
////    
////    //Update opportunity
////    private void updateOpportunity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////		String activity = request.getParameter("activity");
////		String location = request.getParameter("location");
////		String payment = request.getParameter("payment"); //Int?
////                String sdate = request.getParameter("sdate");
////                String edate = request.getParameter("edate");
////                String length = request.getParameter("length");
////                String dname = request.getParameter("dname");
////                String dbreed = request.getParameter("dbreed");
////                String dage = request.getParameter("dage");    
////                String additional = request.getParameter("additional");
////
////		Opportunity book = new Opportunity(id, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional);
////		opportunityDao.updateOpportunity(book);
////		response.sendRedirect("list");  
////    }
////    
////        //apply Opportunity
////    private void showApplyForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
////        int id = Integer.parseInt(request.getParameter("id"));
////		Opportunity existingOpportunity = opportunityDao.selectOpportunity(id);
////		RequestDispatcher dispatcher = request.getRequestDispatcher("../apply-form.jsp");
////		request.setAttribute("opportunity", existingOpportunity);
////		dispatcher.forward(request, response);                     
////    }
////    
////        //confirm apply opportunity
////     private void confirmOpportunity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
////        int id = Integer.parseInt(request.getParameter("id"));
////		String activity = request.getParameter("activity");
////		String location = request.getParameter("location");
////		String payment = request.getParameter("payment"); //Int?
////                String sdate = request.getParameter("sdate");
////                String edate = request.getParameter("edate");
////                String length = request.getParameter("length");
////                String dname = request.getParameter("dname");
////                String dbreed = request.getParameter("dbreed");
////                String dage = request.getParameter("dage");    
////                String additional = request.getParameter("additional");
////
////		Opportunity book = new Opportunity(id, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional);
////		opportunityDao.updateOpportunity(book);
////		response.sendRedirect("list");  
////    }
////    
////    //default 
//    
//    private void listApplication(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//		List<Application> listApplication = applicationDao.selectAllApplication();
//		request.setAttribute("listapplication", listApplication);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("../opportunity-list.jsp");
//		dispatcher.forward(request, response);
//	}
//    
//
//}
