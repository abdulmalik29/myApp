<?php
require_once 'conn.php';
header('Content-Type: application/json');

class User
{

  private $db;
  private $connection;

  function __construct()
  {
    $this->db = new DB_Connection;
    $this->connection = $this->db->get_connection();
  }

  /** a function that chest if the logins are corrects by checking if user exist,
   * by checking if the user exist and if the password/usename is worng
   */
  function does_user_exist($userName, $password)
  {
    $query = "SELECT * FROM users WHERE userName = $userName and password = $password";
    $result = mysqli_query($this->connection, $query);
    if (mysqli_num_rows($result) > 0 )
    {
      $json['success'] = 'Welcom again'.$userName;
      echo json_encode($json);
      mysqli_close($this->connection);
    }else
    {
        $query = "INSERT INTO users(userName,password) VALUES ('$userName', '$password')"; //creats a new account
        $is_inserted = mysqli_query($this->connection, $query);
        if ($is_inserted == 1)
        {
          $json['success'] = ' Account created, welcom'.$userName;
        }else
        {
        $json['error'] = 'Wrong password';
        }
      echo json_encode($json);
      mysqli_close($this->connection);
    }
 }
}



$user = new User;
if (isset($_POST['password'],$_POST['userName']))
{
  $userName = $_POST['userName'];
  $password = $_POST['password'];

  if (!empty($password) && !empty($userName))
  {
    $encrypted_password = md5($password);
    $user -> does_user_exist($userName, $encrypted_password);
  }
  else
  {
    echo json_encode("You must fill both fields ");
  }
}
 ?>
