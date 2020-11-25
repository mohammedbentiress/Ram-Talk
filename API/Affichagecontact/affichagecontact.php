<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');
$id=$_GET['id'];
$query="select * from users where id <>".$id;

$users=mysqli_query($conn,$query);
$num=mysqli_num_rows($users);
if($num>0){
    $users_arr=array();
    while($user=mysqli_fetch_array($users)){
            $query2="select * from service where id=".$user['id_service'];
            $res=$conn->query($query2);
            $service=mysqli_fetch_array($res);
            $nom_service=$service['Nom_service'];
        $user_item=array(
            'id'=>$user['id'],
            'nom'=>$user['Nom'],
            'prenom'=>$user['Prenom'],
            'Email'=>$user['Email'],
            'Username'=>$user['Username'],
            'service'=>$service['Nom_service'],
            'statut'=>$user['statut']
            
        );
        array_push($users_arr,$user_item);
    }
    echo json_encode($users_arr);
 
}
else{
    echo json_encode(
        array('message'=> 'No Posts Found:')
    );
}