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
function checkedList(){
	a=["12","14","22"];
	var boxes = $('input[name=checkbox]:checked').attr("id");
	//var boxes = $('input[name=checkbox]:checked')
	//document.write($boxes.attr("id"));
	
	//if ($('input[type=checkbox]').is(':checked')){
		//var id=$(this).attr( "id" )
		//a.push(id);
		//document.write("inside if");
	//}
	for(i=0; i<boxes.length; i++){
		document.write(boxes[i]);
	}
	//}
	return a;
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
}
td.uId{
/*background-color: olivedrab;*/
font-family:serif;
font-weight: bold;
color:black;
}
td.uName{
font-family:serif;
color:white
}
td.uStatus{
font-family:serif;
color: green;
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

</style>


</head>
<body>
<form:form method="post" action="createnewstory" modelAttribute="fulluserstory">
<div class="container">
<div class="deletebutton">
<input id="deleteAllButton"  class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Delete Selected"></input>
</div>
<div class="content">
<c:if test="${!empty storyList}">

		<table class="table">
		<thead>
			<tr>
			<th></th>
				<th>User Story Id</th>
				<th>User Story Name</th>
				<th>Status</th>
			</tr>
			</thead>
			
		<tbody>
			<c:forEach items="${storyList}" var="userstory">
			
				<tr>
				<td class="checkbox"><input name="checkbox" type="checkbox" value="${userstory.userstoryId}" id="####" ></td>
				<td class="uId"><c:out value="${userstory.userstoryId}"/></td>
				<td class="uName">
					 <a href="<c:url value='/viewuserstory/${userstory.userstoryId}'/>"><c:out value="${userstory.userstoryname}"/></a>
				</td>
				<td class="uStatus"><c:out value="${userstory.status}"/></td>	
					
				</tr>
		</c:forEach>		
		</tbody>
		
		</table>
		<%-- 
			<a href="<c:url value='/edit/${userstory.userstoryId}'/>">EDIT</a>
			<a href="<c:url value='/delete/${userstory.userstoryId}'/>">DELETE</a> --%>
		</c:if>
		</div>
		</div>
</form:form>
</body>
</html>