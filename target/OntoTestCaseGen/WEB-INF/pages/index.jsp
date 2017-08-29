<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>

<head>
<title>home page</title>
</head>
<body>
<jsp:include page="header.jsp" />

<%-- <h2>${message }</h2> --%>


		<form:form method="post" action="createnewstory" modelAttribute="fulluserstory">
		<form:hidden path="userstoryId"/>
		<div>
				
				<input id="addButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Create new Userstory"></input>
			</div>

		<jsp:include page="userstory/userstoryview.jsp" />

			

			
			
		</form:form>
	</div>		
	
	





</body>
</html>
