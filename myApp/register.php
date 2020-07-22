<?php
require "conn.php";

$name = $_GET["name"];
$email = $_GET["email"];
$password = $_GET["password"];

$query = "select * from users where email like '$email' ";
$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) > 0 )
{
  $status = "exist";
}else
{
  $query = "insert into users(name, email, password) values ('$name', '$email', '$password');" ;

    if (mysqli_query($conn, $query))
    {
      $status = "ok";
    }else
    {
      $status = "regiter error";
    }
}

echo json_encode(array('response'=>$status));
?>
