<%-- 
    Document   : Order
    Created on : 03-04-2017, 11:37:36
    Author     : Pravien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="./addMaterial">Tilføj materialer</a></p>
         <form action="./order" method="get">
            <p>
                <label for="orderid">Orderid:</label>
                <input type="text" name="orderid" id="orderid">
            </p>
            
            <p>
                <button>Search</button>
            </p>
        </form>
    </body>
</html>
