<%-- 
    Document   : opportunity-form
    Created on : 11-Mar-2021, 15:19:02
    Author     : eoinp
--%>

<!-- Currently using opportunity-form2.jsp -->

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

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Opportunities</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${opportunity != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${opportunity == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${opportunity != null}">
            			Edit opportunity
            		</c:if>
						<c:if test="${opportunity == null}">
            			Add New opportunity
            		</c:if>
					</h2>
				</caption>

				<c:if test="${opportunity != null}">
					<input type="hidden" name="id" value="<c:out value='${opportunity.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>opportunity activity</label> <input type="text"
						value="<c:out value='${opportunity.activity}' />" class="form-control"
						name="activity" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>opportunity location</label> <input type="text"
						value="<c:out value='${opportunity.location}' />" class="form-control"
						name="location">
				</fieldset>

				<fieldset class="form-group">
					<label>opportunity payment</label> <input type="text"
						value="<c:out value='${opportunity.payment}' />" class="form-control"
						name="payment">
				</fieldset>
                                                
                                				<fieldset class="form-group">
					<label>opportunity sdate</label> <input type="text"
						value="<c:out value='${opportunity.sdate}' />" class="form-control"
						name="sdate">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity edate</label> <input type="text"
						value="<c:out value='${opportunity.edate}' />" class="form-control"
						name="edate">
				</fieldset>
                                
                                <fieldset class="form-group">
					<label>opportunity length</label> <input type="text"
						value="<c:out value='${opportunity.length}' />" class="form-control"
						name="length">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dname</label> <input type="text"
						value="<c:out value='${opportunity.dname}' />" class="form-control"
						name="dname">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dbreed</label> <input type="text"
						value="<c:out value='${opportunity.dbreed}' />" class="form-control"
						name="dbreed">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dage</label> <input type="text"
						value="<c:out value='${opportunity.dage}' />" class="form-control"
						name="dage">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity additional</label> <input type="text"
						value="<c:out value='${opportunity.additional}' />" class="form-control"
						name="additional">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity name</label> <input type="text"
						value="<c:out value='${opportunity.name}' />" class="form-control"
						name="name">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
    </body>
</html>
