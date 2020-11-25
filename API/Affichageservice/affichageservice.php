<?php

header('Access-Control-Allow-Origin:*');
header('Content-Type:application/json');

$conn=new mysqli('localhost','root','','ram');
$query="select * from service";
$services=mysqli_query($conn,$query);

$num=mysqli_num_rows($services);

if($num>0){
    $services_arr=array();

    while($service=mysqli_fetch_array($services))
    {
            $query2="select * from users where id=".$service["Chef_service"];
            $resultat=$conn->query($query2);
            $chef=mysqli_fetch_array($resultat);
            $nom_chef=$chef['Nom']." ".$chef['Prenom'];
        
         $service_item=array(
            'id'=>$service['id'],
            'nom_service'=>$service['Nom_service'],
            'Chef_service'=>$nom_chef,
            'Description'=>$service['Description']
        );
        array_push($services_arr,$service_item);
    }
   
    echo json_encode($services_arr);
}
   
    
else{
    echo json_encode(
        array('message'=> 'No Posts Found:')
    );
}