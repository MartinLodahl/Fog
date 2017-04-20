<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ taglib prefix="c" 
                   uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Ordre ${order.id}</title>
    </head>
    <body>
        <p><a href="./index">Menuen</a></p>
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
                <td>${order.status}</td>
                <td>${order.width}</td>
                <td>${order.length}</td>
                <td>${order.height}</td>
            </tr>
        </table>

        <form method="post">
            <input type="hidden" name="id" value="${order.id}">
            <c:choose>
                <c:when test="${order.status}">
                    <label>Order done :<input type="checkbox" name="orderDone" checked="checked"></label> 

                    <br />
                </c:when>    
                <c:otherwise>
                    <label>Order done : <input type="checkbox" name="orderDone"> </label>
                    <br />
                </c:otherwise>
            </c:choose>
            <div><button>Save changes</button></div>
        </form>   

        <form method="post" action="delete" onsubmit="return confirm('Er du sikker p? du vil slette denne ordre?');">
            <input type="hidden" name="id" value="${order.id}">
            <div><button>Slet</button></div>
        </form>
        <table>
            <tr>
                <th>material_id</th>
                <th>quantity</th>
                <th>length</th>
                <th>width</th>
                <th>price (for each)</th>
                <th>price (total)</th>
            </tr>
            <c:set var ="b" value = "${0}"/>
            <c:forEach items="${orderItems}" var="item">
                <tr>
                    <td><c:out value="${item.materialId}"/></td>
                    <td><c:out value="${item.quantity}"/></td>
                    <td><c:out value="${item.length}"/></td>
                    <td><c:out value="${item.width}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.price*item.quantity}"/></td>
                    <c:set var = "b" value = "${b+(item.price*item.quantity)}" />
                </tr>
            </c:forEach>
        </table>
        <c:if test="${b>0}"> 
            <table>
                <tr>
                    <th>total Order price</th>
                </tr>
                <tr>
                    <td><c:out value="${b}"/></td>
                </tr>
            </table>
        </c:if>


    </body>
</html>
