<!DOCTYPE html>
<html>
    <head>
        <title> Juego Del Gato Con MINMAX </title>
        <link rel="stylesheet" href="gato.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <?php
        
        include "navbar.php";

        ?>
        <br>
        <center><h1>Algoritmo MiniMax</h1></center>
        <table>
            <tr>
                <td class="celda" id="0"></td>
                <td class="celda" id="1"></td>
                <td class="celda" id="2"></td>
            </tr>
            <tr>
                <td class="celda" id="3"></td>
                <td class="celda" id="4"></td>
                <td class="celda" id="5"></td>
            </tr>
            <tr>
                <td class="celda" id="6"></td>
                <td class="celda" id="7"></td>
                <td class="celda" id="8"></td> 
            </tr>
        </table>
        <div class="juegoterminado">
            <div class="text">
            </div>
            <button onclick="iniciarJuego()">Reiniciar</button>
        </div>
        <script src="gato.js"></script>
    </body>
</html>