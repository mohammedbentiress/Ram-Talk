<?php

$conn=new mysqli('localhost','root','','ram');

$id_emetteur=$_GET['id_emetteur'];
$id_recepteur=$_GET['id_recepteur'];

$query="SELECT * from message where (id_emetteur=".$id_emetteur." and id_recepteur=".$id_recepteur.") or (id_emetteur=".$id_recepteur." and id_recepteur=".$id_emetteur.") ORDER BY date";

$messages=mysqli_query($conn,$query);

$num=mysqli_num_rows($messages);

if($num>0){
    $messages_arr=array();
    while($message=mysqli_fetch_array($messages)){
        if($message['id_emetteur']==$id_emetteur){
                $side='right';}
        else if($message['id_emetteur']==$id_recepteur){
                $side='left';}
        $message_item=array(
            'id'=>$message['id'],
            'text'=>$message['Text_msg'],
            //'date'=>$message['date'],
            'sent'=>$message['sent'],
            'side'=>$side
        );
        array_push($messages_arr,$message_item);
       }  
    echo json_encode($messages_arr);
   
}
else{
    echo json_encode(
        array('message'=> 'No Posts Found:')
    );
}

