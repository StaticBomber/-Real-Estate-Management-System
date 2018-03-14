<%-- 
    Document   : tenant_profile.jsp
    Created on : 25 Feb, 2018, 5:11:14 AM
    Author     : rohan
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page import = "mypackage.LoginBackend,mypackage.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact V15</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="profile_update/images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="profile_update/vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="profile_update/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="profile_update/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="profile_update/css/util.css">
	<link rel="stylesheet" type="text/css" href="profile_update/css/main.css">
		<link rel="stylesheet" href="dashboard_files/nav_bar/bootstrap.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="dashboard_files/nav_bar/style.css">

</head>
<body>
  <%
    if(session.getAttribute("islogin").toString().equals("0")){response.sendRedirect("login.jsp");}else{ %>  
<%! String email,password,name,address,phone,city,state,country,pincode;%>
 <%
     
      DatabaseConnection db = new DatabaseConnection();
      Connection con = db.getCon();
      String sql="SELECT * FROM owner_data";
      Statement stmt = (Statement) con.createStatement();
      ResultSet rs=stmt.executeQuery(sql);
      while(rs.next())
                    {
        
       if(rs.getString(1).equals(session.getAttribute("username").toString()))
       {          
      
            email = rs.getString(2);
            password =rs.getString(3);
            name = rs.getString(4);
            address = rs.getString(5);
            phone = rs.getString(6);
            city = rs.getString(7);
            state = rs.getString(8);
            country = rs.getString(9);
            pincode = rs.getString(10);

             
        }
     }
 %> 
<div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				
				<nav role="navigation">
					<ul>
						<li><a  href="owner_dashboard.jsp">Home</a></li>
						<li><a class="active" href="owner_profile.jsp">Profile</a></li>
						<li><a href="bookings.jsp" >Bookings</a></li>
                                                <li><a href="addproperty.jsp" >Upload New Property</a></li>
                                                <li><a href="manage_properties.jsp" >Manage Property</a></li>
                                                <li><a href="logout.jsp" >Logout</a></li>
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>
	<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>

		<div class="wrap-contact100">
			<div class="contact100-form-title" style="background-image: url(profile_update/images/bg-01.jpg);">
				<span class="contact100-form-title-1">
					Your Profile
				</span>

				<span class="contact100-form-title-2">
					Update your profile with all details!
				</span>
			</div>

			<form class="contact100-form validate-form" action="update_owner_profile">
				<div class="wrap-input100 validate-input" >
					<span class="label-input100"><b>Full Name:</b></span>
					<input class="input100" type="text" name="name" placeholder="Enter full name" value="<%=name%>">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" >
					<span class="label-input100"><b>Email:</b></span>
                                        <input class="input100" type="text" name="email" placeholder="Enter email addess" value="<%=email%>">
					<span class="focus-input100"></span>
				</div>
                                <div class="wrap-input100 validate-input" >
					<span class="label-input100"><b>Password:</b></span>
                                        <input class="input100" type="password" name="password" placeholder="Enter password" value="<%=password%>">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input">
					<span class="label-input100"><b>Phone:</b></span>
					<input class="input100" type="text" name="phone" placeholder="Enter phone number" value="<%=phone%>">
					<span class="focus-input100"></span>
				</div>
                                <div class="wrap-input100 validate-input">
					<span class="label-input100"><b>Address:</b></span>
					<input class="input100" type="text" name="address" placeholder="Enter your residential address" value="<%=address%>">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" >
					<span class="label-input100"><b>City:</b></span>
					<input class="input100" type="text" name="city" placeholder="Enter your residential city" value="<%=city%>">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input">
					<span class="label-input100"><b>State:</b></span>
					<input class="input100" type="text" name="state" placeholder="Enter your residential state" value="<%=state%>">
					<span class="focus-input100"></span>
				</div>
                                <div class="wrap-input100 validate-input">
					<span class="label-input100"><b>Country:</b></span>
					<input class="input100" type="text" name="country" placeholder="Enter your residential Country" value="<%=country%>">
					<span class="focus-input100"></span>
				</div>
                                <div class="wrap-input100 validate-input">
					<span class="label-input100"><b>Pincode:</b></span>
					<input class="input100" type="text" name="pincode" placeholder="Enter your pincode" value="<%=pincode%>">
					<span class="focus-input100"></span>
				</div>
				

				<div class="container-contact100-form-btn">
                                    <button class="contact100-form-btn" type="submit">
						<span>
							Update Details
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>


	<script src="profile_update/vendor/jquery/jquery-3.2.1.min.js"></script>

	<script src="profile_update/vendor/animsition/js/animsition.min.js"></script>

	<script src="profile_update/vendor/bootstrap/js/popper.js"></script>
	<script src="profile_update/vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="profile_update/vendor/select2/select2.min.js"></script>

	<script src="profile_update/vendor/daterangepicker/moment.min.js"></script>
	<script src="profile_update/vendor/daterangepicker/daterangepicker.js"></script>

	<script src="profile_update/vendor/countdowntime/countdowntime.js"></script>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="profile_update/js/map-custom.js"></script>

	<script src="profile_update/js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
<%}%>
</body>
</html>
