<?php

$conn=new mysqli('localhost','root','','ram');
$query="select * from users where id=".$_GET['id'];

$user=mysqli_query($conn,$query);
while($col=mysqli_fetch_array($user)){
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
      <h1>Modifier Employée</h1>
    </div>
    <form method="POST" href="updateusers.php">
      <div class="fields">
        <div class="control">
          <label>Nom</label>
          <input type="text" name="nom" value="<?php echo  htmlspecialchars($col['Nom']); ?>" />
        </div>
        <div class="control">
          <label>Prenom</label>
          <input type="text" name="prenom" value="<?php echo  htmlspecialchars($col['Prenom']); ?>" />
        </div>
        <div class="control">
          <label>Email</label>
          <input type="email" name="email" value="<?php echo  htmlspecialchars($col['Email']); ?>" />
        </div>
        <div class="control">
          <label>Service (id)</label>
          <input type="text" name="service" value="<?php echo  htmlspecialchars($col['id_service']); ?>" />
        </div>
      </div>
      <div class="control-sub">
        <input type="submit" value="modifier" name="modifier" />
      </div>
    </form>
  </body>
</html>

<?php
    if(isset($_POST['nom'])&&$_POST['nom'] && isset($_POST['prenom'])&&($_POST['prenom']) 
    && isset($_POST['email'])&&$_POST['email'] && isset($_POST['service'])&&$_POST['service']){
        $nom=$_POST['nom'];
	    $prenom=$_POST['prenom'];
        $email=$_POST['email'];
        $serv=$_POST['service'];
        
        $query="UPDATE users SET Nom='$nom',Prenom='$prenom',Email='$email',id_service=$serv WHERE id=".$_GET['id'];
        $res=mysqli_query($conn,$query);
        header('Location: gestionusers.php');
    }
    
}
?>