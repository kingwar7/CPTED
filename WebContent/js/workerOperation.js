var i=0;

function getMakerData(data)
{
	//i=i+1;
	//postMessage(data);
	setTimeout("getMakerData()",500);
}

//getMakerData();


self.onmessage = function( event ){
	postMessage(event);
	//postMessage( getMakerData( event.data ) );
}


/*
nowNorthEastLat,nowNorthEastLng,nowSouthWestLat,nowSouthWestLng,reqNorthEastLat,reqNorthEastLng,reqSouthWestLat,reqSouthWestLng
*/