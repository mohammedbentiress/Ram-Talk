<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');

$id=$_GET['id'];

$query="select * from users where id <>".$id;

$users=mysqli_query($conn,$query);
$num=mysqli_num_rows($users);

if($num>0){
    
    $convs_arr=array();
    while($user2=mysqli_fetch_array($users)){
            $query2="select * from users where id =".$id;
            $res2=mysqli_query($conn,$query2);
            $user1=mysqli_fetch_array($res2);
        $conv_item=array(
            'emetteur'=>array(
                'id'=>intval($user1['id']),
                'nom'=>$user1['Nom'],
                'prenom'=> $user1['Prenom'],
                'Username'=>$user1['Username'],
                'statut'=>$user1['statut']
                ),
            'recepteur'=>array(
                'id'=>intval($user2['id']),
                'nom'=>$user2['Nom'],
                'prenom'=> $user2['Prenom'],
                'Username'=>$user2['Username'],
                'statut'=>$user2['statut']
                ),
        );
        array_push($convs_arr,$conv_item);
    }
    echo json_encode($convs_arr);
}
else{
    echo json_encode(
        array('message'=> 'No Posts Found:')
    );
    }
