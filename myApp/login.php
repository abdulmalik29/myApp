<?php
require "conn.php";

$email = $_GET["email"];
$password = $_GET["password"];

$query = "select name from users where email = $email and password = $password";
$result = mysqli_query($conn, $query);

if (!mysqli_num_rows($result)>0)
{
  $status = "failed";
  echo json_encode(array('response'=>$status));
}
else
{
  $row = mysqli_fetch_assoc($result);
  $name = $row['name'];
  $status = "ok";
  echo json_encode(array('response'=>$status, "name"=>$name));
}

mysqli_close($conn);

?>
