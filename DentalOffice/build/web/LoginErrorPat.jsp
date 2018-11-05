<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Patient Login Error Page
--%>

<%@ page import = "business.Patient" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%
            Patient p2; 
            p2 = (Patient)session.getAttribute("p1"); 
            p2.display(); 
        %>
        <h1>Bright Smiles Dental</h1>
        <div id="login-box">        
            <h2>Error logging in for User with ID <%=p2.getPatId()%></h2>        
            <br>
            <div>
                <h3>Incorrect password for <%=p2.getPatFirstName()%> <%=p2.getPatLastName()%>.</h3>
            </div>    
            <div>
                <a href="PatientLogin.jsp" class="link-btn">Try Again</a>
            </div>
        </div>
    </body>
</html>
