<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4a4c8ea2f330496dd1e6dd7d6ce57e4f"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		function getInfo(){
			var center = map.getCenter();
		}
		
		var message = '위도 = ' + center.getLat() + '<br>';
		message += '경도 = ' + center.getLng()
	</script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
	<h2>gㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ</h2>
	
</body>
</html>