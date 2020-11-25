<?php   
    header('Access-Control-Allow-Origin:*');
    header('Content-Type:application/json');
    $id=$_GET['id']; 
    
        $conn=new mysqli('localhost','root','','ram');
		$query="UPDATE users set statut='0' where id=".$id;
		$res=mysqli_query($conn,$query);

	session_start();
	$_SESSION=array();

	session_destroy();
	unset($_SESSION);

	unset($_COOKIE);

	header("Cashe-Controle: no-store,no-cache,must-revilated");
	echo json_encode([
		'id'=>$id,
		'res'=>json_encode($res),
        'state'=>false
	])
?>