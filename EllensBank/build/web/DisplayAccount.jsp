<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #6
    Due: 10/17/17

    DisplayAccount.jsp - Part V - Displays the account lookup info
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "business.Account" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Account</title>
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
        <% 
            Account a3;
            a3 = (Account)session.getAttribute("a1");
            a3.display();    
        %>
        <div id="wrapper">            
            <h1>Account Information</h1>
            <br>
            <span style="padding-left:85px">AcctNo:</span>
            <input type="text" name="acctnotb" value="<%=a3.getAcctNo()%>">
            <br>
            <br>
            <span style="padding-left:55px">CustomerID:</span>
            <input type="text" name="cidtb" value="<%=a3.getCID()%>">
            <br>
            <br>
            <span style="padding-left:43px">Account Type:</span>
            <input type="text" name="typetb" value="<%=a3.getBalance()%>">
            <br>   
            <br>
            <span style="padding-left:80px">Balance:</span>
            <span><input type="text" name="baltb" value="<%=a3.getBalance() + ""%>"></span>
            <br>
            <br>                
        </div>    
    </body>
</html>
