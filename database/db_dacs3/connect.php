<?php
	$severname = "localhost";
	$username = "root";
	$password = "";
	$dbname = "kiuty";
	$con = mysqli_connect($severname, $username, $password, $dbname);
	mysqli_set_charset($con, 'UTF8');
	if (!$con) {
		die('Kết nối thất bại'.mysqli_connect_error());
	}
	else{
		/*$query="SELECT * from tour";
		$data = mysqli_query($con, $query);

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
		while ($row = mysqli_fetch_assoc($data)) {
			array_push($mang, new hienthi($row['iddiadiem'], $row['tendiadiem'], $row['thongtindiadiem'], $row['noidi'], $row['idnhanxet'], $row['img'], $row['diem'], $row['danhgia'] ));
		}
		echo json_encode($mang);*/
	}
?>