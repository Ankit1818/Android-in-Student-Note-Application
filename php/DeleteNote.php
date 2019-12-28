<?php
 include('dbConnect.php');
 
 $ID = $_POST['Id'];

$Sql_Query = "DELETE FROM Notes WHERE Id = '$ID'";

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