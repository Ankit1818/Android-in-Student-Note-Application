<?php
 include('dbConnect.php');
 
 
 $StudentID= $_POST['StudentID'];
 $StudentName= $_POST['StudentName'];
 $StudentLogID = $_POST['StudentLogID'];
 $StudentPassword = $_POST['StudentPassword'];
 $StudentEmail= $_POST['StudentEmail'];
 $StudentRollno = $_POST['StudentRollno'];


$Sql_Query = "UPDATE StudentRegistration SET StudentName= '$StudentName', StudentLogID= '$StudentLogID', StudentLogID = '$StudentLogID', StudentPassword = '$StudentPassword',StudentRollno= '$StudentRollno' WHERE StudentID = '$StudentID'";

 if(mysqli_query($con,$Sql_Query))
{
    
 echo 'Record Updated Successfully';
}
else
{
 echo 'Something went wrong';
}
 
 mysqli_close($con);




?>