<%-- 
    Document   : manage_properties
    Created on : 6 Mar, 2018, 12:37:27 AM
    Author     : rohan
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="mypackage.LoginBackend"%>
<%@page import="mypackage.property"%>
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
 
  <title>List of Properties</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="dashboard_files/nav_bar/bootstrap.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="dashboard_files/nav_bar/style.css">
  
      <link rel="stylesheet" href="manage_tenants/css/style.css">
<link rel="stylesheet" href="dashboard_files/nav_bar/bootstrap.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="dashboard_files/nav_bar/style.css">
  
</head>

<body>
    

    <div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				
				<nav role="navigation">
					<ul>
						<li><a href="owner_dashboard.jsp">Home</a></li>
						<li><a href="owner_profile.jsp">Profile</a></li>
						<li><a href="bookings.jsp" >Bookings</a></li>
                                                <li><a href="addproperty.jsp" >Upload New Property</a></li>
                                                <li><a class="active" href="manage_properties.jsp" >Manage Property</a></li>
                                                <li><a href="logout.jsp" >Logout</a></li>
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>

    <% DatabaseConnection db = new DatabaseConnection();
        ArrayList<property> list = db.get_property_list();%>
    <%! int i;%>
    <%! String un;%>
    <% un=LoginBackend.username;%>
    <%System.out.println(un+list.size());%>
    
  <h1>List of Your Properties</h1>
  <form method="POST" action="manage_properties">
     
<table class="responstable">
  
  <tr>
    <th>Name</th>
    <th>Address</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>Pincode</th>
    <th>Type</th>
    <th>Rating</th>
    <th>Owner</th>
    <th>Contact</th>
    <th>Image</th>
    <th>Action</th>
    
  </tr>
  <% for(i=0;i<list.size();i++){%>
  <% if(list.get(i).getownerusername().equals(un)){
      %>
  <tr>
      <td><%=list.get(i).getname()%></td>
      <td><%=list.get(i).getaddress()%></td>
      <td><%=list.get(i).getcity()%></td>
      <td><%=list.get(i).getstate()%></td>
      <td><%=list.get(i).getcountry()%></td>
      <td><%=list.get(i).getpincode()%></td>
      <td><%=list.get(i).gettype()%></td>
      <td><%=list.get(i).getrating()%></td>
      <td><%=list.get(i).getowner()%></td>
      <td><%=list.get(i).getcontact()%></td>
      
      <td><img src="#" style="width:100px;height:100px;">
      <td><input type="checkbox" name="group" value="<%=list.get(i).getpropertyid()%>"></td>
      
  </tr><%}%>
  <%}%>
  
 
  
</table>
  <button  type="submit" >Delete </button>
  </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  

</body>

</html>


