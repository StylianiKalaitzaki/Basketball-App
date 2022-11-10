<?php
	$name = $_POST['name'];
	$city = $_POST['city']; 
	$logo = $_POST['teamLogo'];
	
	$connection = new mysqli('localhost','root','','basketapp');
	if($connection->connect_error){
		die('Connection Failed : ' .$connection->connect_error);
	}else{														
		$stmt = $connection->prepare("insert into Teams(name,city,logo) values(?,?,?)");
										
		$stmt->bind_param("sss",$name,$city,$logo);
		$stmt->execute();
		echo "Registrated Succesfully";
		$stmt->close();
		$connection->close();
	}
?>