<?php
include('dbConnect.php');

 $sql = "SELECT * FROM AdminRegistration";
 
 $r = mysqli_query($con,$sql);
$response = array();
 
while ($row = mysqli_fetch_array($r))
 {
       // $value = array();
        $value["AdminID"] = $row["AdminID"];
        $value["AdminName"] = $row["AdminName"];
        $value["AdminEmail"] = $row["AdminEmail"];
        $value["AdminPassword"] = $row["AdminPassword"];
       
        
        array_push($response, $value);
    }

    // echoing JSON response
    echo json_encode($response);
    mysqli_close($con);
 