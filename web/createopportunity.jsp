<%-- 
    Document   : createopportunity
    Created on : 02-Feb-2021, 13:55:22
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
        <!--  Creating opportunity -->
        <!--  allows for input of text from front-end -->
        <form action="opportunity" method="post"> <!--  opportunity references the opportunity servlet -->
        <pre>
        <input type="text" name="activity" placeholder="Activity"/>
        <input type="text" name="location" placeholder="Location"/>
        <input type="text" name="payment" placeholder="Payment"/>
        <input type="text" name="sdate" placeholder="Start Date"/>
        <input type="text" name="edate" placeholder="End Date"/>
        <input type="text" name="length" placeholder="Length"/>
        <input type="text" name="dname" placeholder="Dog Name"/>
        <input type="text" name="dbreed" placeholder="Dog Breed"/>
        <input type="text" name="dage" placeholder="Dog Age"/>
        <input type="text" name="additional" placeholder="Additional Information"/>
        <input type="submit" value="Create Opportunity"/>
        </pre>
        </form>
    </body>
</html>
