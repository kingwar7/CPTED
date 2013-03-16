var mapsWorker;

function initWorker(){
	if(typeof(Worker)!=="undefined"){
		if(typeof(mapsWorker)=="undefined"){
			mapsWorker=new Worker("/js/workerOperation.js");
			mapsWorker.addEventListener("message", messageHandler, true);
			mapsWorker.addEventListener("error", errorHandler, true);
			postMessage();
		}	
	}
	else{
		console.log("Sorry, your browser does not support Web Workers...");
	}
}


function messageHandler(e) {
    console.log("worker messageHandler data : "+e.data);
}
function errorHandler(e) {
    console.log("worker errorHandler data : "+e.message, e);
}
function stopWorker(){ 
	w.terminate();
}
function postMessage(){	
	mapsWorker.postMessage(nowNorthEastLat,nowNorthEastLng,nowSouthWestLat,nowSouthWestLng,reqNorthEastLat,reqNorthEastLng,reqSouthWestLat,reqSouthWestLng);
}