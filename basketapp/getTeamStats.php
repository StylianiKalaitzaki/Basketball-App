<?php
	$team = $_GET["team"];
	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="basketapp";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT teamName,COUNT(gameID) AS Games, SUM(shots) AS Shots,SUM(shotsIn) AS ShotsIn, 
	SUM(onePointShots) AS 1P,SUM(onePointShotsIn) AS 1P_IN,
	SUM(twoPointsShots) AS 2P,SUM(twoPointsShotsIn) AS 2P_IN,
	SUM(threePointsShots) AS 3P, SUM(threePointsShotsIn) AS 3P_IN,
	SUM(rebounds) AS Rebounds,SUM(assists) AS Assists,
	SUM(steals) AS Steals,SUM(blocks) AS Blocks,
	SUM(fouls) AS Fouls, SUM(points) AS Points,SUM(turnovers) AS Turnovers
	FROM teamsstatistics
	WHERE teamsstatistics.teamName=" . $team . "
	GROUP BY teamName";
	$sql2 = "SELECT teamName, wins AS Wins,defeats AS Defeats
	FROM ranking
	WHERE ranking.teamName=". $team;
	
	$result = mysqli_query($dbh, $sql);
	$result2 = mysqli_query($dbh, $sql2);
	
	while ($row = mysqli_fetch_array($result)) 
	{
		$nested_data = array();
		$nested_data['Games']= $row['Games'];
		$nested_data['Shots']= $row['Shots'];
		$nested_data['ShotsIn']= $row['ShotsIn'];
		$nested_data['1P']= $row['1P'];
		$nested_data['1P_IN']= $row['1P_IN'];
		$nested_data['2P']= $row['2P'];
		$nested_data['2P_IN']= $row['2P_IN'];
		$nested_data['3P']= $row['3P'];
		$nested_data['3P_IN']= $row['3P_IN'];
		$nested_data['Rebounds']= $row['Rebounds'];
		$nested_data['Assists']= $row['Assists'];
		$nested_data['Steals']= $row['Steals'];
		$nested_data['Blocks']= $row['Blocks'];
		$nested_data['Fouls']= $row['Fouls'];
		$nested_data['Points']= $row['Points'];
		$nested_data['Turnovers']= $row['Turnovers'];
		while ($row2 = mysqli_fetch_array($result2)) 
		{
			$nested_data['Wins']= $row2['Wins'];
			$nested_data['Defeats']= $row2['Defeats'];
		}
		$data[$row['teamName']] = $nested_data;
	}


	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>