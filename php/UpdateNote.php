<?php
 include('dbConnect.php');
 
 
 $Id= $_POST['Id'];
 $Name= $_POST['Name'];
 $NoteTitle = $_POST['NoteTitle'];
 $NoteSubject = $_POST['NoteSubject'];
 $NoteDetails = $_POST['NoteDetails'];


$Sql_Query = "UPDATE Notes SET Name= '$Name', NoteTitle = '$NoteTitle', NoteSubject = '$NoteSubject', NoteDetails = '$NoteDetails'  WHERE Id = '$Id'";

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