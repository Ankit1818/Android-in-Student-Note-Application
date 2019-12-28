<?php
include 'dbConnect.php';

$AdminEmail=$_REQUEST["AdminEmail"];
$AdminPassword=$_REQUEST["AdminPassword"];
/*$AdminEmail="admin@gmail.com";
$AdminPassword="admin";*/

//$sel="select * from registration where  username='$unm' and password='$pwd'";
$sel="select * from AdminRegistration where  AdminEmail='$AdminEmail' and AdminPassword = '$AdminPassword'";


$ex=mysqli_query($con,$sel);

$no=mysqli_num_rows($ex);
$response = array();
//echo $no;


if($no>0)
{

$row = mysqli_fetch_row($ex);

	 $value["AdminID"] = $row["0"];
        $value["AdminName"] = $row["1"];
        $value["AdminEmail"] = $row["2"];
        $value["AdminPassword"] = $row["3"];
/*	$code = "Success";*/


        array_push($response, $value);

/*$fet=mysqli_fetch_object($ex);*/
echo json_encode($response);
}
else
{
    /*$code = "Login_failed";*/

echo "0";
}


?>