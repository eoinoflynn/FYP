<%-- 
    Document   : opportunity-list
    Created on : 11-Mar-2021, 15:06:21
    Author     : eoinp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> User
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">List</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Opportunities</h3>
			<hr>
			<div class="container text-left">

				<a href="new" class="btn btn-success">Add 
					New Opportunity</a> 
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Activity</th>
						<th>Location</th>
						<th>Payment</th>
						<th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Length</th>
                                                <th>Dog Name</th>
                                                <th>Dog Breed</th>
                                                <th>Dog Age</th>
                                                <th>Additional</th>
                                                <th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="opportunity" items="${listOpportunity}">

						<tr>
							<td><c:out value="${opportunity.id}" /></td>
							<td><c:out value="${opportunity.activity}" /></td>
							<td><c:out value="${opportunity.location}" /></td>
							<td><c:out value="${opportunity.payment}" /></td>
                                                        <td><c:out value="${opportunity.sdate}" /></td>
                                                        <td><c:out value="${opportunity.edate}" /></td>
                                                        <td><c:out value="${opportunity.length}" /></td>
                                                        <td><c:out value="${opportunity.dname}" /></td>
                                                        <td><c:out value="${opportunity.dbreed}" /></td>
                                                        <td><c:out value="${opportunity.dage}" /></td>
                                                        <td><c:out value="${opportunity.additional}" /></td>
							<td><a href="edit?id=<c:out value='${opportunity.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${opportunity.id}' />">Delete</a>
                                                                &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="apply?id=<c:out value='${opportunity.id}' />">Apply</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
    </body>
</html>
