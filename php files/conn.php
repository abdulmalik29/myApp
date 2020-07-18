<?php
// $db_name = "myApp";
// $mysql_username = "root";
// $mysql_password = "";
// $server_name = "localhost";

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('db_name', 'myApp');

/**
 *
 */
class DB_Connection
{
  private $connect;
  function __construct()
  {
    $this->connect = mysqli_connect(hostname, user, password, db_name)
    or die('Connection error');
  }

  public function get_connection()
  {
      return $this->connect;
  }
}

?>
