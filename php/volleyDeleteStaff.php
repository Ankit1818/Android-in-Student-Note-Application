<?php
 include('dbConnect.php');
 
 $ID = $_POST['StaffID'];

$Sql_Query = "DELETE FROM StaffRegistration WHERE StaffID = '$ID'";

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