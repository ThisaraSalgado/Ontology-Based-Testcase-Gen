<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temp View</title>
<style>
body{
      padding-top: 60px;
      padding-bottom: 40px;
      }

.bs-example {
  margin: 20px;
}
</style>
</head>
<body>
<jsp:include page="..//header.jsp" />
<div class="container">	
<div class="bs-example"> 
      <!-- Example row of columns -->
      <div class="row">
        <div class="span4 c=-llapse-group">
          <h2>Heading</h2>
           <p class="collapse" id="viewdetails">Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn" data-toggle="collapse" data-target="#viewdetails">View details &raquo;</a></p>
        </div>
      </div>
      </div>
</body>
</html>