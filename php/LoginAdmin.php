<?php

 include('dbConnect.php');

$Name=$_POST["Name"];
$Password=$_POST["Password"];

$sql="SELECT AdminID,AdminName,AdminEmail,AdminPassword FROM AdminRegistration where AdminEmail like '$Name' and AdminPassword like '$Password' ";

$result = mysqli_query($conn,$sql);
$response = array();
if(mysqli_num_rows($result)>0)
{
	$row = mysqli_fetch_row($result);
	$AdminId=$row[0];
	$code = "Success";
	array_push($response,array("code"=>$code,"StaffID"=>$AdminId,"AdminId"=>"-1"));
        echo json_encode($response);

}
else
{
$sql="SELECT StaffID,StaffPassword,StaffEmail FROM disciplineadmin where StaffPassword like '$Password' and StaffEmail like '$Name' ";
	
	$result = mysqli_query($conn,$sql);
	if(mysqli_num_rows($result)>0)
{
	$row = mysqli_fetch_row($result);
	$AdminId=$row[0];
	$code = "Success";
	array_push($response,array("code"=>$code,"AdminId"=>$AdminId,"SuperAdminId"=>"-1"));
        echo json_encode($response);
}
else
{
	$code = "Login_failed";
	$message = "User not found...Please try again...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
}
mysqli_close($conn);
?>