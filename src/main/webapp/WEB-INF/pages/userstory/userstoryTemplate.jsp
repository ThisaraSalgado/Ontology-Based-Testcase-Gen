<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>

<title>User Story Template</title>
</head>
<body>
	<jsp:include page="..//header.jsp" />
	<h3>User Story Form</h3>

	<c:url var="action" value="/addnewstory"></c:url>

	<form:form method="post" action="${action}" modelAttribute="fulluserstory">
		<div>
			<table>
				<tr>
					<td><form:label path="userstoryname">User Story Name </form:label></td>
					<td><form:textarea path="userstoryname" /></td>
				</tr>

				<tr>
					<td><form:label path="assignee">Assignee</form:label></td>
					<td><form:input path="assignee" /></td>
				</tr>

				<tr>
					<td><form:label path="status">Status</form:label></td>
					<td><form:input path="status" /></td>
				</tr>

				<tr>
					<td><form:label path="priority">Priority</form:label></td>
					<td><form:input path="priority" /></td>
				</tr>

				<tr>
					<td><form:label path="prerequisites">Pre requisites</form:label></td>
					<td><form:textarea path="prerequisites" /></td>
				</tr>

				<tr>
					<td><form:label path="narratives">Narratives</form:label></td>
					<td><form:textarea path="narratives" /></td>
				</tr>

				<tr>
					<td><form:label path="acceptancecriteria">Acceptance Criteria</form:label></td>
					<td><form:textarea path="acceptancecriteria" /></td>
				</tr>

				<tr>
					<td><form:label path="startdate">Start date</form:label></td>
					<td><form:input path="startdate" /></td>
				</tr>

				<tr>
					<td><form:label path="duedate">Due date</form:label></td>
					<td><form:input path="duedate" /></td>
				</tr>

			</table>
		</div>
		<br></br>

		<div>
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Save" /> 
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Save and Generate" />
		</div>

	</form:form>

</body>
</html>