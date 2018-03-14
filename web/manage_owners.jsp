

<%@page import="mypackage.owner"%>
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
 
  <title>Manage Owners</title>
  
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
						<li><a href="admin_dashboard.jsp">Home</a></li>
						<li><a href="admin_profile.jsp">Profile</a></li>
                                                <li><a href="manage_tenants.jsp">Manage Tenants</a></li>
                                                <li><a class="active" href="manage_owners.jsp">Manage Owners</a></li>
						<li><a href="logout.jsp">Logout</a></li>
                                                
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>

    <% DatabaseConnection db = new DatabaseConnection();
        ArrayList<owner> list = db.get_owner_list();%>
    <%! int i;%>
    <% System.out.println(list.size());%>-
  <h1>List of Owners</h1>
  <form method="POST" action="manage_owners">
     
<table class="responstable">
  
  <tr>
    <th>Username</th>
    <th>Email</th>
    <th>Name</th>
    <th>Address</th>
    <th>Phone</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>Pincode</th>
    <th>Action</th>
    
  </tr>
  <% for(i=0;i<list.size();i++){%>
  <tr>
      <td><%=list.get(i).getusername()%></td>
      <td><%=list.get(i).getemail()%></td>
      <td><%=list.get(i).getname()%></td>
      <td><%=list.get(i).getaddress()%></td>
      <td><%=list.get(i).getphone()%></td>
      <td><%=list.get(i).getcity()%></td>
      <td><%=list.get(i).getstate()%></td>
      <td><%=list.get(i).getcountry()%></td>
      <td><%=list.get(i).getpincode()%></td>
      <td><input type="checkbox" name="group" value="<%=i%>"></td>
      
  </tr>
  <%}%>
  
 
  
</table>
  <button  type="submit" >Delete </button>
  </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
<%}%>
</body>

</html>


