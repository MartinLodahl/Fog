<%-- 
    Document   : addMatrial
    Created on : 18-04-2017, 10:26:18
    Author     : Pravien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tilføj materialer</title>
    </head>
    <body> 
        <form action="./addMatrial" method="post">
        <p><a href=".">Menuen</a></p>
        <form action="./addMaterial" method="post">
        <label for="name">navn:</label> <input type="text" name="materialname"><br>
        <select name="select">
            <option value="stolpe">stolpe</option>
            <option value="brædde">brædde</option>
            <option value="tag">tag</option>
            <option value="plade" selected>plade</option>
        </select>
        <label>størrelse:</label> <input type="text" name="size"><br>
        <label>pris:</label><input type="text" name="price"><br>
        <button>add</button>
        </form>
        
    </body>
</html>
