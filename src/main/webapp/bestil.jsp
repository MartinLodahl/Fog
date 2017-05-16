<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel = "stylesheet" type = "text/css" href = "styletable.css" />
        
        <title></title>
    </head>
    <body>
        <div class="container">



            <p><a href=".">Menuen</a></p>
            <div class="row">  

                <h1>Forespørgsel godkendt</h1>
            </div>
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">

                    <table>
                        <tr>
                            <th>Total pris</th>
                        </tr>
                        <tr>
                            <td><fmt:formatNumber value="${total}" type="currency"/></td>
                        </tr>
                    </table>
                </div>            
                <div class="col-sm-3"></div>            
            </div>            



            <div class="row">               
                <h1>Plantegning fugleperspektiv</h1>
            </div>
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <svg height="800" width="600">
                    <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)+order.length}" y2="0" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <line x1="${(300-order.length/2)+order.length}" y1="0" x2="${(300-order.length/2)+order.length}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <line x1="${(300-order.length/2)}" y1="${order.width}" x2="${(300-order.length/2)+order.length}" y2="${order.width}" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <text x="300" y="15" text-anchor="middle" alignment-baseline="central" font-family="sans-serif" font-size="20px" fill="black">længde ${order.length} cm</text>
                    <text x="${(300-order.length/2)+order.length-150}" y="${order.width/2}" font-family="sans-serif" font-size="20px" fill="black">Bredde ${order.width} cm</text>
                    Sorry, your browser does not support inline SVG.
                    </svg>
                </div>        
                <div class="col-sm-3"></div>        
            </div>
            <div class="row">            
                <h1>Plantegning set fra siden</h1>
            </div>        
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <svg height="800" width="600">
                    <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)}" y2="${order.height}" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <line x1="${(300-order.length/2)}" y1="0" x2="${(300-order.length/2)+order.length}" y2="0" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <line x1="${(300-order.length/2)+order.length}" y1="0" x2="${(300-order.length/2)+order.length}" y2="${order.height}" style="stroke:rgb(0,0,0);stroke-width:2" />
                    <text x="300" y="15" text-anchor="middle" alignment-baseline="central" font-family="sans-serif" font-size="20px" fill="black">længde ${order.length} cm</text>
                    <text x="${(300-order.length/2)+order.length-150}" y="${order.height/2}" font-family="sans-serif" font-size="20px" fill="black">højde ${order.height} cm</text>
                    Sorry, your browser does not support inline SVG.
                    </svg>
                </div>            
                <div class="col-sm-3"></div>            
            </div>         
        </div>     
    </body>
</html>
