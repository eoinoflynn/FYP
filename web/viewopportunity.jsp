<%-- 
    Document   : viewopportunity
    Created on : 02-Feb-2021, 16:49:37
    Author     : eoinp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Code taken and adapted from Retrieve data from database in jsp "https://www.roseindia.net/jsp/how-to-retrieve-data-from-database-in-jsp.shtml" -->
<!-- Reading from the MySQL database - showing all opportunities created  -->

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
String userId = "root";
String password = "Eventide1";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Available Opportunities</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#6495ED">
<td><b>Activity</b></td>
<td><b>Location</b></td>
<td><b>Payment</b></td>
<td><b>Start Date</b></td>
<td><b>End Date</b></td>
<td><b>Length</b></td>
<td><b>Dog Name</b></td>
<td><b>Dog Breed</b></td>
<td><b>Dog Age</b></td>
<td><b>Additional Information</b></td>
</tr>

<!-- below we are getting the connection (.getconnection) -->
<!-- and selecting all from the database-->
<!-- then showing result set with resultset.next  -->
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM opportunity";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#E0FFFF">
    
    <!-- displaying the records one by one by using a while loop -->

<td><%=resultSet.getString("activity") %></td>
<td><%=resultSet.getString("location") %></td>
<td><%=resultSet.getString("payment") %></td>
<td><%=resultSet.getString("sdate") %></td>
<td><%=resultSet.getString("edate") %></td>
<td><%=resultSet.getString("length") %></td>
<td><%=resultSet.getString("dname") %></td>
<td><%=resultSet.getString("dbreed") %></td>
<td><%=resultSet.getString("dage") %></td>
<td><%=resultSet.getString("additional") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

