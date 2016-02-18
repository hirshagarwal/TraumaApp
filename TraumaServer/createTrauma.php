<?php

//Include credentials file
include 'serverCredentials.php';

//Fields
$name = "";
$location = "";
$notes = "";


$postBody = file_get_contents('php://input');
$jsonInput = json_decode($postBody);

$name = $jsonInput->name;
$location = $jsonInput->location;
$notes = $jsonInput->notes;


mysql_connect($host, $dbUsername, $dbPassword, $db);
mysql_select_db($db);

$result = mysql_query("INSERT INTO currenttrauma (name, organizationId, location, notes) VALUES ('$name', 1, '$location', '$notes')") or die (mysql_error());

$returnObj = new stdClass();
$returnObj->status = "success";

$returnJson = json_encode($returnObj);
echo $returnJson;



?>