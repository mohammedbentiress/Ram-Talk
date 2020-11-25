<?php

$conn=new mysqli('localhost','root','','ram');

$query="select * from users";

$users=mysqli_query($conn,$query);
$pg_user="user";
$id= $_GET['id'];

?>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>gestionusers</title>
    <link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="css/table.css"
    />
  </head>
  </head>
  <body>
    <header>
      <div class="headg">
        <img src="images/svg/logo-no-text.svg" class="logo" />
      </div>
      <div class="burger-container">
        <div class="burger"></div>
      </div>
      <div class="headd">
        <ul>
          <li><a href="#">gestion des utilisateurs</a></li>
          <li><a href="gestionservice.php?id=<?php echo $id ;?>">gestion des services</a></li>
          <li><a href="deconnection.php?id=<?php echo $id ;?>">déconnecter</a></li>
        </ul>
      </div>
    </header>

    <main>
        <section>
            <table>
                <tr>
                    <th>Id</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>email</th>
                    <th>username</th>
                    <th>password</th>
                    <th>service</th>
                    <th>Modifier</th>
                    <th>Supprimer</th>
                </tr>
                <?php
                    while($user=mysqli_fetch_array($users)){
                        $query2="select * from service where id=".$user['id_service'];
                        $res=$conn->query($query2);
                        $service=mysqli_fetch_array($res);
                        $nom_service=$service['Nom_service'];
                        echo 
                        "<tr><td>{$user["id"]}</td>
                        <td>{$user["Nom"]}</td>
                        <td>{$user["Prenom"]}</td>
                        <td>{$user["Email"]}</td>
                        <td>{$user["Username"]}</td>
                        <td>{$user["Password"]}</td>
                        <td>$nom_service</td>
                        <td>
                        <a href=\"updateusers.php?id={$user["id"]}\"><img src=\"images/svg/edit.svg\" alt=\"Modifier\"/></a>
                        </td>
                        <td>
                        <a href=\"supprimer.php?source=$pg_user&id={$user["id"]}\"><img src=\"images/svg/delete.svg\" alt=\"Delete\"/></a>
                        </td></tr>";
                    }
                ?>
            </table>

            <hr width="90%" />

            <div class="add-container">
                <a href="ajouteruser.php" class="add">ajouter</a>
            </div>
        </section>
    </main>
  </body>
</html>
