<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>ONTOLOGY BASED TEST CASE GENERATION</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<%-- <spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" /> --%>

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">ONTOLOGY BASED TEST CASE GENERATION</a>
		</div>
		
		<ul class="nav navbar-nav">
		<li class="active"><a href="#">User Story</a></li>
		<li><a href="testhome.jsp">Test Suite</a></li>
		</ul>
	</div>
</nav>