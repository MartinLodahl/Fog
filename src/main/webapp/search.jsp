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
        <title>Søgning</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </style>
</head>
<body>
    <p><a href=".">Menuen</a></p>
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
    <table>
        <c:choose>
            <c:when test="${fn:length(orders) gt 0}">    
                <tr>
                    <th>OrderId</th>
                    <th>name</th>
                    <th>mail</th>
                    <th>phone</th>
                    <th>status</th>
                    <th>width</th>
                    <th>length</th>
                    <th>height</th>
                </tr>
                <c:forEach items="${orders}" var="orders">

                    <tr>
                        <td><a href="./order?orderid=${orders.id}">${orders.id}</a></td>
                        <td>${orders.customerName}</td>
                        <td>${orders.customerMail}</td>
                        <td>${orders.customerPhone}</td>
                        <td>${orders.status}</td>
                        <td>${orders.width}</td>
                        <td>${orders.length}</td>
                        <td>${orders.height}</td>
                    </tr>

                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Ingen ordre</p>
            </c:otherwise>
        </c:choose> 

    </table> 
</body>
</html>
