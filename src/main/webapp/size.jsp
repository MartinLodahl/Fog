<%-- 
    Document   : size
    Created on : 03-04-2017, 11:43:59
    Author     : MartinLodahl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="LoginControl" method="POST">
             <label for="username">længde</label>
            <input type="number" name="længde" /><br>
             <label for="username">Bredde:</label>
            <input type="number" name="bredde" /><br>
            <label for="carport">Carport:</label> 
            <input type="checkbox" name="carport" value="carport">
            <label for="carport">Skur</label> 
            <input type="checkbox" name="skur" value="skur">
            <input type="submit" value="login" name="login">
        </form>
        
        
    </body>
</html>
