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

<jsp:include page="navbar.jsp" />