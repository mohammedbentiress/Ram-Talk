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
      <h1>Ajouter Employée</h1>
    </div>
    <form method="POST" href="gestionusers.php">
      <div class="fields">
        <div class="control">
          <label>Nom</label>
          <input type="text" name="nom" />
        </div>
        <div class="control">
          <label>Prenom</label>
          <input type="text" name="prenom" />
        </div>
        <div class="control">
          <label>Email</label>
          <input type="email" name="email" />
        </div>
        <div class="control">
          <label>Username</label>
          <input type="text" name="username" />
        </div>
        <div class="control">
          <label>Password</label>
          <input type="password" name="password" />
        </div>
        <div class="control">
          <label>Service (id)</label>
          <input type="text" name="service" />
        </div>
      </div>
      <div class="control-sub">
        <input type="submit" value="ajouter" name="ajouter" />
      </div>
    </form>
  </body>
</html>

<?php
$conn=new mysqli('localhost','root','','ram');

if (isset($_POST['nom'])&&$_POST['nom'] && isset($_POST['prenom'])&&($_POST['prenom']) && isset($_POST['email'])&&$_POST['email'] 
&& isset($_POST['username'])&&$_POST['username'] && isset($_POST['password'])&&$_POST['password'] && isset($_POST['service'])&&$_POST['service']) {
	$nom=$_POST['nom'];
	$prenom=$_POST['prenom'];
    $email=$_POST['email'];
    $username=$_POST['username'];
    $password=$_POST['password'];
    $serv=$_POST['service'];

	$req = "INSERT INTO users(Nom,Prenom,Email,Username,Password,id_service) VALUES ('$nom' , '$prenom', '$email','$username','$password','".$serv."' ) " ;
    $resul=mysqli_query($conn,$req);

    header('Location: gestionusers.php');
    
}