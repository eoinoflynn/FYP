<%-- 
    Document   : opportunity-form
    Created on : 11-Mar-2021, 15:19:02
    Author     : eoinp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management Application</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
                            <form action="opportunity/list" method="post" class="mbr-form form-with-styler mx-auto">
                                                
                                <tr>
                                <label>Owner name</label> 
                                <td><input name ="name" value =${owner.name} </td>
                                </tr>
				<button type="submit" class="btn btn-success">Search</button>
				</form>
			</div>
		</div>
	</div>
    </body>
</html>
