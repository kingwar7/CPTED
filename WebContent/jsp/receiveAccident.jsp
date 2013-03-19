
<!DOCTYPE html>
<html>
<head>
<!--  test123 -->
	<%@include file="/jsp/common.jsp"%>
	<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <!-- <script type="text/javascript" src="/js/webWorker.js"></script> -->
  	<script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript">

    	var longitude;//경도
    	var latitude;//위도
    	var accidentContent;//사건 내용
    	var nowLatlng;//현재 위치 이 값은 반드시 경위도 값이 들어온다는 전제임
    	var nearbyUser;//사건 근처의 사용자들
    	var nearbyUserMaker=[];//사건 근처의 사용자들의 마커 객체
    	var userMaker;//사용자의 마커 객체
    	var map;//google maps 객체
    	
    	var nowNorthEastLat;//현재 지도상의 북동쪽 위도
		var nowNorthEastLng;//현재 지도상의 북동쪽 경도
		var nowSouthWestLat;//현재 지도상의 남서쪽 위도
		var nowSouthWestLng;//현재 지도상의 남서쪽 경도
		
		var initNorthEastLat=0;//현재 지도상의 북동쪽 위도
		var initNorthEastLng=0;//현재 지도상의 북동쪽 경도
		var initSouthWestLat=0;//현재 지도상의 남서쪽 위도
		var initSouthWestLng=0;//현재 지도상의 남서쪽 경도
		
		var reqNorthEastLat;//서버로 요청할 북동쪽 위도
		var reqNorthEastLng;//서버로 요청할 북동쪽 경도
		var reqSouthWestLat;//서버로 요청할 남서쪽 위도
		var reqSouthWestLng;//서버로 요청할 남서쪽 경도
		
    	
    	
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
			clickAccident();//사건 클릭시 수행하는 함수
			
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
			
			
			mapsEventAddListener();//지도의 범위가 변경시 수행하는 함수	
			
			nearbyUser=new Array();
			
			for(var i=0; i<data.personTotal;i++){
				nearbyUser.push(new google.maps.LatLng(data.personData[i].longitude , data.personData[i].latitude));				
			}
			
			dropNearByUser();//마커 떨구는 수행함수
			
			
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
		//사용자 근처에 약간의 인터벌을 두고 마커 떨구기 함수
		function dropNearByUser() {
			iterator=0;
			for (var i = 0; i < nearbyUser.length; i++) {
				setTimeout(function() {
					addMarker();
				}, i * 200);
			}
		}
		//실제 마커 떨구면서 속성값 부여하는 함수
		function addMarker() {
			nearbyUserMaker.push(new google.maps.Marker({
				position: nearbyUser[iterator],
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP,
				title: data.personData[iterator].type
			}));
			iterator++;
		}
		
		
		
		//google maps에 이벤트 등록 함수
		function mapsEventAddListener(){
			//현재 지도의 바운드(범위)를 리스너 등록
			google.maps.event.addListener(map, 'bounds_changed', function() {
				//console.log (map.getBounds().getNorthEast().lat()+" / "+map.getBounds().getNorthEast().lng()+"|"+map.getBounds().getSouthWest().lat()+" / "+map.getBounds().getSouthWest().lng());
				var bounds=map.getBounds();
				//현재 지도 범위
				nowNorthEastLat=bounds.getNorthEast().lat();
				nowNorthEastLng=bounds.getNorthEast().lng();
				nowSouthWestLat=bounds.getSouthWest().lat();
				nowSouthWestLng=bounds.getSouthWest().lng();
				//요청 할 지도 범위
				reqNorthEastLat=nowNorthEastLat+0.01;
				reqNorthEastLng=nowNorthEastLng+0.01;
				reqSouthWestLat=nowSouthWestLat-0.01;
				reqSouthWestLng=nowSouthWestLng-0.01;
				
				mapsInitBounds();
			});
			//google.maps.event.addListenerOnce(map, 'idle', function(){
		    //    alert(this.getBounds());
		    //});
		}
		
		//데이터 갱신되기 전의 maps 경계선 init하는 함수
		function mapsInitBounds(){
			//max바운드가 정의되어있지 않으면 req 데이터 세팅
			if(initNorthEastLat == 0 || initNorthEastLng == 0 || initSouthWestLat == 0 || initSouthWestLng == 0){
				initNorthEastLat=reqNorthEastLat;
				initNorthEastLng=reqNorthEastLng;
				initSouthWestLat=reqSouthWestLat;
				initSouthWestLng=reqSouthWestLng;
			}
			//console.log(nowNorthEastLat +","+ initNorthEastLat +","+ nowNorthEastLng +","+ initNorthEastLng +" \n "+ nowSouthWestLat +","+ initSouthWestLat +","+ nowSouthWestLng +","+ initSouthWestLng);
			
			
			if(nowNorthEastLat > initNorthEastLat || nowNorthEastLng > initNorthEastLng || nowSouthWestLat < initSouthWestLat || nowSouthWestLng < initSouthWestLng){
				
				initNorthEastLat=reqNorthEastLat;
				initNorthEastLng=reqNorthEastLng;
				initSouthWestLat=reqSouthWestLat;
				initSouthWestLng=reqSouthWestLng;	
				
				var latLngObj={'northEastLat':reqNorthEastLat,'northEastLng':reqNorthEastLng,'southWestLat':reqSouthWestLat,'southWestLng':reqSouthWestLng};			
				var latLngObjJson=JSON.stringify(latLngObj);	
				
				$.post("MarkerServlet",{"data": latLngObjJson},function(data){
					console.log("maker load");
					//여기서 마커 찍는 함수 호출 두둥!!!
				}, "json");
			}			
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
		//test
		
		
	
		
		
		
		//initialize 함수 binding
		google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body lang="ko">
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
					 <c:forEach var="cnt" begin="0" end = "1">
						<li class="accident" longitude="${AccidentEmergencylist[cnt].longitude}" latitude="${AccidentEmergencylist[cnt].latitude}">"${AccidentEmergencylist[cnt].content}"</li>			
					 </c:forEach>
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