<?php
 
 include('dbConnect.php');

 $username = $_POST['name'];
 $email = $_POST['email'];
 $password =$_POST['pass'];
$rollno=$_POST['rollno'];
$studlogid=$_POST['studlogid'];
 
if($username=="" && $email=="" && $password=="" && $rollno=="" && $studlogid=="")
{
       echo '0';
}
else
{ 
  $sql = "INSERT INTO StudentRegistration (StudentName,StudentLogID,StudentPassword,StudentEmail,StudentRollno) VALUES ('$username','$studlogid','$password','$email',$rollno)";
//echo $sql;
    $ex=mysqli_query($con,$sql);
    

}

 ?>