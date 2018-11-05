<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #5 
    Due: 10/10/17

    Document   : index
    Created on : Aug 29, 2017, 2:24:12 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h1>Ellen's Bank!</h1>
        <div>
            <img src="images/piggybank.jpg" alt="Piggy Bank"/>
        </dv>
        <br>
        <div>
        <a href="login.jsp" class="link-btn">Login</a>
        </div>
    </body>
</html>
