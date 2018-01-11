<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>

<head>
<title>home page</title>
<link href="${pageContext.request.contextPath}/resources/css/core/test.css"
    rel="stylesheet">


<style type="text/css">
#addButton{
    background: olivedrab;
    border: none;
    padding: 8px 10px 8px 10px;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    font-family:serif;
    position: absolute;
   left: 1250px;
    top: 100px
}



</style>
</head>
<body>
<jsp:include page="header.jsp" />


<%-- <h2>${message }</h2> --%>


		<form:form method="post" action="createnewstory" modelAttribute="commonModel">
		<c:forEach items="${storyList}" var="userstory">
		<form:hidden path="userstory.storyId"/>
		
		</c:forEach>
		<div class="addButton" >
				
				<input id="addButton" class="btn-lg" type="submit" name="actionButton" value="Create new Userstory"></input>
			</div>
			

		<jsp:include page="userstory/userstoryview.jsp" />

				
		</form:form>
	</div>		
	

</body>
</html>
