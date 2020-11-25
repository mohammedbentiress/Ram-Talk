<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');
$id=$_GET['id'];
$query="select * from users where id =".$id;

$res=mysqli_query($conn,$query);

$user=mysqli_fetch_array($res);
$username=$user['Username'];

echo $username;