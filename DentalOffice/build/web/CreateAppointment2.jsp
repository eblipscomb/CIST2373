<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Create Appointment Menu  Page Alternate if Dentist has schedule conflict
--%>

<%@page import="business.Patient" %>
<%@page import="business.Appointment" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Appointment Page 2</title>
        <link rel="stylesheet" href="styles.css">
        <style>
            span {font-family:arial, times, sans-serif; 
                  text-align:left;
            }
        </style>
    </head>
    <body>
        <%
            Patient p2; 
            p2 = (Patient)session.getAttribute("p1"); 
            
            Appointment a2;
            a2 = (Appointment)session.getAttribute("a1");

        %>          
        
        <div>
            <img src="images/smilingCouplePatPage1.jpg" alt="Smiling Couple for Patient Page"/>
            <div id="wrapper">
                <% if (a2.getHasAppt()) { %>            
                    <div id="green-bar" style="font-size:70%"><%=p2.getPatFirstName()%>,  Selected dentist has a schedule conflict. Pick another date/time or dentist</div>     
                    <div>    
                        <form action="http://localhost:8084/DentalOffice/AppointmentServlet"  method="post">                           
                            <table align="center">                          
                                <tr>
                                    <td>
                                        <span>Date/Time:</span>
                                    </td>
                                    <td>
                                        <input type="text" name="datetimetb" value="<%=a2.getApptDateTime()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>Dentist:</span>
                                    </td>
                                    <td>
                                        <input type="text" name="dentisttb" value="<%=a2.getDentId()%>">                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>Procedure:</span>
                                    </td>
                                    <td>
                                        <input type="text" name="proceduretb" value="<%=a2.getProcCode()%>">                                            
                                    </td>
                                </tr>                            
                            </table>
                            <p>
                                <input type="submit" name="create" value="Update Appointment">   
                                <input type="button" value="Back" onclick="history.back()">
                            </p>                    
                <% } 
                else { %>
                    <div id="green-bar">Make an Appointment for <%=p2.getPatFirstName()%> <%=p2.getPatLastName()%>:</div>     
                    <div>    
                        <form action="http://localhost:8084/DentalOffice/AppointmentServlet"  method="post">                           
                            <table align="center">  
                                <tr>
                                    <td>
                                        <span>Date/Time:</span>
                                    </td>
                                    <td>
                                        <input type="text" name="datetimetb">                                         
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span style="font-size:small">Date/Time Format:</span>
                                    </td>    
                                    <td>
                                        <span style="font-size:small">Jan 1, 2018, 2pm</span>
                                    </td>
                                </tr>    
                                <tr>
                                    <td>
                                        <span>Dentist:</span>
                                    </td>
                                    <td>                                
                                        <select name="dentisttb">
                                            <option value=""></option>
                                            <option value="D2111">**Mark Jones**</option>
                                            <option value="D2112">**Christine Jones**</option>
                                            <option value="D201">Frank Martin</option>
                                            <option value="D202">Susan Cassidy</option>
                                            <option value="D203">Jerry York</option>
                                            <option value="D204">Wayne Patterson</option>                                            
                                        </select>    
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>Procedure:</span>
                                    </td>
                                    <td>
                                        <select name="proceduretb">
                                            <option value=""></option>
                                            <option value="P114">Cleaning/Exam</option>
                                            <option value="P119">Full X-rays</option>
                                            <option value="P122">Teeth Whitening</option>
                                            <option value="P321">Fill a Cavity</option>
                                            <option value="P650">Add Top Dentures</option>
                                            <option value="P660">Add Bottom Dentures</option>
                                            <option value="P780">Put a Crown on a bad tooth</option>
                                            <option value="P790">Replace Bad Tooth</option>                                             
                                        </select>
                                    </td>
                                </tr>
                            </table>  
                            <p>
                                <input type="submit" name="create" value="Create Appointment">
                                <input type="reset" name="reset" value="Clear">      
                                <input type="button" value="Back" onclick="history.back()">
                            </p>
                <% }%>             
        </form> 
    </div>   
    </div>
    </div>
    </body>
</html>
