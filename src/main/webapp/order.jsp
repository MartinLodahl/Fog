<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
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
        <form method="post" action="delete" onsubmit="return confirm('Er du sikker på du vil slette denne ordre?');">
            <input type="hidden" name="id" value="${order.id}">
            <div><button>Slet</button></div>
        </form>
    </body>
</html>
