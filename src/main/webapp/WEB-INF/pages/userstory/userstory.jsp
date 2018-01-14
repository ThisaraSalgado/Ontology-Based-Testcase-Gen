<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>

<head>
<script>
function deleteButon(){
	//console.log("came");
	$("#deleteButtonmod").modal();
}
</script>
	
	<style>
	
	form{
	/*background-color: springgreen;*/
	background-color: #F8F8F8;
	position: relative;
	left: 150px;
    top: 50px;
    width: 80%;
	}
	th{
	font-family:serif;
	font-weight: bold;
	color:black;
	font-size:20px;
	}
	td{
	font-family:serif;
	color:black;
	font-size:20px;
	}	
	#deletebutton{
	 background: crimson;
    border: none;
    padding: 8px 30px 8px 30px;
    border-radius: 5px;
    margin-right: 30px;
    color: white;
    font-weight: bold;
    font-family:serif;
	}	
	#editButton{
	background: midnightblue;
    border: none;
    padding: 8px 40px 8px 40px;
    border-radius: 5px;
    margin-right: 30px;
    /*margin-left: 50px;*/
    color: white;
    font-weight: bold;
    font-family:serif;
	}
	#generateButton{
	background: olivedrab;
    border: none;
    padding: 8px 20px 8px 20px;
    border-radius: 5px;
    margin-right: 30px;
    color: white;
    font-weight: bold;
    font-family:serif;
	}
	
	</style>
	<title>user story</title>
</head>

<body>
<jsp:include page="..//header.jsp" />

<form:form method="get" action="editdeletestory/${storyList.storyId}" modelAttribute="commonModel">
<div class="container">
<c:if test="${!empty storyList}">

		<table class="table">
		<tbody>
		
		
			<tr><th>User Story Id</th><td>${storyList.storyId}</td></tr>
			<tr><th>User Story Name</th><td>${storyList.storyname}</td></tr>			
			<tr><th>Status</th><td>${storyList.status}</td></tr>
			<tr><th>Assignee</th><td>${storyList.assignee}</td></tr>
			<tr><th>Priority</th><td>${storyList.priority}</td></tr>
			<tr><th>Pre requisites</th><td>${storyList.prerequites}</td></tr>
			<tr><th>Narratives</th><td>${storyList.narratives}</td></tr>
			<tr><th>acceptance Criteria</th><td>${storyList.acceptancecritirea}</td></tr>
			<tr><th>Start Date</th><td>${storyList.startdate}</td></tr>
			<tr><th>End Date</th><td>${storyList.duedate}</td></tr>
		
			
			</tbody>
		
		</table>
		</c:if>
		<div class="button">
		<div>
			<input id="deleteButton" class="btn-lg btn-primary pull-right" type="button" value="Delete" onclick="javascript:deleteButon()"></input>
		</div>
		<div>
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Edit"></input>
		</div>
		<div>
			<input id="generateButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Generate"></input>
		</div>
		</div>	
		
		</div>
		
				<!-- Modal for the delete button -->
<div class="modal fade" id=deleteButtonmod tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm delete</h4>
      </div>
      <div class="modal-body">
        Are you sure you want to delete this user story?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
        <button id="sendButton" type="submit" class="btn btn-primary"  value="Delete" name="actionButton"> Confirm </button>
      </div>
    </div>
  </div>
</div>	

</form:form>
</body>
</html>