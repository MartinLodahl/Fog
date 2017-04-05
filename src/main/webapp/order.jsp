<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Ordre ${order.id}</title>
    </head>
    <body>
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
            
        <form method="post" action="save">
            <input type="hidden" name="id" value="${order.id}">
            <c:choose>
                <c:when test="${order.isFinished == 'false'}">
                    <label>Order done :</label> <input type="checkbox" name="orderDone" value="orderDone">
                    <br />
                </c:when>    
                <c:otherwise>
                    <label>Order done :</label> <input type="checkbox" name="orderDone" value="orderDone" checked="checked">
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
                <th>price (for all of this type)</th>
            </tr>

            <c:forEach var="orderitem" items="${orderItems}">
                <c:out value="${orderitem}" />
            </c:forEach>

        </table>


    </body>
</html>
