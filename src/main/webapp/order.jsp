<%-- 
    Document   : Order
    Created on : 04-04-2017, 11:07:02
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
        <h1>Hello World! ${order.id} </h1>

        <table>

            <table>
                <tr>
                    <th>OrderId</th>
                    <th>name</th>
                    <th>mail</th>
                    <th>phone</th>
                    <th>finished</th>
                    <th>width</th>
                    <th>length</th>
                    <th>height</th>
                </tr>
                <tr>
                    <td>${order.id}</td>
                    <td>${order.customerName}</td>
                    <td>${order.customerMail}</td>
                    <td>${order.customerPhone}</td>
                    <td>${order.isFinished}</td>
                    <td>${order.width}</td>
                    <td>${order.length}</td>
                    <td>${order.height}</td>
                </tr>

            </table>

    </body>
</html>
