<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";%>
<%!String user = "root";%>
<%!String psw = "Eventide1";%>
<%
String id = request.getParameter("id");
String activity=request.getParameter("activity");
String location=request.getParameter("location");
String payment=request.getParameter("payment");
String sdate=request.getParameter("sdate");
String edate=request.getParameter("edate");
String length=request.getParameter("length");
String dname=request.getParameter("dname");
String dbreed=request.getParameter("dbreed");
String dage=request.getParameter("dage");
String additional=request.getParameter("additional");
if(id != null)
{
Connection con = null;
PreparedStatement ps = null;
int Personid = Integer.parseInt(id);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update opportunity set activity=?,location=?,payment=?,sdate=?,edate=?,length=?,dname=?,dbreed=?,dage=?,additional=? where id="+id;
ps = con.prepareStatement(sql);
ps.setString(1, activity);
ps.setString(2, location);
ps.setString(3, payment);
ps.setString(4, sdate);
ps.setString(5, edate);
ps.setString(6, length);
ps.setString(7, dname);
ps.setString(8, dbreed);
ps.setString(9, dage);
ps.setString(10, additional);

int i = ps.executeUpdate();
if(i > 0)
{
response.sendRedirect("searchopportunity.jsp");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>
