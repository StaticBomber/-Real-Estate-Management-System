
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
						<li><a  href="owner_dashboard.jsp">Home</a></li>
						<li><a href="owner_profile.jsp">Profile</a></li>
						<li><a class="active" href="bookings.jsp" >Bookings</a></li>
                                                <li><a href="addproperty.jsp" >Upload New Property</a></li>
                                                <li><a href="manage_properties.jsp" >Manage Property</a></li>
                                                <li><a href="logout.jsp" >Logout</a></li>
	
					</ul>
				</nav>
			</div>
		</div>
	</header>
	</div>

<% DatabaseConnection db = new DatabaseConnection();%>

 <%! int i;%>
 <% ArrayList<property>list2 = db.get_property_list();%>
  <%   ArrayList<booking> list1 = db.get_booking_list(); %>
  <% ArrayList<booking> list = new ArrayList<booking>();%>
  <% ArrayList<tenant> tenant_list = db.get_tenant_list();%>
<% String username = session.getAttribute("username").toString(); %>
<% 
    for(int k=0;k<list1.size();k++)
    {
        if(list1.get(k).getownerusername().equals(username))
        {
            booking l = new booking(list1.get(k).getownerusername(),list1.get(k).gettenantusername(),list1.get(k).getbookingid(),list1.get(k).getpropertyid(),list1.get(k).getstatus());
            list.add(l);
        }
    }

 %>
<h1>List of Bookings</h1>
  <form method="POST" action="#">
     
<table class="responstable">
  
  <tr>
    <th>Tenant Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Phone</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>Pincode</th>
    <th>Property Booked</th>
    <th>Booking Id</th>
    
  </tr>
  <% for(i=0;i<list.size();i++) {%>

<tr>
    <%! String name,email,address,phone,city,state,country,pincode,propertyname,displaystatus; %>
   
    <%
        for(int d=0;d<tenant_list.size();d++)
        {
            if(tenant_list.get(d).getusername().equals(list.get(i).gettenantusername()))
       
            {
                name = tenant_list.get(d).getname();
                email = tenant_list.get(d).getemail();
                address = tenant_list.get(d).getaddress();
                phone = tenant_list.get(d).getphone();
                city =tenant_list.get(d).getcity();
                state = tenant_list.get(d).getstate();
                country = tenant_list.get(d).getcountry();
                pincode = tenant_list.get(d).getpincode();
                break;
            }
            
        } 
        
        for(int j=0;j<list2.size();j++)
        {
            if(list2.get(j).getpropertyid()==list.get(i).getpropertyid())
            {
                propertyname = list2.get(j).getname();
                break;
            }
        }

%>
    <td><%= name %></td>
    <td><%= email %></td>
    <td><%= address %></td>
    <td><%= phone %></td>
    <td><%= city %></td>
    <td><%= state %></td>
    <td><%= country %></td>
    <td><%= pincode %></td>
    <td><%= propertyname %></td>
    <td><%= list.get(i).getbookingid() %></td>
    
</tr>
  
 <%}%>
  
</table>
  </form>
     
  
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
<%}%>
</body>

</html>

