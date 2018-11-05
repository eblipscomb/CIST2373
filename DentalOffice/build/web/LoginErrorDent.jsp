<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Dentist Login Error Page
--%>

<%@ page import = "business.Dentist" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Login Error Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%
            Dentist d2; 
            d2 = (Dentist)session.getAttribute("d1"); 
            d2.display(); 
        %>
                
        <h1>Bright Smiles Dental</h1>
        <div id="login-box">
            <h2>Error logging in for User with ID <%=d2.getDentId()%></h2>       
            <br>
            <div>
                <h3>Incorrect password for <%=d2.getDentFirstName()%> <%=d2.getDentLastName()%>.</h3>
            </div>    
            <div>
                <a href="DentistLogin.jsp" class="link-btn">Try Again</a>
            </div>
        </div>    
    </body>
</html>
