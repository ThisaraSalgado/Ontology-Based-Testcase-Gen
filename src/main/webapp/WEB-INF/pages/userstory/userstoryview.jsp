<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user story</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="resources/css/core/test.css"
    rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript">
<%--
function selected(){
	var all_checked = document.querySelectorAll('input[name=checkbox]:checked');
	//document.write(all_checked.length);
	var selectedIds = [];

	for(var x = 0, l = all_checked.length; x < l;  x++)
	{
		selectedIds.push(all_checked[x].value);
	    //document.write(all_checked[x].value);
	}
	//JSON.stringify(selectedIds);
	//$("#ADOus").attr("action","${ctx}/ADSetting?myOUsArray ="+ selectedIds );
	//$("#ADOus").submit();
	return selectedIds; 
--%>	
}

</script>

<style>
form{
/*
border-style: solid;*/
    border-width: 5px;
background-color: #F8F8F8;
}
th{
color: white;
background-color: olivedrab;
font-weight: bold;
font-family:serif;
font-size:20px;
}
td.uId{
/*background-color: olivedrab;*/
font-family:serif;
font-weight: bold;
font-size:20px;
color:black;
}
td.uName{
font-family:serif;
font-size:20px;
color:white
}
td.uStatus{
font-family:serif;
color: green;
font-size:20px;
}
.container {
    position: relative;
    width: 80%;
}

#deleteAllButton{
    background: crimson;
    border: none;
    padding: 8px 40px 8px 40px;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-family:serif;
    position: absolute;
    left:1100px;
    top: 100px
}
.content{
	position: relative;
    width: 80%;
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


</head>
<body>


<form:form method="post" action="createnewstory" modelAttribute="commonModel">

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

<div class="container">
<%-- <div class="deletebutton">
<input id="deleteAllButton"  onClick="selected()" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Delete Selected"></input>
</div> --%>
<div class="content">


<c:if test="${!empty storyList}">
<div class="row">
<div class="col-md-12">
		<table class="table">
		<thead>
			<tr>
			
				<th>User Story Id</th>
				<th>User Story Name</th>
				<th>Status</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach items="${storyList}" var="userstory">
			
				<tr>
				<%-- <td class="checkbox"><input name="checkbox" type="checkbox" value="${userstory.storyId}" id="####" ></td> --%>
				<td class="uId"><c:out value="${userstory.storyId}"/></td>
				<td class="uName">
					 <a href="<c:url value='/viewuserstory/${userstory.storyId}'/>"><c:out value="${userstory.storyname}"/></a>
				</td>
				<td class="uStatus"><c:out value="${userstory.status}"/></td>	
					
				</tr>
		</c:forEach>		
		</tbody>
		
		</table>
		
		</c:if>
		</div>
		</div>
</form:form>
</body>
</html>