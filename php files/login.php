<?php
require "conn.php";

$user_name = "123";
$user_password = "123";
$mysql_qry = "select * from myapp where userName like '$user_name' AND pasword like '$user_password'; ";

$result = mysql_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0){
  echo "success";
}else{
  echo "not success";
}
?>
