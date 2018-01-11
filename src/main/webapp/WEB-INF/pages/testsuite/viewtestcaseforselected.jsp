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
	#editButton{
	background: midnightblue;
    border: none;
    padding: 8px 10px 8px 10px;
    border-radius: 25px;
    margin-right: 30px;
    /*margin-left: 50px;*/
    color: white;
    font-weight: bold;
    font-family:serif;
	}
	#sendButton{
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
</style>

</head>
<body>
<jsp:include page="..//header.jsp" />
<form:form method="post"  ModelAttribute="commonModel">
<div align="center" class="heading"><p></p></div>
<div class="content">
<table class="table" width="600">


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

	
		
	</form:form>	
</body>
</html>