<?php
//  
	require 'connect.php';
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
			$query2 = "SELECT * FROM tour WHERE idnhanxet = 1 ";
			$sql2 = mysqli_query($con,$query2);
			$num2 = mysqli_num_rows($sql2);
			while ($row2 = mysqli_fetch_assoc($sql2)) {
				$ha = explode(",", $row2['img']);
				array_push($mang, new hienthi($row2['iddiadiem'], $row2['tendiadiem'], $row2['thongtindiadiem'], $row2['noidi'], $row2['idnhanxet'], $ha[0], $row2['diem'], $row2['danhgia'] ));	
			}	
		echo json_encode(array('search'=>$mang));
		
	//echo json_encode($_SESSION['id_destination']);
?>