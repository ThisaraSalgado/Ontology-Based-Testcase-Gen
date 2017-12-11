<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/core/css/hello.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
<style>
form {
  /* Just to center the form on the page */
  margin: 0 auto;
  width: 800px;
  /* To see the outline of the form */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
}

form div + div {
  margin-top: 1em;
}

label {
  /* To make sure that all labels have the same size and are properly aligned */
  display: inline-block;
  width: 120px;
  text-align: right;
}

input, textarea {
  /* To make sure that all text fields have the same font settings
     By default, textareas have a monospace font */
  font: 1em sans-serif;

  /* To give the same size to all text fields */
  width: 300px;
  box-sizing: border-box;

  /* To harmonize the look & feel of text field border */
  border: 1px solid #999;
}

input:focus, textarea:focus {
  /* To give a little highlight on active elements */
  border-color: #000;
}

textarea {
  /* To properly align multiline text fields with their labels */
  vertical-align: top;

  /* To give enough room to type some text */
  height: 5em;
}

.button {
  /* To position the buttons to the same position of the text fields */
  padding-left: 90px; /* same size as the label elements */
}

button {
  /* This extra margin represent roughly the same space as the space
     between the labels and their text fields */
  margin-left: .5em;
}

.styleheading{
    font-weight: bold;
    font-style: italic;
    border-bottom: 2px solid #ddd;
    margin-bottom: 20px;
    font-size: 15px;
    padding-bottom: 3px;
    }
</style>
<title>User Story Template</title>
</head>
<body>
<jsp:include page="..//header.jsp" />

	<c:url var="action" value="/addnewstory"></c:url>

	<form:form method="post" action="${action}" modelAttribute="fulluserstory">
	<div>
	
		<div class=".styleheading">User Story Form</div>
		<div>
			<form:label  path="userstoryname">User Story Name </form:label>
			<form:textarea path="userstoryname"/>
		</div>
		
		<div>
			<form:label path="assignee">Assignee</form:label>
			<form:input path="assignee"/>
		</div>
		
		<div>
			<form:label path="status">Status</form:label>
			<form:input path="status"/>
		</div>
		
		<div>
			<form:label path="priority">Priority</form:label>
			<select id="job" name="field4">
			  <option value="High">High</option>
  			  <option value="Medium">Medium</option>
  			  <option value="Low">Low</option>
  			 </select>
		</div>
		
		<div>
			<form:label path="prerequisites">Pre requisites</form:label>
			<form:textarea path="prerequisites"/>
		</div>
		
		<div>
			<form:label path="narratives">Narratives</form:label>
			<form:textarea path="narratives"/>
		</div>
		
		<div>
			<form:label path="acceptancecriteria">Acceptance Criteria</form:label>
			<form:textarea path="acceptancecriteria"/>
		</div>
		
		<div>
			<form:label path="startdate">Start date</form:label>
			<form:input type="date" name="startdate" path="startdate"/>
		</div>
		
		<div>
			<form:label path="duedate">Due date</form:label>
			<form:input type="date" name="duedate"  path="duedate"/>
		</div>
    
		</div>
		<br></br>

		<div>
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Save" /> 
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Save and Generate" />
		</div>

	</form:form>

</body>
</html>