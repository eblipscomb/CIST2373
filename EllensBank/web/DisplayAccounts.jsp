<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #7
    Due: 10/24/17

    DisplayAccounts.jsp - Part B - Displays the accounts for a customer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "business.Account" %>
<%@page import = "business.Customer" %>
<%@page import = "business.AccountList" %>
<%@page import = "java.text.NumberFormat" %>
<%@page import = "java.util.Locale" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Accounts</title>
        <style>   
            img {
                display: block;
                margin: auto;
            }
            #wrapper {
                width:400px;
                margin:0px auto;
		border:1px solid #bbb;
		padding:10px;
                background-color: #f9deea
            }             
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;                
            }
            th, td {
                padding: 8px;
            }
            th {
                background-color: #f79bc1;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #fcf2f6;
            }
        </style>
    </head>
    <body>
        <% 
            Customer c2; 
            c2 = (Customer)session.getAttribute("c1"); 
            c2.display();    

            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);            
        %>
        <div>
            <img src="images/piggybankSmall.jpg" alt="Piggy Bank"/>
        </div>
        <div id="wrapper">
            <div style="text-align: right">Customer ID: <%=c2.getCustID()%></div>
            <br>
            <h3 style="text-align: center">Welcome <%=c2.getCustFirstName()%> <%=c2.getCustLastName()%>!</h3>
            <br>            
            <div style="text-align: center">You have <%=c2.cList.getCount()%> account(s) with Ellen's Bank:</div>
            <table style="margin: auto">                
                <tr>
                    <th>ACCOUNT</th>
                    <th>TYPE</th>
                    <th>BALANCE</th>
                </tr>
            <%
              c2.cList.displayAccount(); //testing
              for (int i =0; i < c2.cList.getCount(); i++) { %>
              <% String balance = format.format(c2.cList.aList[i].getBalance()); %>
              <tr>
                  <td><%=c2.cList.aList[i].getAcctNo() %></td>                  
                  <td><%=c2.cList.aList[i].getType() %></td>
                  <td> <%=balance %></td>
              </tr>
              <br>
            <%}%>  
            </table>
            <br>                
        </div>    
    </body>
</html>
  