<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #6 
    Due: 10/17/17

    LoginError.jsp - Part IV - Displays the Error Login Page with customer id & name
    
--%>

<%@page import = "business.Customer" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
        <style>
            h1 {
                text-align: center;
                color: goldenrod;
            }
            
            img {
                display: block;
                margin: auto;
            }
            div {
                text-align: center;
                font-size: 20pt;
            }
            .link-btn {
                color: black;
                background: #f9deea;
                padding: 10px 20px;
                text-decoration: none;
                text-transform: uppercase;
            }
        </style>
    </head>
    <body>
        <%
            Customer c2; 
            c2 = (Customer)session.getAttribute("c1"); 
            c2.display(); 
        %>
                
        <h1>Error logging in for User with ID <%=c2.getCustID()%></h1>
        
        <div>
            <img src="images/piggybank.jpg" alt="Piggy Bank"/>
        </div>
        <br>
        <div>
            <h2>Incorrect password for <%=c2.getCustFirstName()%> <%=c2.getCustLastName()%>.</h2>
        </div>    
        <div>
            <a href="login.jsp" class="link-btn">Try Again</a>
        </div>
    </body>
</html>
