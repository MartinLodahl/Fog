<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bestilling Godkendt</title>
    </head>
    <body>
        <p><a href=".">Menuen</a></p>
        <h1>Bestilling godkendt</h1>
        <c:set var="b" value="${0}"/>
        <c:forEach items="${orderItems}" var="item">
            <c:set var = "b" value = "${b+(item.price*item.quantity)}" />
        </c:forEach>
        <c:if test="${b>0}"> 
            <table>
                <tr>
                    <th>total price</th>
                </tr>
                <tr>
                    <td><c:out value="${b}"/></td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
