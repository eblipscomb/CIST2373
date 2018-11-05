<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Dentist Menu  Page
--%>

<%@page import="business.Dentist" %>
<%@page import="business.AppointmentList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Activity Page</title>
        <link rel="stylesheet" href="styles.css">   
        <style>
            th {
                padding-right: 20px;
            }
            td {
                font-size: small;
            }
            tr:nth-child(odd) {
                background-color: #dcf4ea;
            }
            tr:nth-child(even) {
                background-color: #aae2ca;
            }
        </style>
    </head>
    <body>
        <%
            Dentist d2; 
            d2 = (Dentist)session.getAttribute("d1");    

        %>        
        <div>
            <img src="images/smilingCouplePatPage1.jpg" alt="Smiling Couple for Patient Page"/>
            <div id="wrapper">
                <div id="green-bar">Welcome <%=d2.getDentFirstName()%> <%=d2.getDentLastName()%></div>     
                <div>                    
                    <h4>View/Update your Personal Information below:</h4>
                    <form action="http://localhost:8084/DentalOffice/UpdateInfoServlet"  method="post">   
                        <input type="hidden" name="logintype" value="dent">    
                        <span>First Name:</span>
                        <input type="text" name="fntb" value="<%=d2.getDentFirstName()%>">
                        <br>    
                        <span>Last Name:</span>
                        <input type="text" name="lntb" value="<%=d2.getDentLastName()%>">
                        <br>
                                                      
                        <span style="padding-left:50px">Email:</span>
                        <input type="text" name="emailtb" value="<%=d2.getDentEmail()%>">
                        <br>
                        <span style="padding-left:47px">Office:</span>
                        <input type="text" name="officetb" value="<%=d2.getDentOffice()%>">
                        <p>
                        <input type="submit" name="update" value="Update">                                        
                        </p>
                    </form>                     
                        
                    <table style="margin: auto">   
                        <caption>You have <%=d2.dList.getCount()%> Appointment(s):</caption>
                            <tr>
                                <th>Date/Time</th>
                                <th>Patient</th>
                                <th>Procedure</th>
                            </tr>
                            <% for (int i =0; i < d2.dList.aList.size(); i++) { %>                   
                                <tr>
                                    <td><%=d2.dList.aList.get(i).getApptDateTime() %></td>  
                                    <td><%=d2.dList.aList.get(i).getPatId() %></td>
                                    <td><%=d2.dList.aList.get(i).getProcCode() %></td>
                                </tr>                                    
                            <%}%>  
                    </table>
                    <br>                
                </div>                                           
            </div>
        </div>
    </body>
</html>
    