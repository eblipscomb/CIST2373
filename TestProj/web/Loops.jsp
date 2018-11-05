<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #6 Part I - Loops.jsp
    Due: 10/17/17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loops JSP Page</title>
    </head>
    <body>
        <% 
            int count = 10;
            for (int i = 0; i < count; i++) { %>
                <h1 align="center">Go Braves</h1>
            <% } %>         
    </body>
</html>
