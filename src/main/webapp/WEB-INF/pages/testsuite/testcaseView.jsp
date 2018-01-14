<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Suite</title>
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
    
   #save{
	
    background: olivedrab;
    border: none;
    padding: 8px 5px 8px 5px;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-family:serif;
    width: 250px;
} 
   
</style>
</head>
<body>
<jsp:include page="..//header.jsp" />
<c:url var="action" value="/updatetestcase/${testcase.testcase_id}"></c:url>
<form:form method="post" action="${action}" modelAttribute="commonModel" >
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
	<div align="center" class="styleheading">Test Case</div>
<%-- 	<div>
		<form:label path="testcase.testcase_id">Test case ID</form:label>
		<form:textarea path="testcase.testcase_id"/>
	</div> --%>
	<div>
	<form:label path="testcase.testcase_name">Test case</form:label>
		<form:textarea path="testcase.testcase_name"/>
	
	</div>
	<div>
	<form:label path="testcase.pre_condition">Pre Condition</form:label>
		<form:textarea path="testcase.pre_condition"/>
	
	</div>
	<div>
	<form:label path="testcase.expected_result">Expected Result</form:label>
		<form:textarea path="testcase.expected_result"/>
	
	</div>
	<div>
	<form:label path="testcase.status">Status</form:label>
		<form:textarea path="testcase.status"/>
	
	</div>
	<div>
	<form:label path="testcase.approveby">Approved By</form:label>
		<form:textarea path="testcase.approveby"/>
	
	</div>
	
	<div class="button">
		<div align="center">
			<input align="right" id="save" type="submit" class="btn-lg" name="actionButton" value="Save" /> 
		
		</div>
	</div>
	
</div>
</form:form>
</body>
</html>