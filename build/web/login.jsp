<%-- 
    Document   : login
    Created on : 22-Feb-2021, 16:46:42
    Author     : eoinp
--%>

<!-- Original Log-In form, no longer in use -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Login Form</h1>
  <form action="<%=request.getContextPath()%>/Userlogin" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="text" name="pass" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>