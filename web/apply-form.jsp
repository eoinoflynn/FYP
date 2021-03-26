<%-- 
    Document   : signup
    Created on : 21-Feb-2021, 18:59:33
    Author     : eoinp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<!-- Code taken and adapted from Retrieve data from database in jsp "https://www.roseindia.net/jsp/how-to-retrieve-data-from-database-in-jsp.shtml" -->
<!-- Reading from the MySQL database - showing all opportunities created  -->

<html  >
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<head>
  <!-- Site made with Mobirise Website Builder v5.2.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.2.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="../assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Create</title>
  <link rel="stylesheet" href="../assets/tether/tether.min.css">
  <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="../assets/dropdown/css/style.css">
  <link rel="stylesheet" href="../assets/formstyler/jquery.formstyler.css">
  <link rel="stylesheet" href="../assets/formstyler/jquery.formstyler.theme.css">
  <link rel="stylesheet" href="../assets/datepicker/jquery.datetimepicker.min.css">
  <link rel="stylesheet" href="../assets/socicon/css/styles.css">
  <link rel="stylesheet" href="../assets/theme/css/style.css">
  <link rel="preload" as="style" href="../assets/mobirise/css/mbr-additional.css">
  <link rel="stylesheet" href="../assets/mobirise/css/mbr-additional.css" type="text/css">
  
  <!-- Links for bootstrap table format -->
     <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
   <!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
    <!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
    <link href="../css/shop-homepage.css" rel="stylesheet"> -->
    
    <!-- search-->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  
</head>
<body>
  
  <section class="menu menu2 cid-snY7U20ZfF" once="menu" id="menu2-i">
    
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href="../homepage2.jsp">
                        <img src="../images/dogicon2.png" alt="Mobirise" style="height: 3rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black text-primary display-7" href="../homepage2.jsp" style="font-size: 20px;">DogTime</a></span>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="../homepage2.jsp" style="font-size: 18px;">
                            Services</a></li><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="../homepage2.jsp" style="font-size: 18px;" >
                            About us</a></li>
                    
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="../homepage2.jsp" style="font-size: 18px;" >Contact us</a>
                    </li></ul>
                
                <div class="navbar-buttons mbr-section-btn"><a class="btn btn-primary display-4" href="../LogoutUser" style="font-size: 18px;">Log-out</a></div>
            </div>
        </div>
    </nav>
</section>

<section class="form6 cid-so9ZTnVkON" id="form6-k">
    
    <div class="mbr-overlay"></div>
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Review details and Apply</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form"> 

<form action="../application" method="post" class="mbr-form form-with-styler mx-auto">

				<div class="dragArea row"> 
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="activity">
                             <input <input type="text"
						value="<c:out value='${opportunity.activity}' />"
                                                class="form-control" name="activity" required="required" id="name-form6-k" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="location">
                            <input type="text"
						value="<c:out value='${opportunity.location}' />" class="form-control"
						name="location" id="email-form6-k" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="payment">
                            <input type="text"
						value="<c:out value='${opportunity.payment}' />" class="form-control"
						name="payment" id="email-form6-k" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="sdate">
                            <input type="text"
						value="<c:out value='${opportunity.sdate}' />" class="form-control"
						name="sdate" id="email-form6-k" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="edate">
                            <input type="text"
						value="<c:out value='${opportunity.edate}' />" class="form-control"
						name="edate" id="email-form6-k" readonly>
                        </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="length">
                             <input type="text"
						value="<c:out value='${opportunity.length}' />" class="form-control"
						name="length" readonly>
                        </div>
                          <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="dname">
                             <input type="text"
						value="<c:out value='${opportunity.dname}' />" class="form-control"
						name="dname" readonly>
                        </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="dbreed">
                             <input type="text"
						value="<c:out value='${opportunity.dbreed}' />" class="form-control"
						name="dbreed" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="dage">
                            <input type="text"
						value="<c:out value='${opportunity.dage}' />" class="form-control"
						name="dage" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="additional">
                            <input type="text"
						value="<c:out value='${opportunity.additional}' />" class="form-control"
						name="additional" id="email-form6-k" readonly>
                        </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="name" readonly>
                           <input type="text"
						value="<c:out value='${opportunity.name}' />" class="form-control"
						name="name" id="email-form6-k" readonly>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="userName">
                           <input type="hidden"
						value="<c:out value='${user.name}' />" class="form-control"
						name="userName" id="email-form6-k" readonly>
                        </div>           
                        
                        
                        <div class="col-auto mbr-section-btn align-center"><button type="submit" class="btn btn-primary display-4">Apply</button></div>
				</form>
			</div>
		</div>
	</div>
                                                                               <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>&nbsp;</strong></h3>

</section>

<section class="footer3 cid-snYuw7jeYm" once="footers" id="footer3-j">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-links">
                <ul class="foot-menu">
                    
                    
                    
                    
                    
                <li class="foot-menu-item mbr-fonts-style display-7"><a href="../homepage2.jsp" class="text-white" style="font-size: 18px;">Services</a></li><li class="foot-menu-item mbr-fonts-style display-7"><a href="../homepage2.jsp" class="text-white" style="font-size: 18px;">About us</a></li><li class="foot-menu-item mbr-fonts-style display-7"><a href="../homepage2.jsp" class="text-white" style="font-size: 18px;">Contact us</a></li></ul>
            </div>
            <div class="row social-row">
                <div class="social-list align-right pb-2">
                    
                    
                    
                    
                    
                    
                <div class="soc-item">
                        <a href="https://twitter.com/" target="_blank">
                            <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social" style="font-size: 23px;"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.facebook.com/" target="_blank">
                            <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social" style="font-size: 23px;"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.youtube.com/" target="_blank">
                            <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social" style="font-size: 23px;"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://instagram.com/" target="_blank">
                            <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social" style="font-size: 23px;"></span>
                        </a>
                    </div></div>
            </div>
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7" style="font-size: 18px;">DogTime&nbsp;</p>
            </div>
        </div>
    </div>
</section><section style="background-color: #fff; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;"><a href="https://mobirise.site/n" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a><p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Made with Mobirise - <a href="https://mobirise.site/l" style="color:#aaa;">Find out</a></p></section><script src="../assets/web/assets/jquery/jquery.min.js"></script>  <script src="../assets/popper/popper.min.js"></script>  <script src="../assets/tether/tether.min.js"></script>  <script src="../assets/bootstrap/js/bootstrap.min.js"></script>  
<script src="../assets/smoothscroll/smooth-scroll.js"></script>  
<script src="../assets/dropdown/js/nav-dropdown.js"></script>  
<script src="../assets/dropdown/js/navbar-dropdown.js"></script>  
<script src="../assets/touchswipe/jquery.touch-swipe.min.js"></script>  
<script src="../assets/formstyler/jquery.formstyler.js"></script>  
<script src="../assets/formstyler/jquery.formstyler.min.js"></script>  
<script src="../assets/datepicker/jquery.datetimepicker.full.js"></script>  
<script src="../assets/theme/js/script.js"></script>  
<script src="../assets/formoid/formoid.min.js"></script>  
  
  
</body>
</html>
