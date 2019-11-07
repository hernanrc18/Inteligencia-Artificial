<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="bfs.js"></script>
</head>
<body>

	<?php
		
		include "navbar.php";

	?>

  <br>  
  <center><h1>Algoritmo BFS</h1></center>
  <br>
  <center>
  	<img src="bfs.png" height="200" width="250"><br><br>
  	<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <form class="form-signin">
              <div class="form-label-group">
              	<label for="inputPartida">Punto de partida</label>
                <input type="text" id="inputPartida" class="form-control" placeholder="Ingresa el punto de partida" required autofocus>
              </div><br>
              <div class="form-label-group">
              	<label for="inputFinal">Punto final</label>
                <input type="text" id="inputFinal" class="form-control" placeholder="Ingresa el punto final" required>
                
              </div><br>
              <button class="btn btn-primary btn-block text-uppercase" id="btnEjecutar">Ejecutar</button>
            </form>
      </div>
    </div>
  </div>
  </center>
 </body>