<?php 

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');
$id_emetteur=$_GET['id_emetteur'];
$id_recepteur=$_GET['id_recepteur'];
$Date=Date("y/m/d h:i:s");
$Text=$_GET['Text'];

$query="INSERT INTO message(Text_msg,date,id_emetteur,id_recepteur) VALUES('$Text','$Date',".$id_emetteur.",".$id_recepteur.")";

$res=mysqli_query($conn,$query);
$test=json_encode($res);

if($test=="true")
    echo json_encode($res);

else
    echo json_encode($res);
?>


