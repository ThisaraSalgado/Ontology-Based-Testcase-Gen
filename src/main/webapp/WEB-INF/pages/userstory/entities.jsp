<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Entities</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="..//header.jsp" />
<form:form method="post">
<div class="container">
<c:if test="${!empty entity}">

		<table class="table">
		<thead>
			<tr>
				<th>Entities</th>
			</tr>
			</thead>
			
		<tbody>
			
			
				<tr>
				<c:forEach var="listValue" items="${entity}">
				
				<td><c:out value="${listValue}"/></td>	
				
				</c:forEach>
					 		
				</tr>
			
		</tbody>
		
		</table>
		
		</c:if>
		</div>
</form:form>
</body>
</html>