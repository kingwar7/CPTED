<!DOCTYPE html>
<html>
<head>
<!--  test123 -->
	<%@include file="/jsp/common.jsp"%>
	<title>CPTED_HOME</title>	
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
      .detailAccident{width:400px;float:left;}
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?v=3.9?key=AIzaSyCTNbzs5ZMEbnDxpi58ku_nsdWnE5fVZsk&sensor=false">
    </script>
    <script type="text/javascript">

    	var longitude;//경도
    	var latitude;//위도
    	var accidentContent;//사건 내용
    	var nowLatlng;//현재 위치 이 값은 반드시 경위도 값이 들어온다는 전제임
    	var nearbyUser;//사건 근처의 사용자들
    	var nearbyUserMaker=[];//사건 근처의 사용자들의 마커 객체
    	var userMaker;//사용자의 마커 객체
    	var map;//google maps 객체
    	
    	//test
    	var testJsonData;
    	var data;
    	//test    	
    	
		$(function() {
			//test
			testJson();//임의의 함수
			//test
						
			longitude=$("#totalAccident"+" li:first-child").attr("longitude");
			latitude=$("#totalAccident"+" li:first-child").attr("latitude");
			accidentContent=$("#totalAccident"+" li:first-child").text();
			clickAccident();
		});	
    	
		//map 초기화 함수
		function initialize() {
			nowLatlng = new google.maps.LatLng(longitude,latitude);			
			
			var mapOptions = {
				center : nowLatlng,
				zoom : 18,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);			
			
			userMaker = new google.maps.Marker({
			      position : nowLatlng,
			      map : map,
			      title :accidentContent,
			      draggable: false,
		          animation: google.maps.Animation.DROP
			});
			
			/*
			nearbyUser=[new google.maps.LatLng(52.511467, 13.447179),
				        new google.maps.LatLng(52.549061, 13.422975),
				        new google.maps.LatLng(52.497622, 13.396110),
				        new google.maps.LatLng(52.517683, 13.394393)];
			*/
			//nearbyUser=[new google.maps.LatLng(data.)];
			nearbyUser=new Array();
			for(var i=0; i<data.personTotal;i++){
				nearbyUser.push(new google.maps.LatLng(data.personData[i].longitude , data.personData[i].latitude));				
			}
			dropNearByUser();
			
			/*
			var circleOptions = {
					  center: nowLatlng,
					  radius: 25000000,
					  map: map,
					  editable: true
					};
					var circle = new google.maps.Circle(circleOptions);*/
		}	
		
		//accident click시 발동하는 함수
		function clickAccident(){			
			 $(".accident").click(function () { 
				longitude=$(this).attr("longitude");
				latitude=$(this).attr("latitude");
				accidentContent==$(this).html();
				initialize();
			 });
		}
		
		var iterator;
		
		function dropNearByUser() {
			iterator=0;
			for (var i = 0; i < nearbyUser.length; i++) {
				setTimeout(function() {
					addMarker();
				}, i * 200);
			}
		}
		
		function addMarker() {
			nearbyUserMaker.push(new google.maps.Marker({
				position: nearbyUser[iterator],
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP
			}));
			iterator++;
		}

		
		
		//test
		function testJson(){
			//test json
			var person1=new Object();
			person1.type="사용자";
			person1.id="a1";
			person1.longitude=37.5682136190272;
			person1.latitude=126.8222826719284;
			 
			var person2=new Object();
			person2.type="방범대";
			person2.id="b1";
			person2.longitude=37.56964652520678;
			person2.latitude=126.82428896427155;
			 
			var person3=new Object();
			person3.type="경찰관";
			person3.id="c1";
			person3.longitude=37.56890243790133;
			person3.latitude=126.82311952114105;
			 
			var person4=new Object();
			person4.type="사용자";
			person4.id="a2";
			person4.longitude=37.56770337871725;
			person4.latitude=126.82529747486115;
			//test json
			
			var jsonArr=new Array();
			
			jsonArr.push(objToJson(person1));
			jsonArr.push(objToJson(person2));
			jsonArr.push(objToJson(person3));
			jsonArr.push(objToJson(person4));
			
			var reMakeJson={"key":"test","personTotal":4,"personData":jsonArr};			
			testJsonData=JSON.stringify(reMakeJson);

			data = jQuery.parseJSON(testJsonData);			
			/*
			{
				"key":"test",
				"personData":[
				              {"type":"사용자","id":"a1","longitude":37.5682136190272,"latitude":126.8222826719284},
			         	      {"type":"방범대","id":"b1","longitude":37.56964652520678,"latitude":126.82428896427155},
			            	  {"type":"경찰관","id":"c1","longitude":37.56890243790133,"latitude":126.82311952114105},
			            	  {"type":"사용자","id":"a2","longitude":37.56770337871725,"latitude":126.82529747486115}
			            	 ]
			} 
			*/
		}
		
		function objToJson(obj){
			var json={};
			for(var memberField in obj){
				if(obj.hasOwnProperty(memberField)){
					json[memberField]=obj[memberField];
				}
			}
			return json;
		}
		//test
		
		
		//initialize 함수 binding
		google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>	
	<div id="container" style="width:100%; height:100%; background-color: yellow;">
   		<div id="content">
	   		<div id="map_canvas" style="width:800px; height:600px; float: left;"></div>
	    	<div style="width:400px; height:600px; overflow-y: scroll;">
	    		<ul id="totalAccident">
					<li class="accident" longitude="37.5678819632233" latitude="126.82389736175537">aaa</li>
					<li class="accident" longitude="37.554444" latitude="126.946158">bbb</li>
					<li class="accident" longitude="37.60304625955111" latitude="126.95502519607544">ccc</li>
					<li class="accident">ddd</li>
					<li class="accident">eee</li>
					<li class="accident">ddd1</li>
					<li class="accident">ddd2</li>
					<li class="accident">ddd3</li>
					<li class="accident">ddd4</li>
					<li class="accident">ddd5</li>
					<li class="accident">ddd6</li>
					<li class="accident">ddd7</li>
					<li class="accident">ddd8</li>
					<li class="accident">ddd9</li>
					<li class="accident">ddd10</li>
					<li class="accident">ddd11</li>
					<li class="accident">ddd12</li>
				</ul>
			</div>
			<div>
				<div class="detailAccident">
					<ul>
						<li class="accident" longitude="37.5678819632233" latitude="126.82389736175537">aaa</li>
						<li class="accident" longitude="37.554444" latitude="126.946158">bbb</li>
						<li class="accident" longitude="40.40168295492184" latitude="-3.7206101417541504">ccc</li>
					</ul>
				</div>
				<div class="detailAccident">
					<ul>
						<li class="accident" longitude="41.36473946201695" latitude="2.155594825744629">aaa</li>
						<li class="accident" longitude="37.554444" latitude="126.946158">bbb</li>
						<li class="accident" longitude="37.60304625955111" latitude="126.95502519607544">ccc</li>
					</ul>
				</div>
				<div class="detailAccident">
					<ul>
						<li class="accident" longitude="48.858242" latitude="2.294222">aaa</li>
						<li class="accident" longitude="37.554444" latitude="126.946158">bbb</li>
						<li class="accident" longitude="37.60304625955111" latitude="126.95502519607544">ccc</li>
					</ul>
				</div>
			</div>
		</div>
    </div>
	<%@include file="/jsp/footer.jsp"%>
</body>
</html>
<!--  
 onclick="initialize(37.5678819632233,126.82389736175537)"
 onclick="initialize(37.554444,126.946158)"
 onclick="initialize(37.60304625955111,126.95502519607544)"
 -->