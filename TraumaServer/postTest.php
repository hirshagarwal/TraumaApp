<?php

$jsonResult = file_get_contents("php://input");
$data = json_decode($jsonResult);
$result = $data->test;
echo $result;

?>