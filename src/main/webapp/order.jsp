<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ taglib prefix="c" 
                   uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Ordre ${order.id}</title>
        <link rel = "stylesheet" type = "text/css" href = "styletable.css" />
         
    </head>
    <body>
        <p><a href=".">Menuen</a></p>
        <%@include file = "menu.jsp" %>
        <table>
            <tr>
                <th>OrderId</th>
                <th>Navn</th>
                <th>Mail</th>
                <th>Telefon</th>
                <th>Bredde</th>
                <th>Længde</th>
                <th>Højde</th>
                <th>Fog bygger carporten</th>
            </tr>
            <tr>
                <td>${order.id}</td>
                <td>${order.customerName}</td>
                <td>${order.customerMail}</td>
                <td>${order.customerPhone}</td>
                <td>${order.width}</td>
                <td>${order.length}</td>
                <td>${order.height}</td>
                <c:choose>
                <c:when test="${order.build eq false}">
                    <td>Nej</td>
                </c:when>    
                <c:otherwise>
                    <td>Ja</td>
                </c:otherwise>
              </c:choose>      
            </tr>
        </table>

        <form method="post">
            <input type="hidden" name="id" value="${order.id}">
            <c:choose>
                <c:when test="${order.status}">
                    <label> :<input type="checkbox" name="Arkiver" checked="checked"></label> 

                    <br />
                </c:when>    
                <c:otherwise>
                    <label>Ønskes orderen arkiveret : <input type="checkbox" name="orderDone"> </label>
                    <br />
                </c:otherwise>
            </c:choose>
            <div><button>Save changes</button></div>
        </form>   

        
        <table>
            <tr>
                <th>Materiale ID</th>
                <th>Antal</th>
                <th>Længde</th>
                <th>Bredde</th>
                <th>Stk pris</th>
                <th>Total pris</th>
            </tr>
            <c:forEach items="${orderItems}" var="item">
                <tr>
                    <td><c:out value="${item.materialId}"/></td>
                    <td><c:out value="${item.quantity}"/></td>
                    <td><c:out value="${item.length}"/></td>
                    <td><c:out value="${item.width}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.price*item.quantity}"/></td>
                </tr>
            </c:forEach>
        </table>
        <table>
            <tr>
                <th>Total pris</th>
            </tr>
            <tr>
                <td><c:out value="${total}"/></td>
            </tr>
        </table>


    </body>
</html>
