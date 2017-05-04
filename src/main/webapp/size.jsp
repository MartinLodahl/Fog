<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bestil Carport</title>
        <link href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.3/jquery-ui.min.js"></script>
    </head>
    <body>
        <p><a href=".">Menuen</a></p>
        <form method="post" action="./size">
            <p>
                <label for="name">Navn:</label>
                <input type="text" name="name" id="name">
            </p>
            <p>
                <label for="email">Email:</label>
                <input type="email" name="email" id="email">
            </p>
            <p>
                <label for="phone">Telefonnummer:</label>
                <input type="tel" name="phone" id="phone">
            </p>
            <p>
                <label for="width">Bredde:</label>
                <input type="number" name="width" id="width" value="400"> cm
            </p>
            <p>
                <label for="length">Længde:</label>
                <input type="number" name="length" id="length" value="450"> cm
            </p>
            <p>
                <label for="height">Højde:</label>
                <input type="number" name="height" id="height" value="200"> cm
            </p>
            <p>
                <input type="checkbox" name="skur" id="skur">
                <label for="skur">Skur</label>
            </p>
            <p>
                <input type="checkbox" name="build" id="build">
                <label for="build">Fog skal bygge carporten</label>
            </p>

            <p>
                <input name="callDate" id="callDate">
                <label for="build">Fog skal bygge carporten</label>
            </p>

            <p>
                <button>Bestil</button>
            </p>
        </form>
        <script src="disableDates.js" ></script>
    </body>
</html>
