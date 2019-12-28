<?php
include('dbConnect.php');

 $sql = "SELECT * FROM StaffRegistration";
 
 $r = mysqli_query($con,$sql);
$response = array();
 
while ($row = mysqli_fetch_array($r))
 {
       // $value = array();
        $value["StaffID"] = $row["StaffID"];
        $value["StaffName"] = $row["StaffName"];
        $value["StaffPassword"] = $row["StaffPassword"];
        $value["StaffEmail"] = $row["StaffEmail"];
        
        array_push($response, $value);
    }

    // echoing JSON response
    echo json_encode($response);
    mysqli_close($con);
 