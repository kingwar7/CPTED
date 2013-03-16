//object를 json으로 바꾸는 함수
function objToJson(obj){
	var json={};
	for(var memberField in obj){
		if(obj.hasOwnProperty(memberField)){
			json[memberField]=obj[memberField];
		}
	}
	return json;
}	

function JsonToString(obj){
	JsonData=JSON.stringify(obj);
	return jQuery.parseJSON(JsonData);			
}