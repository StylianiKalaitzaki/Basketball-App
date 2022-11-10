<?php
	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$position = $_POST['pos']; 
	$teamName = $_POST['teamName'];
	
	$connection = new mysqli('localhost','root','','basketapp');
	if($connection->connect_error){
		die('Connection Failed : ' .$connection->connect_error);
	}else{																									
		$stmt = $connection->prepare("insert into Players(firstname,lastname,position,teamName) values(?,?,?,?)");
															
		$stmt->bind_param("ssss",$firstname,$lastname,$position,$teamName);
		$stmt->execute();
		echo "Registrated Succesfully";
		$stmt->close();
		$connection->close();
	}
?>