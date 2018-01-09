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
<form:form method="post" action="testcaseview" ModelAttribute="testcase">
<div align="center" class="heading"><p>Add New Group</p></div>
<div class="content">
<table class="table" width="600">
<col width="10">
  <col width="30">
  <col width="580">
  <col width="80">
  <col width="80">
		<thead>
			<tr>
			<th></th>
				<th>Test Case ID</th>
				<th>Test Case</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td class="checkbox"><input name="checkbox" type="checkbox"  id="####" ></td>
			<td>1</td>
			<td >Create a group with valid name</td>
			<td width>
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Edit"></input>
		<td>
			</tr>
			<tr>
			<td class="checkbox"><input name="checkbox" type="checkbox"  id="####" ></td>
			<td>2</td>
			<td >Create a group, name with special characters</td>
			<td>
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Edit"></input>
		<td>
			</tr>
			<tr>
			<td class="checkbox"><input name="checkbox" type="checkbox"  id="####" ></td>
			<td>3</td>
			<td >Create a group name with numeric characters</td>
			<td>
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Edit"></input>
		<td>
			</tr>
			<tr>
			<td class="checkbox"> <input name="checkbox" type="checkbox"  id="####" ></td>
			<td>4</td>
			<td >Create a group with lengthy name</td>
			<td>
			<input id="editButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Edit"></input>
		<td>
			</tr>
			<tr>
			<td></td>
			<td></td>
			<td ></td>
			<td></td>
			<td>
			<input id="addButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="+"></input>
		<td>
			</tr>
		</tbody>
		
</table>
</div>

		<div>
			<input id="deleteButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Delete"></input>
		</div>
		
		<div>
			<input id="sendButton" class="btn-lg btn-primary pull-right" type="submit" name="actionButton" value="Send For Approve"></input>
		</div>
	
		
	</form:form>	
</body>
</html>