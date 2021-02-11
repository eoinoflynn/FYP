<%-- 
    Document   : createuser
    Created on : 01-Feb-2021, 15:22:43
    Author     : eoinp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Code taken and adapted from Java Database connectivity "https://www.youtube.com/watch?v=akW6bzoRcZo&app=desktop" -->
        <!--  Creating user -->
        <!--  input text -->
        <form action="login" method="post"> <!--  login references the login servlet -->
        <pre>
        <input type="text" name="uname" placeholder="username"/>
        <input type="text" name="pass" placeholder="password"/>
        <input type="submit" value="Create User"/>
        
        </pre>
            </form>
    </body>
</html>
