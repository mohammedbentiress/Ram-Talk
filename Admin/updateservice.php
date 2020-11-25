<?php

$conn=new mysqli('localhost','root','','ram');
$query="select * from service where id=".$_GET['id'];

$services=mysqli_query($conn,$query);
while($serv=mysqli_fetch_array($services)){
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="css/form.css" />
    <title>Document</title>
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
      <h1>Modifier Service</h1>
    </div>
    <form method="POST" href="updateservice.php">
      <div class="fields">
        <div class="control">
          <label>Nom de service</label>
          <input type="text" name="nom" value="<?php echo  htmlspecialchars($serv['Nom_service']); ?>" />
        </div>
        <div class="control">
          <label>Chef de service (id)</label>
          <input type="text" name="chef" value="<?php echo  htmlspecialchars($serv['Chef_service']); ?>" />
        </div>
        <div class="control">
          <label>Description:</label>
          <input type="text" name="desc" value="<?php echo  htmlspecialchars($serv['Description']); ?>" />
        </div>
      </div>
      <div class="control-sub">
        <input type="submit" value="Modifier" name="modifier" />
      </div>
    </form>
  </body>
</html>

<?php
    if(isset($_POST['nom'])&&$_POST['nom'] && isset($_POST['chef'])&&($_POST['chef']) 
    && isset($_POST['desc'])&&$_POST['desc'] ){
        $nom=$_POST['nom'];
	    $chef=$_POST['chef'];
        $desc=$_POST['desc'];
        
        $query="UPDATE service SET Nom_service='$nom',Chef_service='$chef',Description='$desc' WHERE id=".$_GET['id'];
        $res=mysqli_query($conn,$query);
        header('Location: gestionservice.php');
    }
    
}