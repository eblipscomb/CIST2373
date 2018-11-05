<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #5
    Due: 10/10/17

    Document   : login
    Created on : Aug 31, 2017, 8:19:46 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                text-align: center;               
            }
            #wrapper {
                width:400px;
                margin:0px auto;
		border:1px solid #bbb;
		padding:10px;
                background-color: #f9deea
            }
            #add-padding-left {
                padding-left:14px;
            }
        </style>
    </head>
    <body>
        <img src="images/piggybank3.jpg" alt="login">
        <br>
        <div id="wrapper">
            <form action="http://localhost:8084/ChattBank/TestLoginServlet"  method="post"> 
            <!--<form action="http://localhost:8084/ChattBank/MyServlet"  method="post"> -->
            <p>
            <div>
                <span>Customer ID:</span>
                <input type ="text" name="idtb">
            </div>
            <br>
            <div>
                <span id="add-padding-left">Password:</span>
                <input type="password" name="pwtb">
            </div>
            </p>
            <p>
                <input type="submit" name="login" value="Login">
                <input type="reset" name="reset" value="Clear">
            </p>
        </form>
        </div> 
    </body>
</html>
