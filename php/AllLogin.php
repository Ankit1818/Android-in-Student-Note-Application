<?php
include 'dbConnect.php';

$AdminEmail=$_REQUEST["AdminEmail"];
$AdminPassword=$_REQUEST["AdminPassword"];
/*$AdminEmail="demo@111";
$AdminPassword="5558";
*/
//$sel="select * from registration where  username='$unm' and password='$pwd'";
$sel="select * from AdminRegistration where  AdminEmail='$AdminEmail' and AdminPassword = '$AdminPassword'";


$ex=mysqli_query($con,$sel);

$no=mysqli_num_rows($ex);
$response = array();
//echo $no;


if($no>0)
{

$row = mysqli_fetch_row($ex);
$value["code"]="admin";
	 $value["AdminID"] = $row["0"];
        $value["AdminName"] = $row["1"];
        $value["AdminEmail"] = $row["2"];
        $value["AdminPassword"] = $row["3"];



        array_push($response, $value);

/*$fet=mysqli_fetch_object($ex);*/
echo json_encode($response);
}
else
{
    /*$code = "Login_failed";*/
/*echo "0";*/
            $sel="select * from StaffRegistration where  StaffPassword='$AdminPassword' and StaffEmail = '$AdminEmail'";


        $ex=mysqli_query($con,$sel);

            $nos=mysqli_num_rows($ex);
                $response = array();
                //echo $no;


                    if($nos>0)
                {
                    

                $row = mysqli_fetch_row($ex);
                $value["code"]="staff";
	             $value["StaffID"] = $row["0"];
                 $value["StaffName"] = $row["1"];
                     $value["StaffPassword"] = $row["2"];
                    $value["StaffEmail"] = $row["3"];



             array_push($response, $value);


            echo json_encode($response);
        }
        else
        {
                 /*$code = "Login_failed";*/
           /* echo "0";*/
                            $sel="select * from StudentRegistration where  StudentLogID='$AdminEmail' and StudentPassword = '$AdminPassword'";


                        $ex=mysqli_query($con,$sel);

                        $noss=mysqli_num_rows($ex);
                         $response = array();
                        //echo $no;


                                if($noss>0)
                                 {
                    

                                    $row = mysqli_fetch_row($ex);
                                    $value["code"]="stud";
	                                $value["StudentID"] = $row["0"];
                                 $value["StudentName"] = $row["1"];
                                  $value["StudentLogID"] = $row["2"];
                                     $value["StudentPassword"] = $row["3"];
                                     $value["StudentEmail"] = $row["4"];
                                     $value["StudentRollno"] = $row["5"];

                                    array_push($response, $value);


                                     echo json_encode($response);
                                 }
                             else
                            {
                                 /*$code = "Login_failed";*/
                                 echo "0";


                             }


        }


}


?>