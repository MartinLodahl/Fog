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
        <%@ taglib prefix="c" 
                   uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" ></script>
        <link href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.3/jquery-ui.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" ></script>
        <link rel = "stylesheet" type = "text/css" href = "styletable.css" />
        <title>Tilføj materialer</title>
    </head>
    <body> 
        <p><a href=".">Menuen</a></p>
        <%@include file = "menu.jsp" %>
        </form>
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
