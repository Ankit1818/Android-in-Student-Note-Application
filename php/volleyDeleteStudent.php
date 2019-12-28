<?php
 include('dbConnect.php');
 
 $ID = $_POST['StudentID'];

$Sql_Query = "DELETE FROM StudentRegistration WHERE StudentID = '$ID'";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Record Deleted Successfully';
}
else
{
 echo 'Something went wrong';
 }
 
 mysqli_close($con);
?>