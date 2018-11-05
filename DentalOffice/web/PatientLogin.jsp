<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Patient Login Page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Login Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Bright Smiles Dental</h1>        
        <br>
        <div id="login-box">
            <h2>Patient Login</h2>
            <p>Login below to access your personal information and appointments. You will be 
                able to view/change your name and address information and view/schedule/change 
                your appointment.
            </p>
            <form action="http://localhost:8084/DentalOffice/LoginServlet"  method="post">   
            <input type="hidden" name="logintype" value="pat">    
            <p>
            <div>
                <span>Patient ID:</span>
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
                <input type="button" value="Back" onclick="history.back()">  
            </p>
        </form>
        </div>
    </body>
</html>
