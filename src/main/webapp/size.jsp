<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bestil Carport</title>
    </head>
    <body>
        <p><a href="./index">Menuen</a></p>
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
                <button>Bestil</button>
            </p>
        </form>
    </body>
</html>
