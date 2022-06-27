<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	double x = (Double) request.getAttribute("lat");
	double y = (Double) request.getAttribute("lng");
	String point = (String) request.getAttribute("point");
	%>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=n7yw3r4itk&callback=initMap"></script>
    <script type="text/javascript">
        var map = null;

        function initMap() {
            map = new naver.maps.Map('map', {
                center: new naver.maps.LatLng(<%=x%>, <%=y%>),
                zoom: 18
            });
            var marker = new naver.maps.Marker({
                position: new naver.maps.LatLng(<%=x%>, <%=y%>),
                map: map
            });
        }
    </script>
    <div id="map" style="width:100%;height:400px;"></div>
    <div>
    	<p><b>주소 : </b>: <%=point%>
    	<p><b>위도 : </b>: <%=x%>
    	<p><b>경도 : </b>: <%=y%>
    </div>
    
</body>
</html>