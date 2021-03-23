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
                            <form action="../application" method="post" class="mbr-form form-with-styler mx-auto">

				<fieldset class="form-group">
					<label>opportunity activity</label> <input type="text"
                                                value="<c:out value='${opportunity.activity}' />" readonly="" class="form-control"
						name="activity" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>opportunity location</label> <input type="text"
						value="<c:out value='${opportunity.location}' />" readonly=""  class="form-control"
						name="location">
				</fieldset>

				<fieldset class="form-group">
					<label>opportunity payment</label> <input type="text"
						value="<c:out value='${opportunity.payment}' />" readonly=""  class="form-control"
						name="payment">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity sdate</label> <input type="text"
						value="<c:out value='${opportunity.sdate}' />" readonly=""  class="form-control"
						name="sdate">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity edate</label> <input type="text"
						value="<c:out value='${opportunity.edate}' />" readonly=""  class="form-control"
						name="edate">
				</fieldset>
                                
                                <fieldset class="form-group">
					<label>opportunity length</label> <input type="text"
						value="<c:out value='${opportunity.length}' />" readonly=""  class="form-control"
						name="length">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dname</label> <input type="text"
						value="<c:out value='${opportunity.dname}' />" readonly=""  class="form-control"
						name="dname">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dbreed</label> <input type="text"
						value="<c:out value='${opportunity.dbreed}' />" readonly=""  class="form-control"
						name="dbreed">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity dage</label> <input type="text"
						value="<c:out value='${opportunity.dage}' />" readonly=""  class="form-control"
						name="dage">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>opportunity additional</label> <input type="text"
						value="<c:out value='${opportunity.additional}' />" readonly=""  class="form-control"
						name="additional">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>Owner name</label> <input type="text"
						value="<c:out value='${opportunity.name}' />" readonly=""  class="form-control"
						name="name">
				</fieldset>
                                                
                                <fieldset class="form-group">
                                        <label>User name</label> <input type="text"
						value="<c:out value='${user.name}' />" readonly=""  class="form-control"
						name="name">
				</fieldset>

				<button type="submit" class="btn btn-success">Apply</button>
				</form>
			</div>
		</div>
	</div>
    </body>
</html>
