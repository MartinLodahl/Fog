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
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel = "stylesheet" type = "text/css" href = "styletable.css" />
        <title>adminmain</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <center>
                        <h1>Fog admin page</h1>
                    </center>
                </div>
            </div>
            <div class="row top-buffer">
                <%@include file = "menu.jsp" %>
                <div class="col-sm-9">
                    <div class="input-group">
                        <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                        <input class="form-control" id="system-search" name="q" placeholder="Søg efter" required style="color:white">
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-default mybtn-white"><i class="glyphicon glyphicon-search"></i></button>
                        </span>
                    </div>
                    <div class="panel panel-default">

                        <table class="table table-list-search table-bordered" >
                            <c:choose>
                                <c:when test="${fn:length(newOrders) gt 0}">    
                                    <tr>
                                        <th>Ordre ID</th>
                                        <th>Navn</th>
                                        <th>Mail</th>
                                        <th>Telefon</th>
                                        <th>Arkiveret</th>
                                        <th>Bredde</th>
                                        <th>Længde</th>
                                        <th>Højde</th>
                                        <th>Kontakt kunde den</th>
                                    </tr>
                                    <c:forEach items="${newOrders}" var="newOrders">

                                        <tr>
                                            <td><a href="./order?orderid=${newOrders.id}">${newOrders.id}</a></td>
                                            <td>${newOrders.customerName}</td>
                                            <td>${newOrders.customerMail}</td>
                                            <td>${newOrders.customerPhone}</td>
                                            <c:choose>
                                                <c:when test="${newOrders.status eq false}">
                                                    <td>Nej</td>
                                                </c:when>    
                                                <c:otherwise>
                                                    <td>Ja</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${newOrders.width}</td>
                                            <td>${newOrders.length}</td>
                                            <td>${newOrders.height}</td>
                                            <td>${newOrders.callDate}</td>
                                        </tr>

                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <p>Ingen ordre</p>
                                </c:otherwise>
                            </c:choose> 

                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="searchfilter.js" ></script>
    </body>
</html>
