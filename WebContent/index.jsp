<!DOCTYPE html>
<html>
<head>
	<%@include file="/jsp/common.jsp"%>
	<title>CPTED_HOME</title>	
	<style type="text/css">

	</style>
	<script type="text/javascript">
		$(function() {
			
			sse();
		});
		
		function sse(){
			var source;
			if(typeof(EventSource) != 'undefined'){
				source = new EventSource('http://210.118.74.203:8081/SseServlet?param=accident');
				/*
				
				*/
				source.onmessage = function(event){
					//$('#time').html(event.data);
					console.log("Receive data : "+event.data);
					//resource 죽여야 할듯...
				};
				source.onerror = function(event){
				    //var txt;
				    switch( event.target.readyState ){
				        // if reconnecting
				        case EventSource.CONNECTING:
				            txt = 'Reconnecting...';
				            break;
				        // if error was fatal
				        case EventSource.CLOSED:
				            txt = 'Connection failed. Will not retry.';
				            source.close();
				            break;
				    }
				    console.log(txt);
				};
			}
			else{
				console.log("error:Not support server sent event your brower");
				
				alert("다른 브라우저를 이용해 주시기 바랍니다.");
				
				//$('time').html('this browser does not supported server-sent event');
			}	
		}
		
	
	</script>
</head>
<body>
	<%@include file="/jsp/header.jsp"%>	
	<div id="container">
		<div id="content" style="width: 1200px;height: 100%; background-image: url(img/test4.jpg); background-position:center; background-repeat: no-repeat; border:1px solid black;">
			<div style="width:200px; height:100%; margin-left:50px; background-color: yellow;">
				<ul>
					<li>aaa</li>
					<li>bbb</li>
					<li>ccc</li>
					<li>ddd</li>
					<li>eee</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
					<li>ddd</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="container">
		<table id="content" style="height: 300px;">
			<tr>
				<td><div style="width: 600px;height: 300px; background-color: red;"></div></td>
				<td><div style="width: 600px;height: 300px; background-color: orange;"></div></td>
			</tr>
		</table>
	</div>
	<%@include file="/jsp/footer.jsp"%>
</body>
</html>