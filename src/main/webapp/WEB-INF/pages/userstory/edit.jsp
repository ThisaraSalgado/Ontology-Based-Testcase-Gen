<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>

<title>User Story Template</title>
</head>
<body>
<jsp:include page="..//header.jsp" />
<h3>User Story Form</h3>

	<c:url var="action" value="/updatestory/${userstory.storyId}"></c:url>
	
	<form:form method="post" action="${action}" modelAttribute="commonModel">
	<div>
	<table class="table">
		<tr>
			<form:hidden path="userstory.storyId"/>
			<td><form:label  path="userstory.storyname">User Story Name </form:label></td>
			<td><form:textarea path="userstory.storyname"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.assignee">Assignee</form:label></td>
			<td><form:input path="userstory.assignee"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.status">Status</form:label></td>
			<td><form:input path="userstory.status"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.priority">Priority</form:label></td>
			<td><form:input path="userstory.priority"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.prerequites">Pre requisites</form:label></td>
			<td><form:textarea path="userstory.prerequites"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.narratives">Narratives</form:label></td>
			<td><form:textarea path="userstory.narratives"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.acceptancecritirea">Acceptance Criteria</form:label></td>
			<td><form:textarea path="userstory.acceptancecritirea"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.startdate">Start date</form:label></td>
			<td><form:input path="userstory.startdate"/></td>
		</tr>
		
		<tr>
			<td><form:label path="userstory.duedate">Due date</form:label></td>
			<td><form:input path="userstory.duedate"/></td>
		</tr>
		
	</table>
	</div>
	<br></br>
	
	<div>	
			<input type="submit" class="btn-lg btn-primary" value="Save"/>
		
			<input type="submit" class="btn-lg btn-primary" value="Save and Generate"/>
		
		</div>
	
	</form:form>

</body>
</html>