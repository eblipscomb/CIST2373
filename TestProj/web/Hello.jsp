<%-- 
    Ellen Lipscomb
    CIST 2373 Java III
    Lab #6 Part II - Hello.jsp
    Due: 10/17/17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello JSP Page</title>
    </head>
    <body>
        <% 
            int count = 6;
            for (int i = 1; i <= count; i++) { %>
                <h<%=i%> align="center">Hello World</h<%=i%>>
            <% } %>          
    </body>
</html>
