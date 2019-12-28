<?php
 
 include('dbConnect.php');

 $username = $_POST['name'];
 $email = $_POST['email'];
 $password =$_POST['pass'];
 
if($username=="" && $email=="" && $password=="")
{
       echo '0';
}
else
{ 
  $sql = "INSERT INTO StaffRegistration (StaffName,StaffPassword,StaffEmail) VALUES ('$username','$password','$email')";
//echo $sql;
    $ex=mysqli_query($con,$sql);
    

}

 ?>