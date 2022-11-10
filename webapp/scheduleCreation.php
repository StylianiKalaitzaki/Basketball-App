<?php

    $conn = new mysqli("localhost","root","","basketapp");
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "select * from teams";
    $result = mysqli_query($conn,$sql);
    $teams = array();
    $days = array(); 
    $dates = array();

    while ($row = mysqli_fetch_array($result)) 
        $teams[] = $row['name'];
    

    for($i=0;$i<count($teams);$i++) 
        $days[$i] = range(1, 2*(count($teams)-1));

    $startDate = new DateTime('2022-09-24');
    for($i=0;$i<2*(count($teams)-1);$i++) {
        $nextSaturday = new DateTime($startDate->modify('next saturday')->format('Y-m-d H:i:s'));
        $nextSaturday->setTime(17,00);
        $dates[$i] = $nextSaturday;
    }

    $random_teams_array = range(0, count($teams)-1);
    shuffle($random_teams_array);
    $random_teams_array = array_slice($random_teams_array,0,count($teams));
    
    $gameID = 0;

    for ($i = 0; $i < count($teams); $i++)  {

        for($j=0;$j<count($random_teams_array);$j++) {

            $rand_num = $random_teams_array[$j];
    
            if($teams[$i] != $teams[$rand_num]) {  

                $day = min(array_intersect($days[$i], $days[$rand_num]));

                $ind1 = array_search($day,$days[$i]);
                unset($days[$i][$ind1]);

                $ind2 = array_search($day,$days[$rand_num]);
                unset($days[$rand_num][$ind2]);

                $date = $dates[$day-1]->format('Y-m-d H:i:s');

                $sql = "insert into games(gameID, day, homeTeam, awayTeam, score, date) 
                values ('$gameID', '$day', '$teams[$i]', '$teams[$rand_num]', '-', '$date')";
                $conn->query($sql);
                $gameID ++;
            
            }
        }    
    } 
    

    $sql_check = "select * from games";
    $sql_result = $conn->query($sql_check);
    if (mysqli_num_rows($sql_result)>0) 
        echo "Schedule created.";
    else echo "Error.";

?>