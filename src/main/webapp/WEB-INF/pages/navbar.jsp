<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Ontology Based Test Case Generation</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value='/backtouserstory'/>">User Story</a></li>
			<li><a href="<c:url value='/testhome'/>">Test Suite</a></li>
			
		</ul>
	</div>
</nav>