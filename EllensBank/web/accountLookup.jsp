<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #5
    Due: 10/10/17

    Document   : accountLookup
    Created on : Sep 4, 2017, 8:42:37 PM
    Author     : Ellen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Lookup Page</title>
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
            
        </style>
    </head>
    <body>
        <div id="wrapper">
            <form action="http://localhost:8084/EllensBank/AccountLookupServlet"  method="post">
            <h1>Account Lookup</h1>
            <br>
            <span style="padding-left:85px">AcctNo:</span>
            <input type="text" name="acctnotb">
            <br>
            <br>
            <span style="padding-left:55px">CustomerID:</span>
            <input type="text" name="cidtb">
            <br>
            <br>
            <span style="padding-left:43px">Account Type:</span>
            <input type="text" name="typetb">
            <br>   
            <br>
            <span style="padding-left:80px">Balance:</span>
            <span><input type="text" name="baltb"></span>
            <br>
            <br>
            <span><input type="submit" value="Find"></span>
            <span><input type="reset" value="Clear"></span>
            <br>
            </form>
        </div>
    </body>
</html>
