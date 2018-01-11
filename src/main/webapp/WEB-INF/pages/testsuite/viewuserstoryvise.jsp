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
			<c:forEach var="item" items="${userstory}">
			<tr>
			<td class="uId"><c:out value="${item.storyId}"/></td>
			<td class="uName"> <a href="<c:url value='/viewtestcaseforselected/${item.storyId}'/>"><c:out value="${item.storyname}"/></a></td>
			<tr>
			</c:forEach>
			
			
			
			
		
		</tbody>
</table>
</div>
</body>
</html>