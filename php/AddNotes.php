<?php
 
 include('dbConnect.php');

 $Name = $_POST['Name'];
 $NoteTitle = $_POST['NoteTitle'];
 $NoteSubject=$_POST['NoteSubject'];
$NoteDetails=$_POST['NoteDetails'];

 
if($Name=="" && $NoteTitle=="" && $NoteSubject=="" && $NoteDetails=="")
{
       echo '0';
}
else
{ 
  $sql = "INSERT INTO Notes (Name,NoteTitle,NoteSubject,NoteDetails) VALUES ('$Name','$NoteTitle','$NoteSubject','$NoteDetails')";
//echo $sql;
    $ex=mysqli_query($con,$sql);
    

}

 ?>