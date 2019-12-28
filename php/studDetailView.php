<?php
include('dbConnect.php');

 $sql = "SELECT * FROM StudentRegistration";
 
 $r = mysqli_query($con,$sql);
$response = array();
 
while ($row = mysqli_fetch_array($r))
 {
       // $value = array();
        $value["StudentID"] = $row["StudentID"];
        $value["StudentName"] = $row["StudentName"];
        $value["StudentLogID"] = $row["StudentLogID"];
        $value["StudentPassword"] = $row["StudentPassword"];
         $value["StudentEmail"] = $row["StudentEmail"];
          $value["StudentRollno"] = $row["StudentRollno"];
        
        array_push($response, $value);
    }

    // echoing JSON response
    echo json_encode($response);
    mysqli_close($con);
 