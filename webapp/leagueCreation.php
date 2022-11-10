<?php

	$conn = new mysqli("localhost","root","","basketapp");
	$sql = "SELECT * FROM Teams";
	$result = mysqli_query($conn,$sql);
	$rowcount = mysqli_num_rows($result);

	$success = false;

   	if($rowcount == 0)

		echo"Νumber of teams not correct.";

	else {

		$count = 0;

		while($row = mysqli_fetch_array($result)) {
			
			$team=$row["name"];
			$sql2="insert into ranking(teamName,wins,defeats,pointsDifference,leaguePoints,gamesPlayed) values('".$team."',0,0,0,0,0)";
			if(mysqli_query($conn, $sql2)) {
				//Do nothing
			} else{
				echo "ERROR: Could not able to execute $sql2. " . mysqli_error($conn);
				exit();
			}
		}
		$success = true; 

		if ($success) 
			echo "League created successfully.\n";
			
	}
		
?>