<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Dental Office Project
    Due: 12/5/17

    Document   : Patient Menu  Page
--%>

<%@page import="business.Patient" %>
<%@page import="business.Appointment" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Activity Page</title>
        <link rel="stylesheet" href="styles.css">        
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
                <div id="green-bar">Welcome <%=p2.getPatFirstName()%> <%=p2.getPatLastName()%></div>     
                <div>                    
                    <h4>View/Update your Personal Information below:</h4>
                    <form action="http://localhost:8084/DentalOffice/UpdateInfoServlet"  method="post">   
                        <input type="hidden" name="logintype" value="pat">    
                        <span>First Name:</span>
                        <input type="text" name="fntb" value="<%=p2.getPatFirstName()%>">
                            
                        <span>Last Name:</span>
                        <input type="text" name="lntb" value="<%=p2.getPatLastName()%>">
                        <br>
                        <span>Address:</span>
                        <input type="text" name="addresstb" value="<%=p2.getPatAddress()%>">
                              
                        <span>Email:</span>
                        <input type="text" name="emailtb" value="<%=p2.getPatEmail()%>">
                        <br>
                        <span>Ins Co:</span>
                        <input type="text" name="inscotb" value="<%=p2.getPatInsCo()%>">
                        <p>
                        <input type="submit" name="update" value="Update">                                        
                        </p>
                    </form> 
                    
                        <% if (a2.getHasAppt()) { %>
                            <p>Your Appointment is scheduled for: <%=a2.getApptDateTime()%></p>
                            <a href="CreateAppointment.jsp" class="link-btn">View/Change Appointment</a>
                        <% } 
                           else { %>
                            <p>You do not have an appointment.</p>
                            <a href="CreateAppointment.jsp" class="link-btn">Make an Appointment</a>
                        <% }%>                                                          
                    </div>                       
                </div>
            </div>
        </div>
    </body>
</html>
