<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
	<title>user story</title>
</head>

<body>
<jsp:include page="..//header.jsp" />

<form:form method="get" action="editdeletestory/${storyList.userstoryId}" modelAttribute="fulluserstory">
<div class="container">
<c:if test="${!empty storyList}">

		<table class="table">
		<tbody>
		
		
			<tr><th>User Story Id</th><td>${storyList.userstoryId}</td></tr>
			<tr><th>User Story Name</th><td>${storyList.userstoryname}</td></tr>			
			<tr><th>Status</th><td>${storyList.status}</td></tr>
			<tr><th>Assignee</th><td>${storyList.assignee}</td></tr>
			<tr><th>Priority</th><td>${storyList.priority}</td></tr>
			<tr><th>Pre requisites</th><td>${storyList.prerequisites}</td></tr>
			<tr><th>Narratives</th><td>${storyList.narratives}</td></tr>
			<tr><th>acceptance Criteria</th><td>${storyList.acceptancecriteria}</td></tr>
			<tr><th>Start Date</th><td>${storyList.startdate}</td></tr>
			<tr><th>End Date</th><td>${storyList.duedate}</td></tr>
		
			
			</tbody>
		
		</table>
		</c:if>
		<div>		
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit"  value="Edit"></input>
			<input id="deleteButton" class="btn-lg btn-primary pull-right" type="submit"  value="Delete"></input>
		</div>
		
		
		
		</div>
</form:form>
</body>
</html>