<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
    
        <p><a href=".">Menuen</a></p>
    <center>    
        <h1>Forespørgsel godkendt</h1>
        <c:forEach items="${orderItems}" var="item">
            <c:set var = "b" value = "${b+(item.price*item.quantity)}" />
        </c:forEach>
        <table>
            <tr>
                <th>Total pris</th>
            </tr>
            <tr>
                <td text-anchor="middle" alignment-baseline="central"><c:out value="${total}"/></td>
            </tr>
        </table>
            </center>
    <center>

        <h1>Plantegning fugleperspektiv</h1>
        <svg height="800" width="600">
        <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
        <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)+order.length}" y2="0" style="stroke:rgb(0,0,0);stroke-width:2" />
        <line x1="${(300-order.length/2)+order.length}" y1="0" x2="${(300-order.length/2)+order.length}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
        <line x1="${(300-order.length/2)}" y1="${order.width}" x2="${(300-order.length/2)+order.length}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
        <text x="300" y="15" text-anchor="middle" alignment-baseline="central" font-family="sans-serif" font-size="20px" fill="black">længde ${order.length} cm</text>
        <text x="${(300-order.length/2)+order.length-150}" y="${order.width/2}" font-family="sans-serif" font-size="20px" fill="black">Bredde ${order.width} cm</text>
        Sorry, your browser does not support inline SVG.
        </svg>


        <h1>Plantegning set fra siden</h1>
        <svg height="800" width="600">
        <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)}" y2="${order.height}" style="stroke:rgb(0,0,0);stroke-width:2" />
        <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)+order.length}" y2="0" style="stroke:rgb(0,0,0);stroke-width:2" />
        <line x1="${(300-order.length/2)+order.length}" y1="0" x2="${(300-order.length/2)+order.length}" y2="${order.height}" style="stroke:rgb(0,0,0);stroke-width:2" />
        <text x="300" y="15" text-anchor="middle" alignment-baseline="central" font-family="sans-serif" font-size="20px" fill="black">længde ${order.length} cm</text>
        <text x="${(300-order.length/2)+order.length-150}" y="${order.height/2}" font-family="sans-serif" font-size="20px" fill="black">Heigth ${order.height} cm</text>
        Sorry, your browser does not support inline SVG.
        </svg>
    </center>
</body>
</html>
