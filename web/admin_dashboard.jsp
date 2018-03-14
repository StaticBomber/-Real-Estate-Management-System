<%-- 
    Document   : admin_dashboard
    Created on : 25 Feb, 2018, 5:08:57 AM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page import = "mypackage.LoginBackend" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Dashboard</title>

<link rel="stylesheet" href="dashboard_files/css/style.css" type="text/css" media="all" /> 
<link rel="stylesheet" href="dashboard_files/css/font-awesome.css"> 
	<link rel="stylesheet" href="dashboard_files/nav_bar/bootstrap.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="dashboard_files/nav_bar/style.css">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">

</head>
<body>
    <%
    if(session.getAttribute("islogin").toString().equals("0")){response.sendRedirect("login.jsp");}else{ %>
<div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				
				<nav role="navigation">
					<ul>
						<li><a class="active" href="admin_dashboard.jsp">Home</a></li>
						<li><a href="admin_profile.jsp">Profile</a></li>
                                                <li><a href="manage_tenants.jsp">Manage Tenants</a></li>
                                                <li><a href="manage_owners.jsp">Manage Owners</a></li>
						<li><a href="logout.jsp">Logout</a></li>
                                                
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>
        
	<div class="center-container" >
				<br>
		<div class="header-w3l">
                        
			<h1>Hello <%=session.getAttribute("username").toString() %>!</h1>
			<h1>Welcome to the Management Portal!</h1>
		</div>
		

		
	</div>
                        <%}%>
</body>
</html>
