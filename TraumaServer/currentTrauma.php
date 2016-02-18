<?php

//Include Server Credentials File
include 'serverCredentials.php';

//Fields
$organization = 1;

$traumas = array();

mysql_connect($host, $dbUsername, $dbPassword, $db);
mysql_select_db($db);


$result = mysql_query("SELECT * FROM currenttrauma WHERE organizationId='$organization'") or die (mysql_error());
	while($row = mysql_fetch_array($result)){
		array_push($traumas, $row['name']);
	}

	$jsonWrapper = new stdClass();
	$jsonWrapper->traumas = $traumas;
$jsonReturn = json_encode($jsonWrapper);
echo $jsonReturn;


?>