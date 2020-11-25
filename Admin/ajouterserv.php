<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Service Add</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/form.css" />
  </head>
  <body>
    <header>
      <div class="headd">
        <a href="#">
          <img src="images/svg/arrow-right-solid.svg" alt="" />
        </a>
      </div>
      <div class="headg">
        <img src="images/svg/logo-no-text.svg" class="logo" />
      </div>
    </header>
    <div class="title">
      <h1>Ajouter Service</h1>
    </div>
    <form method="POST" href="gestionservice.php">
      <div class="fields">
        <div class="control">
          <label>Nom de service</label>
          <input type="text" name="nom" />
        </div>
        <div class="control">
          <label>Chef de service (id)</label>
          <input type="text" name="chef" />
        </div>
        <div class="control">
          <label>Description</label>
          <input type="text" name="desc" />
        </div>
      </div>
      <div class="control-sub">
        <input type="submit" value="Ajouter" name="ajouter" />
      </div>
    </form>
  </body>
</html>


<?php
$conn=new mysqli('localhost','root','','ram');

if (isset($_POST['nom'])&&$_POST['nom'] && isset($_POST['chef'])&&($_POST['chef']) && isset($_POST['desc'])&&$_POST['desc'] ) {
	$nom=$_POST['nom'];
	$chef=$_POST['chef'];
	$desc=$_POST['desc'];

	$req = "INSERT INTO service(Nom_service,Chef_service,Description) VALUES ('$nom' , '$chef', '$desc' ) " ;
    $resul=mysqli_query($conn,$req);

    header('Location: gestionservice.php');
    
}