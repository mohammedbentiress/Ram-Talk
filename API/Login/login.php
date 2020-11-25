<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');
$query="select * from users where username='".$_GET['username']."' and password='".$_GET['password']."'";

$res=mysqli_query($conn,$query);
$v=mysqli_fetch_array($res);
if(mysqli_num_rows($res) != 0){
    $id=$v['id'];
    $username=$v['Username'];

    $u_query="UPDATE users set statut='1' where id=".$id;
    $res2=mysqli_query($conn,$u_query);
    echo json_encode([
        'id'=>$id,
        'username'=>$username,
        'state'=>true
    ]);

}
else
    echo json_encode([
        'msg'=>"username or password isn't correct",
        'state'=>false
    ]);