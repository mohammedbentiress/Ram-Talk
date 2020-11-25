<?php

$conn=new mysqli('localhost','root','','ram');

$query="select * from service";

$services=mysqli_query($conn,$query);

$pg_serv="service";
?>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>gestion service</title>

    <link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="css/table.css"
    />
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
          <li><a href="gestionusers.php?id=<?php echo $_GET['id'] ;?>">gestion des utilisateurs</a></li>
          <li><a href="#">gestion des services</a></li>
          <li><a href="deconnection.php?id=<?php echo $_GET['id'] ;?>">déconnecter</a></li>
        </ul>
      </div>
    </header>

    <main>
      <section>
        <table>
            <tr>
                <th>ID</th>
                <th>Nom Service</th>
                <th>Chef De Service</th>
                <th>Description</th>
                <th>Employees</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
                <?php
                    while($service=mysqli_fetch_array($services)){
                        $query2="select * from users where id=".$service["Chef_service"];
                        $resultat=mysqli_query($conn,$query2);
                        $row=mysqli_fetch_array($resultat);
                        $nom_chef=$row['Nom']." ".$row['Prenom'];
                        $query3="select * from users where id_service=".$service['id'];
                        $employees=mysqli_query($conn,$query3);

                        echo "<tr>
                                <td>{$service["id"]}</td>
                                <td>{$service["Nom_service"]}</td>
                                <td>$nom_chef</td>
                                <td>{$service["Description"]}</td>
                                <td>";

                        while($employee=mysqli_fetch_array($employees)){
                            echo "{$employee['Nom']} {$employee['Prenom']}<br/>";
                        }
                        
                        echo "</td>
                        <td>
                        <a href=\"updateservice.php?id={$service["id"]}\">
                        <img src=\"images/svg/edit.svg\" alt=\"Modifier\"/></a>
                        </td>
                        <td>
                        <a href=\"supprimer.php?source=$pg_serv&pg=1&id={$service["id"]}\">
                        <img src=\"images/svg/delete.svg\" alt=\"Delete\"/></a>
                        </td>
                        </tr>";
                    }
                ?>
        </table>
        <hr width="90%" />

        <div class="add-container">
          <a href="ajouterserv.php" class="add"><span>ajouter</span></a>
        </div>
      </section>
    </main>
  </body>
</html>