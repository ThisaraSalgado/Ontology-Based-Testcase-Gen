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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form method="post" action="createnewstory" modelAttribute="fulluserstory">
<div class="container">
<c:if test="${!empty storyList}">

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
					<td><c:out value="${userstory.userstoryId}"/></td>
					 <td>
					 <a href="<c:url value='/viewuserstory/${userstory.userstoryId}'/>"><c:out value="${userstory.userstoryname}"/></a>
					 </td>
					<td><c:out value="${userstory.status}"/></td>	
					
				</tr>
		</c:forEach>		
		</tbody>
		
		</table>
		<%-- 
			<a href="<c:url value='/edit/${userstory.userstoryId}'/>">EDIT</a>
			<a href="<c:url value='/delete/${userstory.userstoryId}'/>">DELETE</a> --%>
		</c:if>
		</div>
</form:form>
</body>
</html>