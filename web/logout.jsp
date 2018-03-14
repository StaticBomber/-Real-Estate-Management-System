<%-- 
    Document   : logout
    Created on : 8 Mar, 2018, 11:51:04 AM
    Author     : rohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <script type="text/javascript">
              var retVal = confirm("Are you sure ?");
               if( retVal == true ){
                  <%
            session.setAttribute("islogin","0");
            response.sendRedirect("login.jsp");
                    %>
               }
          
      </script>
        
    </body>
</html>
