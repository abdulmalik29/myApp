<?php

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('db_name', 'myApp');

$conn = mysqli_connect(hostname, user, password, db_name);

if ($conn->connect_error)
{
  die("Connection failed: " . $conn->connect_error);
}

echo "Connected successfully";

?>
