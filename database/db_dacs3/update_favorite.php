<?php
//  
	require 'connect.php';
	$i = intval($_POST['i']);
	$id_destination = $_POST['id'] ;
	class hienthi
	{
		function hienthi($id, $destination, $infor, $city, $rating, $img, $point, $comments)
		{
			$this->id = $id;
			$this->destination = $destination;
			$this->infor = $infor;
			$this->city = $city;
			$this->rating = $rating;
			$this->img = $img;
			$this->point = $point;
			$this->comments = $comments;
		}
	}
	$mang = array();
		$query = "UPDATE tour SET idnhanxet = '$i' WHERE iddiadiem = '$id_destination'";
		mysqli_query($con,$query);
		
?>