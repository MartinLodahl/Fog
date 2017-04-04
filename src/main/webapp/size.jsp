<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Log ind</title>
    </head>
    <body>
        <form method="post" action="./bestil">
            <p>
                <label for="width">Bredde:</label>
                <input type="number" name="width" id="width" value="400"> cm
            </p>
            <p>
                <label for="password">Længde:</label>
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
