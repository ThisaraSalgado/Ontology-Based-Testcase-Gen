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
}
</style>
<title>User Story Template</title>
</head>
<body>
<jsp:include page="..//header.jsp" />

	<c:url var="action" value="/addnewstory"></c:url>

	<form:form method="post" action="${action}" modelAttribute="commonModel">
	<div>
		<div align="center" class="styleheading">User Story Form</div>
		
		<div>
			<form:label path="userstory.epic.Epic_ID">Epic Name</form:label>
			<form:select path="userstory.epic.Epic_ID">
       		    <c:forEach var="item" items="${epicList}">
       				<option value="${item.epic_ID}">${item.epicname}</option>
   				</c:forEach>
    		</form:select>
		</div>
		
		
		<%-- <div>
			<form:label path="userstory.Epic_ID">Epic No</form:label>
			<select id="epic" name="epic">
			  <option value="1">Group Management</option>
  			  <option value="2">User Management</option>
  			 </select>
		
		<div> --%>
			<form:label  path="userstory.storyname">User Story Name </form:label>
			<form:textarea path="userstory.storyname"/>
		</div>
		
		<div>
			<form:label path="userstory.assignee">Assignee</form:label>
			<form:input path="userstory.assignee"/>
		</div>
		
		<div>
			<form:label path="userstory.status">Status</form:label>
			<form:input path="userstory.status"/>
		</div>
		
		<div>
			<form:label path="userstory.priority">Priority</form:label>
			<select id="job" name="field4">
			  <option value="High">High</option>
  			  <option value="Medium">Medium</option>
  			  <option value="Low">Low</option>
  			 </select>
		</div>
		
		<div>
			<form:label path="userstory.prerequites">Pre requisites</form:label>
			<form:textarea path="userstory.prerequites"/>
		</div>
		
		<div>
			<form:label path="userstory.narratives">Narratives</form:label>
			<form:textarea path="userstory.narratives"/>
		</div>
		
		<div>
			<form:label path="userstory.acceptancecritirea">Acceptance Criteria</form:label>
			<form:textarea path="userstory.acceptancecritirea"/>
		</div>
		
		<div>
			<form:label path="userstory.startdate">Start date</form:label>
			<form:input type="date" name="startdate" path="userstory.startdate"/>
		</div>
		
		<div>
			<form:label path="userstory.duedate">Due date</form:label>
			<form:input type="date" name="duedate"  path="userstory.duedate"/>
		</div>
    
		</div>
		<br></br>
		<div class="button">
		<div>
			<input align="right" id="save" type="submit" class="btn-lg" name="actionButton" value="Save" /> 
		</div>
		<div>	
			<input id="savegenerate" type="submit" class="btn-lg" name="actionButton" value="Save and Generate" />
		</div>
		</div>
	</form:form>

</body>
</html>