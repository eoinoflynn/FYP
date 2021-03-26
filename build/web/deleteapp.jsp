<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String appid=request.getParameter("appid");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "Eventide1");
Statement st=conn.createStatement();
int i=st.executeUpdate("DELETE FROM application WHERE appid="+appid);
response.sendRedirect("homepage2.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>