<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Suite</title>
</head>
<body>
<jsp:include page="..//header.jsp" />
	<c:url var="action" value="/jenatest"></c:url>
	<form:form method="get" action="${action}">
	<div>
			${result}
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Local Retrieval" /> 
			<input type="submit" class="btn-lg btn-primary" name="actionButton" value="Hosted Retrieval" />
	</div>
	</form:form>
Collection of Test cases
</body>
</html>