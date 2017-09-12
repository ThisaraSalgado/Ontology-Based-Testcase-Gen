<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test case</title>
</head>
<body>
<jsp:include page="..//header.jsp" />
Test case view
</body>
<h3>Generated Test Case</h3>

	<c:url var="action" value="#"></c:url>
	
	<form:form method="post" action="${action}" modelAttribute="fulluserstory">
	<div>
	
	</div>
	<br></br>
	
	<div>	
			<input type="submit" class="btn-lg btn-primary" value="Save"/>
		
			<input type="submit" class="btn-lg btn-primary" value="Save and Generate"/>
		
		</div>
	
	</form:form>
</html>