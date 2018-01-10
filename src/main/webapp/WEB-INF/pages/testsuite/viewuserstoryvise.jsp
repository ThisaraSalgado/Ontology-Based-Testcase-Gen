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
.heading{
	font-family:serif;
	font-weight: bold;
  	font-size:25px;
}
.id{
width:200px;
}

.content{
    width: 80%;
}
.table{
margin-left:15%; 
margin-right:15%;
background-color: #F8F8F8;
    }
th{
color: white;
background-color: olivedrab;
font-weight: bold;
font-family:serif;
font-size:20px;
}
td{
font-family:serif;
font-size:20px;
}
</style>
</head>
<body>
<jsp:include page="..//header.jsp" />
<div align="center" class="heading">
Epic Name- Group Management
</div>
<div class="content">
<table class="table">
		<thead>
			<tr>
				<th class="id">User Story Id</th>
				<th>User Story Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${userstorynames}">
			<tr>
			<td></td>
			<td> <a href="<c:url value='/viewtestcaseforselected/${item}'/>"><c:out value="${item}"/></a></td>
			<tr>
			</c:forEach>
			
			
			
			
			<tr>
			<td>1</td>
			<td ><a href="<c:url value='/viewtestcaseforselected' />">	As a Admin, I want to Create a user group to the system, so that I can add users.</a></td>
			</tr>
			<tr>
			<td>2</td>
			<td><a href="<c:url value='/viewtestcaseforselected' />">User Admin, need to be able to delete user groups in the system, so that I can manage groups easily</a></td>
			</tr>
			<tr>
			<td>3</td>
			<td><a href="<c:url value='/viewtestcaseforselected' />">As a User Admin, I need to be able to view users of groups in the system, so that I can manage users in groups easily.</a></td>
			</tr>
			<tr>
			<td>4</td>
			<td><a href="<c:url value='/viewtestcaseforselected' />">As a User Admin, I need to be able to list user groups in the system, so that I can manage user groups easily.</a></td>
			</tr>
			<tr>
			<td>5</td>
			<td><a href="<c:url value='/viewtestcaseforselected' />">As a User Admin, I need to be able to update an existing group in the system, so that I can manage users in that group easily</a></td>
			</tr>
			<tr>
			<td>6</td>
			<td><a href="<c:url value='/viewtestcaseforselected' />">	As a User Admin, I need to be able to view groups of a user in the system, so that I can manage users in groups easily.</a></td>
			</tr>
		
			
			
		
		</tbody>
</table>
</div>
</body>
</html>