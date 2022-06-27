<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Marker Animations</title>
<style>
  #map {
	 height: 100%;
	 width: 100%;
}

 #map-section {
	 position: relative;
	 height: 450px;
	 width: 100%;
}

 #map img {
	  max-width: none;
}
</style>
</head>
<body>
	<section id="map-section">
		<div id="map">
			<script>
				           var marker;
				function initMap() {
					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 13,
						scrollwheel : false,
						center : {
							lat : 37.593987,
							lng : 127.1557148
						},
						mapTypeId : 'roadmap'
					});
					marker = new google.maps.Marker(
							{
								title : '최고집이사',
								infoWindow : {
									content : '<p><strong>포장이사전문업체</strong><br/>경기도 구리시 수택동 883<br/>대표전화: 1666-2498<br/>대한민국</p>'
								},
								map : map,
								draggable : true,
								animation : google.maps.Animation.DROP,
								position : {
									lat : 37.593987,
									lng : 127.1557148
								}
							});
					marker.addListener('click', toggleBounce);
				}
				function toggleBounce() {
					if (marker.getAnimation() !== null) {
						marker.setAnimation(null);
					} else {
						marker.setAnimation(google.maps.Animation.BOUNCE);
					}
				}	      
			</script>
			   
			<script
				src="https://maps.googleapis.com/maps/api/js?key=4a4c8ea2f330496dd1e6dd7d6ce57e4f&callback=initMap">
				   
			</script>
			 
		</div>
	</section>
	   
</body>
</html>
