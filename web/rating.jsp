
<%@page import="mypackage.rating"%>
<%@page import="mypackage.owner"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="mypackage.LoginBackend"%>
<%@page import="mypackage.property"%>
<%@page import="mypackage.property"%>
<%@page import="mypackage.booking"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypackage.tenant"%>
<%@page import="mypackage.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=index.jsp" />
 
  <title>Bookings</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="dashboard_files/nav_bar/bootstrap.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="dashboard_files/nav_bar/style.css">
  
      <link rel="stylesheet" href="manage_tenants/css/style.css">

  
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
						<li><a  href="tenant_dashboard.jsp">Home</a></li>
						<li><a href="tenant_profile.jsp">Profile</a></li>
						<li><a  href="tenant_bookings.jsp" >Bookings</a></li>
                                                <li><a class="active"  href="rating.jsp">Rate</a></li>
                                                <li><a href="logout.jsp" >Logout</a></li>
                                                
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>

<% DatabaseConnection db = new DatabaseConnection();%>

 <%! int i;%>
 <% ArrayList<booking>booking_list = db.get_booking_list();%>
<% String username = session.getAttribute("username").toString(); %>
<h1>List of Bookings</h1>
  <form method="POST" action="updaterating">
     
<table class="responstable">
  
  <tr>
    <th>Property Id</th>
    <th>Booking Id</th>
    <th>Rate</th>
    <th>Action</th>
  </tr>
  <% for(i=0;i<booking_list.size();i++) {%>
  <% if(booking_list.get(i).gettenantusername().equals(username)&&booking_list.get(i).getstatus()==0){%>

<tr>
    
    <td><%= booking_list.get(i).getpropertyid() %></td>
    <td><%= booking_list.get(i).getbookingid() %></td>
    <td><input type="radio" value="1" style="margin:5px;" name="rating">1<input type="radio" value="2"  style="margin:5px;" name="rating">2<input type="radio" value="3" style="margin:5px;" name="rating">3<input type="radio" value="4" style="margin:5px;" name="rating">4<input type="radio" value="5" style="margin:5px;" name="rating">5</td>
    <td><button value="<%=booking_list.get(i).getbookingid()%>" name="bookingid">Submit</button></td>
    
</tr>
  
 <%}}%>
  
</table>
  </form>
     
  
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
<%}%>
</body>

</html>

