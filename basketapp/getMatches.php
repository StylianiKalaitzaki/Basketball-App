<?php

	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="basketapp";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT * FROM games";
	
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) {

		$nested_data = array();
        $nested_data['homeTeam']=$row['homeTeam'];        
        $nested_data['awayTeam']=$row['awayTeam'];        
        $nested_data['score']=$row['score'];
		$nested_data['date']=$row['date']; 
		$nested_data['day'] = $row['day'];
        $data[$row['gameID']] = $nested_data;
	}

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
	
?>