<!DOCTYPE html>
<html>
<head>
	<%@include file="/jsp/common.jsp"%>
	<title>CPTED_HOME</title>	
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&sensor=SET_TO_TRUE_OR_FALSE">
    </script>
    <script type="text/javascript">
      function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
      }
    </script>
</head>
<body onload="initialize()">
	<%@include file="/jsp/header.jsp"%>	
    <div id="map_canvas" style="width:100%; height:100%"></div>
	<%@include file="/jsp/footer.jsp"%>
</body>
</html>