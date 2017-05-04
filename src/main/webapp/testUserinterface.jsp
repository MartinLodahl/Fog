<%-- 
    Document   : testUserinterface
    Created on : 02-05-2017, 20:46:47
    Author     : Pravien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" ></script>
        
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" ></script>
    </head>
    <body>
        
        <!-- multistep form -->
        <form id="msform">
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Carport</li>
                <li>Personlige oplysninger</li>
                <li>pris</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Carport</h2>
                <h3 class="fs-subtitle">Indtast mål for carport</h3>
                
                    <label for="width">Bredde cm:</label>
                    <input type="number" name="width" id="width" value="400">
                
                    <label for="length">Længde cm:</label>
                    <input type="number" name="length" id="length" value="450">
                
                    <label for="height">Højde: cm</label>
                    <input type="number" name="height" id="height" value="200"> Skur
                
                    <input type="checkbox" name="skur" id="skur">
                    <label for="skur">Fog skal bygge carporten</label>
                
                    <input type="checkbox" name="build" id="build">
                
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Personlige oplysninger</h2>
                <h3 class="fs-subtitle">Indtast dine personlige oplysniger</h3>
                
                <label for="name">Navn:</label>
                <input type="text" name="name" id="name">
            
                <label for="email">Email:</label>
                <input type="email" name="email" id="email">
            
                <label for="phone">Telefonnummer:</label>
                <input type="tel" name="phone" id="phone">
            
                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">We will never sell it</h3>
                <input type="text" name="fname" placeholder="First Name" />
                <input type="text" name="lname" placeholder="Last Name" />
                <input type="text" name="phone" placeholder="Phone" />
                <textarea name="address" placeholder="Address"></textarea>
                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="submit" name="submit" class="submit action-button" value="Submit" />
            </fieldset>
        </form>
        <script src="interfaceScript.js"></script>
    </body>
</html>
