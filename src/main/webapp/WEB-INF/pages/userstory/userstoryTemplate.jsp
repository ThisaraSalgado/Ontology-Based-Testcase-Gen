<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/core/css/hello.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
<script>
function saveButton(){
	$("#saveButtonmod").modal();
}
</script>

<style>
form {
  /* Just to center the form on the page */
  margin: 0 auto;
  width: 850px;
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
  width: 240px;
  text-align: right;
  font-family:serif;
  font-weight: bold;
  font-size:20px;
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
    font-size: 25px;
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
    font-size: 20px;
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
    width: 250px;
}

.msgSuccess {
    color: green;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}
.msgError{

    color:red;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}
.msgInfo{

   color:blue;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}


</style>

<title>User Story Template</title>
</head>
<body>
<jsp:include page="..//header.jsp" />

	<c:url var="action" value="/addnewstory"></c:url>

	<form:form name="template" method="post" action="${action}"  modelAttribute="commonModel">
	<div>
	<div>	
<c:if test="${not empty commonModel.message}">
    				<tr>
	        			<td colspan="2" class="msgSuccess" align="center">
	        				<c:set var="msgType" value="${commonModel.msgType}"/>  
	        				<c:if test="${msgType =='Error'}">
	        					<div class="msgError"><c:out value="${commonModel.message}"></c:out></div>
	        				</c:if>
	        				<c:if test="${msgType =='Success'}">
	        					<div class="msgInfo"><c:out value="${commonModel.message}"></c:out></div>
	        				</c:if>
	        			</td>
	        		</tr>
        </c:if>
</div>
		<div align="center" class="styleheading">User Story Form</div>
		
		
		<div>
			<form:label path="userstory.epic.Epic_ID">Epic Name</form:label>
			<form:select path="userstory.epic.Epic_ID">
       		    <c:forEach var="item" items="${epicList}">
       				<option value="${item.epic_ID}">${item.epicname}</option>
   				</c:forEach>
    		</form:select>
		</div>
		
			<form:label  path="userstory.storyname">User Story Name </form:label>
			<form:textarea name="storyname" path="userstory.storyname" />

		</div>
		
		<div>
			<form:label path="userstory.assignee">Assignee</form:label>
			<form:input path="userstory.assignee"/>
		</div>
		
		
		<div>
			<form:label path="userstory.priority">Priority</form:label>
			<form:select path="userstory.priority">
			  <option value="High">High</option>
  			  <option value="Medium">Medium</option>
  			  <option value="Low">Low</option>
  			 </form:select>
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
		
		<div class="button">
		<div align="center">
			<input align="right" id="save" type="submit" class="btn-lg" name="actionButton" value="Save" /> 
		
		
			<input id="savegenerate" type="button" class="btn-lg" value="Save and Generate" onclick="javascript:saveButton()"/>
		</div>
		</div>
		
		<!-- Modal for the Save and Generate button -->
<div class="modal fade" id="saveButtonmod" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirm test case generate</h4>
      </div>
      <div class="modal-body">
        Confirm generating test cases for this user story?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
        <button id="sendButton" type="submit" class="btn btn-primary"  value="Save and Generate" name="actionButton"> Confirm </button>
      </div>
    </div>
  </div>
</div>	
		
	</form:form>

</body>
</html>