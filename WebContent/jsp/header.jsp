<script type="text/javascript">
	function goNextPage(nextPage){
		$("#nextPage").val(nextPage);
		//$("#nextPageForm").attr("action","/"+nextPage);
		$("#nextPageForm").submit();
	}
</script>

<div style="width: 100%;height: 100px; background-color: red">
	<p onclick="goNextPage('receiveAccident')">receiveAccident</p>
	
	
	<form id="nextPageForm" action="/MovePageServlet" method="get">
		<input type="hidden" name="nextPage" id="nextPage" value=""/>
	</form>
</div>