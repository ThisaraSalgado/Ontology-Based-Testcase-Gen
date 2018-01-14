<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Suite</title>
<style>

caption { 
    display: table-caption;
    text-align: center;
}

.heading{
	font-family:serif;
	font-weight: bold;
  	font-size:25px;
}
.content{
width: 80%;
}


.table{
margin-left:15%; 
margin-right:15%;
font-family:serif;
font-weight: bold;
background-color: #F8F8F8;
    }
    
#addButton{
background: olivedrab;
    border: none;
    padding: 8px 10px 8px 10px;
    border-radius: 25px;
    margin-right: 30px;
    font-weight: bold;
}    
#deletebutton{
	 background: crimson;
    border: none;
    padding: 8px 30px 8px 30px;
    border-radius: 5px;
    margin-right: 30px;
    color: white;
    font-weight: bold;
    font-family:serif;
	}	
	
	#addnew{
	background: olivedrab;
    border: none;
    padding: 8px 20px 8px 20px;
    border-radius: 5px;
    margin-right: 30px;
    color: white;
    font-weight: bold;
    font-family:serif;
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

.msgSuccess {
    color: green;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}
.msgError{

    color:red;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}
.msgInfo{

   color:blue;
    font-family: "Verdana", Times, serif;
    font-size: 15px;
    font-weight: bold;
    text-align: center;
}

</style>

</head>
<body>
<jsp:include page="..//header.jsp" />
<c:url var="action" value="/addnew/${storyId}"></c:url>
<form:form method="post"  action="${action}" ModelAttribute="commonModel">
<div align="center" class="heading"><p></p></div>
<div class="content">
<div>	
<c:if test="${not empty commonModel.message}">
    				<tr>
	        			<td colspan="2" class="msgSuccess" align="center">
	        				<c:set var="msgType" value="${commonModel.msgType}"/>  
	        				<c:if test="${msgType =='Error'}">
	        					<div class="msgError"><c:out value="${commonModel.message}"></c:out></div>
	        				</c:if>
	        				<c:if test="${msgType =='Success'}">
	        					<div class="msgInfo"><c:out value="${commonModel.message}"></c:out></div>
	        				</c:if>
	        			</td>
	        		</tr>
        </c:if>
</div>

<table class="table" width="600">
<%-- <caption>Test cases for "${userstoryname}"</caption> --%>

		<thead>
			<tr>
				<th>Test Case ID</th>
				<th>Test Case</th>
				<th>Status</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${testcaseList}">
		<tr>
		
		<td class="tID"><c:out value="${item.testcase_id}"></c:out></td>
		<td class="tName"><a href="<c:url value='/testcaseview/${item.testcase_id}'/>"><c:out value="${item.testcase_name }"></c:out> </a>  </td>
		<td class="tStatus"><c:out value="${item.status}"></c:out> </td>
		</tr>
		</c:forEach>
		</tbody>
		
</table>
</div>
<div class="row">
<div class="col-md-10"></div>
<div class="col-md-2">
			<input align="right" id="addnew" type="submit" class="btn-lg" name="actionButton" value="Add New" /> </div>

	</div>
		
	</form:form>	
</body>
</html>