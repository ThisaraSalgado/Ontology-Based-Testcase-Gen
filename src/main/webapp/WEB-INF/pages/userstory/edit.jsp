<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>

<title>User Story Template</title>

<style>
form {
  /* Just to center the form on the page */
  margin: 0 auto;
  width: 800px;
  /* To see the outline of the form */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
  background-color: #F8F8F8;
}

form div  {
  margin-top: 1em;
}

label {
  /* To make sure that all labels have the same size and are properly aligned */
  display: inline-block;
  width: 220px;
  text-align: right;
  font-family:serif;
  font-weight: bold;
  font-size:15px;
  padding: 8px 40px 8px 40px;
}

input, textarea {
  /* To make sure that all text fields have the same font settings
     By default, textareas have a monospace font */
  font: 1em serif;

  /* To give the same size to all text fields */
  width: 400px;
  box-shadow: 3px 3px 5px olivedrab;
  box-sizing: border-box;
  

  /* To harmonize the look & feel of text field border */
  border: 2px solid olivedrab;
  border-radius: 4px;
}

input:focus, textarea:focus {
  /* To give a little highlight on active elements */
  border-color: olivedrab;
}

textarea {
  /* To properly align multiline text fields with their labels */
  vertical-align: top;

  /* To give enough room to type some text */
  height: 5em;
}


.styleheading{
    background-color: olivedrab;
    border-bottom: 2px solid #ddd;
    margin-bottom: 20px;
    font-family:serif;
    font-weight: bold;
    /*font-style: italic;*/
    font-size: 20px;
    padding-bottom: 3px;
    color:white;
    }
    
     
    select {
    font-family: serif;
    font-weight: bold;
    width: 400px;
  	box-shadow: 3px 3px 5px olivedrab;
  	box-sizing: border-box;
    border-radius: 4px;
    font-size: 15px;
    color:#8a97a0;
    margin-bottom: 30px;
    border: 2px solid olivedrab;
  	border-radius: 4px;
    
}

#save,#savegenerate{
	
    background: olivedrab;
    border: none;
    padding: 8px 5px 8px 5px;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-family:serif;
    width: 200px;
    
}
h3{
font-weight: bold;
font-family:serif;

}
</style>
</head>
<body>
<jsp:include page="..//header.jsp" />


	<c:url var="action" value="/updatestory/${userstory.storyId}"></c:url>
	
	<form:form method="post" action="${action}" modelAttribute="commonModel">
	<div>
	<div align="center" class="styleheading">User Story Form</div>
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
	
	
	<div align="center">	
			<input align="right" type="submit" class="btn-lg " value="Save"/>
		
			<input type="submit" class="btn-lg" value="Save and Generate"/>
		
		</div>
	</div>
	</form:form>

</body>
</html>