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
  width: 800px;
  /* To see the outline of the form */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
  background-color: #F8F8F8;
}

.epicList{
font-family:serif;
font-weight: bold;
font-size:25px;
align:center;
}

.heading{
font-family:serif;
  font-weight: bold;
  font-size:30px;
}

</style>

</head>
<body>
<jsp:include page="..//header.jsp" />


	<form:form method="post" modelAttribute="commonModel" >
	<div>
	
		<div align="center" class="heading">Test Suite For:</div>
		<div class="epicList">
			<c:forEach var="item" items="${epicList}">
			<ul><a href="<c:url value="viewuserstoryvise/${item.epic_ID} "/>"> ${item.epicname}</a></ul>
			</c:forEach>
		</div>
	</div>
	</form:form>	


</body>
</html>