<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
String userid = "root";
String password = "Eventide1";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl, userid, password);
statement=connection.createStatement();
String sql ="select * from opportunity where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<input type="text" name="id" value="<%=resultSet.getString("id") %>">
<br>
Activity<br>
<input type="text" name="activity" value="<%=resultSet.getString("activity") %>">
<br>
Location<br>
<input type="text" name="location" value="<%=resultSet.getString("location") %>">
<br>
Payment<br>
<input type="text" name="payment" value="<%=resultSet.getString("payment") %>">
<br>
Start Date<br>
<input type="text" name="sdate" value="<%=resultSet.getString("sdate") %>">
<br>
End Date<br>
<input type="text" name="edate" value="<%=resultSet.getString("edate") %>">
<br>
Length<br>
<input type="text" name="length" value="<%=resultSet.getString("length") %>">
<br>
Dog Name<br>
<input type="text" name="dname" value="<%=resultSet.getString("dname") %>">
<br>
Dog Breed<br>
<input type="text" name="dbreed" value="<%=resultSet.getString("dbreed") %>">
<br>
Dog Age<br>
<input type="text" name="dage" value="<%=resultSet.getString("dage") %>">
<br>
Additional<br>
<input type="text" name="additional" value="<%=resultSet.getString("additional") %>">
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
