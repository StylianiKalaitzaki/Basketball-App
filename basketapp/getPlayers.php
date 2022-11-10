<?php
	$teamName = $_GET["teamName"];
	$data = array();
	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="basketapp";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
	$sql = "SELECT * from players where players.teamName=". $teamName;
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) {
		  $nested_data['teamName']=$row['teamName'];
		  $nested_data['id']=$row['id'];
	      $nested_data['firstname']=$row['firstname'];
		  $nested_data['lastname']=$row['lastname'];
		  $nested_data['position']=$row['position'];
		  $nested_data1 = array();
		  $nested_data1['1p']=$row['1p'];
		  $nested_data1['2p']=$row['2p'];
		  $nested_data1['3p']=$row['3p'];
		  $nested_data1['fouls']=$row['fouls'];
		  $nested_data1['assists']=$row['assists'];
		  $nested_data1['shots']=$row['shots'];
		  $nested_data1['rebounds']=$row['rebounds'];
		  $nested_data1['steals']=$row['steals'];
		  $nested_data1['turnovers']=$row['turnovers'];
		  $nested_data1['points']=$row['points'];
		  $nested_data1['blocks']=$row['blocks'];
	      $nested_data['statistics']=  $nested_data1;
		  $data[$row['id']] =  $nested_data;

	}
	
	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>
