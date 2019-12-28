<?php
include 'dbConnect.php';

$StaffPassword=$_REQUEST["StaffPassword"];
$StaffEmail=$_REQUEST["StaffEmail"];

//$sel="select * from registration where  username='$unm' and password='$pwd'";
$sel="select * from StaffRegistration where  StaffPassword='$StaffPassword' and StaffEmail = '$StaffEmail'";
$ex=mysqli_query($con,$sel);
$no=mysqli_num_rows($ex);
//echo $no;


if($no>0)
{
$fet=mysqli_fetch_object($ex);
echo json_encode($fet);
}
else
{
echo "0";
}


?>