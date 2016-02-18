<?php

//Include Server Credentials File
include 'serverCredentials.php';

//Fields
$organization = 1;

$traumas = array();
$trauamaId = array();

mysql_connect($host, $dbUsername, $dbPassword, $db);
mysql_select_db($db);


$result = mysql_query("SELECT * FROM currenttrauma WHERE organizationId='$organization'") or die (mysql_error());
	while($row = mysql_fetch_array($result)){
		array_push($traumas, $row['name']);
		array_push($trauamaId, $row['id']);
	}

	$jsonWrapper = new stdClass();
	$jsonWrapper->traumas = $traumas;
	$jsonWrapper->ids = $trauamaId;
$jsonReturn = json_encode($jsonWrapper);
echo $jsonReturn;


?>