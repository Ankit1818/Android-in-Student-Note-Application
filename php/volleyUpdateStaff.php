<?php
 include('dbConnect.php');
 
 
 $StaffID= $_POST['StaffID'];
 $StaffName= $_POST['StaffName'];
 $StaffPassword = $_POST['StaffPassword'];
 $StaffEmail = $_POST['StaffEmail'];


$Sql_Query = "UPDATE StaffRegistration SET StaffName= '$StaffName', StaffPassword = '$StaffPassword', StaffEmail = '$StaffEmail'  WHERE StaffID = '$StaffID'";

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