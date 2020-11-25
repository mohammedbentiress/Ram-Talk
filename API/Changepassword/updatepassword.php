<?php 
header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');

$id=$_GET['id'];
$username=$_GET['username'];
$old_password=$_GET['old_password'];
$new_password=$_GET['new_password'];

$query="select * from users where username='".$username."' and password='".$old_password."'";

$res=mysqli_query($conn,$query);
$i=mysqli_fetch_array($res);
$id2=$i['id'];
if(mysqli_num_rows($res) != 0  && $id==$id2 ){
    $query_2="UPDATE users set password='".$new_password."' where id=".$id;
    $res2=mysqli_query($conn,$query_2);
    echo json_encode([
        'id'=>$id,
        'username'=>$username,
        'state'=>true
    ]);
}
else{
    if(mysqli_num_rows($res)==0){
    echo json_encode([
        'msg'=>"username or password isn't correct",
        'state'=>false
    ]);}
}