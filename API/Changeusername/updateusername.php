<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');

$id=$_GET['id'];
$old_username=$_GET['old_username'];
$new_username=$_GET['new_username'];
$password=$_GET['password'];


$query="select * from users where username='".$old_username."' and password='".$password."'";

$res=mysqli_query($conn,$query);
$i=mysqli_fetch_array($res);
$id2=$i['id'];

if(mysqli_num_rows($res) != 0 && $id==$id2  ){
    $query_2="UPDATE users set username='".$new_username."' where id=".$id;
    $res2=mysqli_query($conn,$query_2);
    $test=json_encode($res2);

    if($test == 'false'){
        echo json_encode([
            'msg'=>"username already used",
            'state'=>false
        ]);
    }
    else{
    echo json_encode([
        'id'=>$id,
        'username'=>$new_username,
        'state'=>true
    ]);}
}
else{
    
    echo json_encode([
        'msg'=>"username or password isn't correct",
        'state'=>false
    ]);
}