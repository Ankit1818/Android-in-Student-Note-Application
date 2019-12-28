<?php
include 'dbConnect.php';

$StudentLogID=$_REQUEST["StudentLogID"];
$StudentPassword=$_REQUEST["StudentPassword"];

//$sel="select * from registration where  username='$unm' and password='$pwd'";
$sel="select * from StudentRegistration where StudentLogID='$StudentLogID' and StudentPassword = '$StudentPassword'";
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