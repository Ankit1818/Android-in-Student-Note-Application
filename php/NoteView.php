<?php
include('dbConnect.php');

 $sql = "SELECT * FROM Notes";
 
 $r = mysqli_query($con,$sql);
$response = array();
 
while ($row = mysqli_fetch_array($r))
 {
       // $value = array();
       $value["Id"] = $row["Id"];
        $value["Name"] = $row["Name"];
        $value["NoteTitle"] = $row["NoteTitle"];
        $value["NoteSubject"] = $row["NoteSubject"];
        $value["NoteDetails"] = $row["NoteDetails"];
        
        array_push($response, $value);
    }

    // echoing JSON response
    echo json_encode($response);
    mysqli_close($con);
 