<%@page import="mypackage.search_results"%>
<%@page import="mypackage.property"%>
<%@page import="java.util.ArrayList"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Property Search</title>

<script src="search_results/js/jquery-2.1.3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="search_results/js/sliding.form.js"></script>
<!-- //js -->
<link href="search_results/css/style.css" rel="stylesheet" type="text/css" media="all" >
<link rel="stylesheet" href="search_results/css/font-awesome.min.css" >
<link rel="stylesheet" href="search_results/css/smoothbox.css" type='text/css' media="all" >

<link href="//fonts.googleapis.com/css?family=Pathway+Gothic+One" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head> 
    <%
    if(session.getAttribute("islogin").toString().equals("0")){response.sendRedirect("login.jsp");}else{ %>
	<div class="main">
		<h1 style="color:black;">Search Results</h1>
                <form action="search_results" name="sort" method="post">
                    <button type="submit" name="order" value="2" style="margin: 2px;padding: 2px;">Sort in ascending order of price</button>
                   
                    <button type="submit" name="order" value="3" style="margin: 2px;padding: 2px;">Sort in descending order of price</button><br><br>
                
                </form>
                <a href="tenant_dashboard.jsp" style="font-size: 25px">Return Home </a>
		<% ArrayList<property> search_list = search_results. search_list;%>
                <%! int i; %>
		<div id="wrapper">
                    <% for(i=0;i<search_list.size();i++){%>
			<div id="steps" style="margin:0 auto;" >
				<form id="formElem" name="formElem" action="make_booking" method="post" class="w3_form w3l_form_fancy">
					<fieldset class="step agileinfo w3ls_fancy_step">
						
						<div class="abt-agile">
							<div class="abt-agile-left">
							</div>
							<div class="abt-agile-right">
                                                            <% System.out.println( search_list.get(i).getpropertyid());%>
                                                            <h3>Name : <%= search_list.get(i).getname()%></h3>
								<h5>Type: <%= search_list.get(i).gettype()%></h5>
								<ul class="address">
									<li>
										<ul class="address-text">
											<li><b>Address  </b></li>
											<li>: <%= search_list.get(i).getaddress()%></li>
										</ul>
									</li>
									<li>
										<ul class="address-text">
											<li><b>City </b></li>
											<li>: <%= search_list.get(i).getcity()%></li>
										</ul>
									</li>
									<li>
										<ul class="address-text">
											<li><b>State </b></li>
											<li>: <%= search_list.get(i).getstate()%></li>
										</ul>
									</li>
									<li>
										<ul class="address-text">
											<li><b>Country </b></li>
											<li>: <%= search_list.get(i).getcountry()%></li>
										</ul>
									</li>
									<li>
										<ul class="address-text">
											<li><b>Pincode</b></li>
											<li>: <%= search_list.get(i).getpincode()%></li>
										</ul>
									</li>
                                                                        <li>
										<ul class="address-text">
											<li><b>Owner Name</b></li>
											<li>: <%= search_list.get(i).getowner()%></li>
										</ul>
									</li>
                                                                        <li>
										<ul class="address-text">
											<li><b>Rating</b></li>
											<li>: <%= search_list.get(i).getrating()%></li>
										</ul>
									</li>
                                                                        <li>
										<ul class="address-text">
											<li><b>Contact</b></li>
											<li>: <%= search_list.get(i).getcontact()%></li>
										</ul>
									</li>
                                                                        <li>
										<ul class="address-text">
											<li><b>Price</b></li>
											<li>: <%= search_list.get(i).getprice()%></li>
										</ul>
									</li>
                                                                        <%! String location;%>
                                                                        <% location = search_list.get(i).getcity()+","+search_list.get(i).getstate();%>
                                                                </ul><br>
                                                                <button type="submit" name="property_book" value="<%= search_list.get(i).getpropertyid()%>">Book</button>
                                                                <button type="submit" name="locate" value="<%= location%>" onclick="form.action='locate_on_map.jsp';">Locate on Map</button>
							</div>
								<div class="clear"></div>
						</div>
					</fieldset>
					
				</form>
			</div>
                                                                                <br><br>
                      <%}%>
		
		
	</div>
	<script type="text/javascript" src="search_results/js/smoothbox.jquery2.js"></script>
        <%}%>
</body>
</html>