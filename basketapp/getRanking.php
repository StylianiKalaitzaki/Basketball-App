<?php

	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="basketapp";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT teams.logo as logo, ranking.teamName as teamName, ranking.leaguePoints as points FROM ranking JOIN teams on ranking.teamName = teams.name ORDER BY ranking.leaguePoints DESC;";
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) {
        $nested_data = array();
        $nested_data['logo']=$row['logo'];        
        $nested_data['points']=$row['points'];
		$data[$row['teamName']] = $nested_data;
	}
	
	

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
	
?>