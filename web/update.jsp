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
    <head>
  <!-- Site made with Mobirise Website Builder v5.2.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.2.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Create</title>
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.css">
  <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.theme.css">
  <link rel="stylesheet" href="assets/datepicker/jquery.datetimepicker.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

</head>
<body>
 <section class="menu menu2 cid-snY7U20ZfF" once="menu" id="menu2-i">
    
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href="https://mobiri.se">
                        <img src="assets/images/logo.png" alt="Mobirise" style="height: 3rem;">
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black text-primary display-7" href="./homepage2.jsp">DogTime</a></span>
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
                <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="index.html#features4-5">
                            Services</a></li><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="index.html#image1-6">
                            About us</a></li>
                    
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="index.html#contacts1-7">Contact us</a>
                    </li></ul>
                
                <div class="navbar-buttons mbr-section-btn"><a class="btn btn-primary display-4" href="create.jsp">Login</a></div>
            </div>
        </div>
    </nav>
</section>

<section class="form6 cid-so9ZTnVkON" id="form6-k">
    
    <div class="mbr-overlay"></div>
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Edit Opportunity</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form">
                 <form method="post" action="update-process.jsp" class="mbr-form form-with-styler mx-auto"> <!-- data-form-title="Form Name", was inside tag to left -->
                 <input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
                    
                 <div class="dragArea row"> 
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="id">
                             <input class="form-control" id="name-form6-k" type="text" name="id" value="<%=resultSet.getString("id") %>" readonly="">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="activity">
                             <input class="form-control" id="name-form6-k" type="text" name="activity" value="<%=resultSet.getString("activity") %>">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="location">
                            <input class="form-control" id="email-form6-k" type="text" name="location" value="<%=resultSet.getString("location") %>" >
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="payment">
                            <input class="form-control" id="email-form6-k" type="text" name="payment" value="<%=resultSet.getString("payment") %>">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="sdate">
                            <input class="form-control" id="email-form6-k" type="text" name="sdate" value="<%=resultSet.getString("sdate") %>">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="edate">
                            <input class="form-control" id="email-form6-k" type="text" name="edate" value="<%=resultSet.getString("edate") %>">
                        </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="length">
                             <input class="form-control" id="email-form6-k" data-for="length" type="text" name="length" value="<%=resultSet.getString("length") %>">
                        </div>
                          <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="dname">
                              <input class="form-control" id="email-form6-k" type="text" name="dname" value="<%=resultSet.getString("dname") %>">
                        </div>
                         <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="dbreed">
                             <input class="form-control" id="email-form6-k" type="text" name="dbreed" value="<%=resultSet.getString("dbreed") %>">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group">
                            <input class="form-control" id="email-form6-k" data-for="dage" type="text" name="dage" value="<%=resultSet.getString("dage") %>">
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group" data-for="additional">
                            <input class="form-control" id="email-form6-k" type="text" name="additional" value="<%=resultSet.getString("additional") %>">
                        </div>
                        
                        
                        <div class="col-auto mbr-section-btn align-center"><button type="submit" class="btn btn-primary display-4">Edit Opportunity</button></div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</section>

<section class="footer3 cid-snYuw7jeYm" once="footers" id="footer3-j">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-links">
                <ul class="foot-menu">
                    
                    
                    
                    
                    
                <li class="foot-menu-item mbr-fonts-style display-7"><a href="index.html#features4-5" class="text-white">Services</a></li><li class="foot-menu-item mbr-fonts-style display-7"><a href="index.html#image1-6" class="text-white">About us</a></li><li class="foot-menu-item mbr-fonts-style display-7"><a href="index.html#contacts1-7" class="text-white">Contact us</a></li></ul>
            </div>
            <div class="row social-row">
                <div class="social-list align-right pb-2">
                    
                    
                    
                    
                    
                    
                <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.facebook.com/pages/Mobirise/1616226671953247" target="_blank">
                            <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://www.youtube.com/c/mobirise" target="_blank">
                            <span class="socicon-youtube socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div><div class="soc-item">
                        <a href="https://instagram.com/mobirise" target="_blank">
                            <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social"></span>
                        </a>
                    </div></div>
            </div>
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">DogTime&nbsp;</p>
            </div>
        </div>
    </div>
</section><section style="background-color: #fff; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;"><a href="https://mobirise.site/n" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a><p style="flex: 0 0 auto; margin:0; padding-right:1rem;">Made with Mobirise - <a href="https://mobirise.site/l" style="color:#aaa;">Find out</a></p></section><script src="assets/web/assets/jquery/jquery.min.js"></script>  <script src="assets/popper/popper.min.js"></script>  <script src="assets/tether/tether.min.js"></script>  <script src="assets/bootstrap/js/bootstrap.min.js"></script>  <script src="assets/smoothscroll/smooth-scroll.js"></script>  <script src="assets/dropdown/js/nav-dropdown.js"></script>  <script src="assets/dropdown/js/navbar-dropdown.js"></script>  <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>  <script src="assets/formstyler/jquery.formstyler.js"></script>  <script src="assets/formstyler/jquery.formstyler.min.js"></script>  <script src="assets/datepicker/jquery.datetimepicker.full.js"></script>  <script src="assets/theme/js/script.js"></script>  <script src="assets/formoid/formoid.min.js"></script>    
    
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
